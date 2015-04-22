/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.json;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.apache.struts2.json.annotations.SMDMethod;
import org.apache.struts2.json.rpc.RPCError;
import org.apache.struts2.json.rpc.RPCErrorCode;
import org.apache.struts2.json.rpc.RPCResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.WildcardUtil;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Populates an action from a JSON string
 */
public class JSONInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 4950170304212158803L;
    private static final Logger LOG = LoggerFactory.getLogger(JSONInterceptor.class);
    private final boolean enableSMD = false;
    private final boolean enableGZIP = false;
    private boolean wrapWithComments;
    private boolean prefix;
    private String defaultEncoding = "ISO-8859-1";
    private final boolean ignoreHierarchy = true;
    private String root;
    private List<Pattern> excludeProperties;
    private List<Pattern> includeProperties;
    private final boolean ignoreSMDMethodInterfaces = true;
    private final JSONPopulator populator = new JSONPopulator();
    private final JSONCleaner dataCleaner = null;
    private final boolean debug = false;
    private final boolean noCache = false;
    private boolean excludeNullProperties;
    private String callbackParameter;
    private String contentType;

    @Override
    @SuppressWarnings("unchecked")
    public String intercept(final ActionInvocation invocation) throws Exception {
        final HttpServletRequest request = ServletActionContext.getRequest();
        final HttpServletResponse response = ServletActionContext.getResponse();
        String contentType = request.getHeader("content-type");
        if (contentType != null) {
            int iSemicolonIdx;
            if ((iSemicolonIdx = contentType.indexOf(";")) != -1) {
                contentType = contentType.substring(0, iSemicolonIdx);
            }
        }

        Object rootObject = null;
        if (root != null) {
            final ValueStack stack = invocation.getStack();
            rootObject = stack.findValue(root);

            if (rootObject == null) {
                throw new RuntimeException("Invalid root expression: '" + root + "'.");
            }
        }

        if (contentType != null && contentType.equalsIgnoreCase("application/json")) {
            // load JSON object
            if (rootObject == null) {
                rootObject = invocation.getStack().peek();
            }

            final ObjectMapper mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            // mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            mapper.readerForUpdating(rootObject).readValue(request.getReader());
        } else if (contentType != null && contentType.equalsIgnoreCase("application/json-rpc")) {
            Object result;
            if (enableSMD) {
                // load JSON object
                final Object obj = JSONUtil.deserialize(request.getReader());

                if (obj instanceof Map) {
                    final Map smd = (Map) obj;

                    if (rootObject == null) {
                        rootObject = invocation.getAction();
                    }

                    // invoke method
                    try {
                        result = invoke(rootObject, smd);
                    } catch (final Exception e) {
                        final RPCResponse rpcResponse = new RPCResponse();
                        rpcResponse.setId(smd.get("id").toString());
                        rpcResponse.setError(new RPCError(e, RPCErrorCode.EXCEPTION, getDebug()));

                        result = rpcResponse;
                    }
                } else {
                    final String message = "SMD request was not in the right format. See http://json-rpc.org";

                    final RPCResponse rpcResponse = new RPCResponse();
                    rpcResponse.setError(new RPCError(message, RPCErrorCode.INVALID_PROCEDURE_CALL));
                    result = rpcResponse;
                }
            } else {
                final String message = "Request with content type of 'application/json-rpc' was received but SMD is "
                        + "not enabled for this interceptor. Set 'enableSMD' to true to enable it";

                final RPCResponse rpcResponse = new RPCResponse();
                rpcResponse.setError(new RPCError(message, RPCErrorCode.SMD_DISABLED));
                result = rpcResponse;
            }

            String json = JSONUtil.serialize(result, excludeProperties, getIncludeProperties(), ignoreHierarchy,
                    excludeNullProperties);
            json = addCallbackIfApplicable(request, json);
            final boolean writeGzip = enableGZIP && JSONUtil.isGzipInRequest(request);
            JSONUtil.writeJSONToResponse(new SerializationParams(response, defaultEncoding, wrapWithComments, json,
                    true, writeGzip, noCache, -1, -1, prefix, "application/json"));

            return Action.NONE;
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Content type must be 'application/json' or 'application/json-rpc'. "
                        + "Ignoring request with content type " + contentType);
            }
        }

        return invocation.invoke();
    }

    @SuppressWarnings("unchecked")
    public RPCResponse invoke(final Object object, final Map data) throws IllegalArgumentException,
    IllegalAccessException, InvocationTargetException, JSONException, InstantiationException,
    NoSuchMethodException, IntrospectionException {

        final RPCResponse response = new RPCResponse();

        // validate id
        final Object id = data.get("id");
        if (id == null) {
            final String message = "'id' is required for JSON RPC";
            response.setError(new RPCError(message, RPCErrorCode.METHOD_NOT_FOUND));
            return response;
        }
        // could be a numeric value
        response.setId(id.toString());

        // the map is going to have: 'params', 'method' and 'id' (for the
        // client to identify the response)
        final Class clazz = object.getClass();

        // parameters
        final List parameters = (List) data.get("params");
        final int parameterCount = parameters != null ? parameters.size() : 0;

        // method
        final String methodName = (String) data.get("method");
        if (methodName == null) {
            final String message = "'method' is required for JSON RPC";
            response.setError(new RPCError(message, RPCErrorCode.MISSING_METHOD));
            return response;
        }

        final Method method = getMethod(clazz, methodName, parameterCount);
        if (method == null) {
            final String message = "Method " + methodName + " could not be found in action class.";
            response.setError(new RPCError(message, RPCErrorCode.METHOD_NOT_FOUND));
            return response;
        }

        // parameters
        if (parameterCount > 0) {
            final Class[] parameterTypes = method.getParameterTypes();
            final Type[] genericTypes = method.getGenericParameterTypes();
            final List invocationParameters = new ArrayList();

            // validate size
            if (parameterTypes.length != parameterCount) {
                // size mismatch
                final String message = "Parameter count in request, " + parameterCount
                        + " do not match expected parameter count for " + methodName + ", " + parameterTypes.length;

                response.setError(new RPCError(message, RPCErrorCode.PARAMETERS_MISMATCH));
                return response;
            }

            // convert parameters
            for (int i = 0; i < parameters.size(); i++) {
                Object parameter = parameters.get(i);
                final Class paramType = parameterTypes[i];
                final Type genericType = genericTypes[i];

                // clean up the values
                if (dataCleaner != null) {
                    parameter = dataCleaner.clean("[" + i + "]", parameter);
                }

                final Object converted = populator.convert(paramType, genericType, parameter, method);
                invocationParameters.add(converted);
            }

            response.setResult(method.invoke(object, invocationParameters.toArray()));
        } else {
            response.setResult(method.invoke(object, new Object[0]));
        }

        return response;
    }

    @SuppressWarnings("unchecked")
    private Method getMethod(final Class clazz, final String name, final int parameterCount) {
        final Method[] smdMethods = JSONUtil.listSMDMethods(clazz, ignoreSMDMethodInterfaces);

        for (final Method method : smdMethods) {
            if (checkSMDMethodSignature(method, name, parameterCount)) {
                return method;
            }
        }
        return null;
    }

    /**
     * Look for a method in clazz carrying the SMDMethod annotation with matching name and parametersCount
     *
     * @return true if matches name and parameterCount
     */
    private boolean checkSMDMethodSignature(final Method method, final String name, final int parameterCount) {

        final SMDMethod smdMethodAnntotation = method.getAnnotation(SMDMethod.class);
        if (smdMethodAnntotation != null) {
            final String alias = smdMethodAnntotation.name();
            final boolean paramsMatch = method.getParameterTypes().length == parameterCount;
            if (alias.length() == 0 && method.getName().equals(name) && paramsMatch || alias.equals(name)
                    && paramsMatch) {
                return true;
            }
        }

        return false;
    }

    protected String addCallbackIfApplicable(final HttpServletRequest request, String json) {
        if (callbackParameter != null && callbackParameter.length() > 0) {
            final String callbackName = request.getParameter(callbackParameter);
            if (callbackName != null && callbackName.length() > 0) {
                json = callbackName + "(" + json + ")";
            }
        }
        return json;
    }

    public boolean isEnableSMD() {
        return enableSMD;
    }

    public void setEnableSMD(boolean enableSMD) {
        enableSMD = enableSMD;
    }

    /**
     * Ignore annotations on methods in interfaces You may need to set to this true if your action is a
     * proxy/enhanced as annotations are not inherited
     */
    public void setIgnoreSMDMethodInterfaces(boolean ignoreSMDMethodInterfaces) {
        ignoreSMDMethodInterfaces = ignoreSMDMethodInterfaces;
    }

    /**
     * Wrap generated JSON with comments. Only used if SMD is enabled.
     *
     * @param wrapWithComments
     */
    public void setWrapWithComments(boolean wrapWithComments) {
        wrapWithComments = wrapWithComments;
    }

    @Inject(StrutsConstants.STRUTS_I18N_ENCODING)
    public void setDefaultEncoding(final String val) {
        defaultEncoding = val;
    }

    /**
     * Ignore properties defined on base classes of the root object.
     *
     * @param ignoreHierarchy
     */
    public void setIgnoreHierarchy(boolean ignoreHierarchy) {
        ignoreHierarchy = ignoreHierarchy;
    }

    /**
     * Sets the root object to be deserialized, defaults to the Action
     *
     * @param root
     *            OGNL expression of root object to be serialized
     */
    public void setRoot(String root) {
        root = root;
    }

    /**
     * Sets the JSONPopulator to be used
     *
     * @param populator
     *            JSONPopulator
     */
    public void setJSONPopulator(JSONPopulator populator) {
        populator = populator;
    }

    /**
     * Sets the JSONCleaner to be used
     *
     * @param dataCleaner
     *            JSONCleaner
     */
    public void setJSONCleaner(JSONCleaner dataCleaner) {
        dataCleaner = dataCleaner;
    }

    /**
     * @return true if debugging is turned on
     */
    public boolean getDebug() {
        final Boolean devModeOverride = FilterDispatcher.getDevModeOverride();
        return devModeOverride != null ? devModeOverride.booleanValue() : debug;
    }

    /**
     * Turns debugging on or off
     *
     * @param debug
     *            true or false
     */
    public void setDebug(boolean debug) {
        debug = debug;
    }

    @Inject(StrutsConstants.STRUTS_DEVMODE)
    public void setDevMode(final String mode) {
        setDebug("true".equalsIgnoreCase(mode));
    }

    /**
     * Sets a comma-delimited list of regular expressions to match properties that should be excluded from the
     * JSON output.
     *
     * @param commaDelim
     *            A comma-delimited list of regular expressions
     */
    public void setExcludeProperties(final String commaDelim) {
        final Set<String> excludePatterns = JSONUtil.asSet(commaDelim);
        if (excludePatterns != null) {
            excludeProperties = new ArrayList<Pattern>(excludePatterns.size());
            for (final String pattern : excludePatterns) {
                excludeProperties.add(Pattern.compile(pattern));
            }
        }
    }

    /**
     * Sets a comma-delimited list of wildcard expressions to match properties that should be excluded from
     * the JSON output.
     *
     * @param commaDelim
     *            A comma-delimited list of wildcard expressions
     */
    public void setExcludeWildcards(final String commaDelim) {
        final Set<String> excludePatterns = JSONUtil.asSet(commaDelim);
        if (excludePatterns != null) {
            excludeProperties = new ArrayList<Pattern>(excludePatterns.size());
            for (final String pattern : excludePatterns) {
                excludeProperties.add(WildcardUtil.compileWildcardPattern(pattern));
            }
        }
    }

    /**
     * Sets a comma-delimited list of regular expressions to match properties that should be included from the
     * JSON output.
     *
     * @param commaDelim
     *            A comma-delimited list of regular expressions
     */
    public void setIncludeProperties(final String commaDelim) {
        includeProperties = JSONUtil.processIncludePatterns(JSONUtil.asSet(commaDelim), JSONUtil.REGEXP_PATTERN);
    }

    /**
     * Sets a comma-delimited list of wildcard expressions to match properties that should be included from
     * the JSON output. The standard boilerplate (id, error, debug) are automatically included, as
     * appropriate, so you only need to provide patterns for the contents of "result".
     *
     * @param commaDelim
     *            A comma-delimited list of wildcard expressions
     */
    public void setIncludeWildcards(final String commaDelim) {
        includeProperties = JSONUtil.processIncludePatterns(JSONUtil.asSet(commaDelim), JSONUtil.WILDCARD_PATTERN);
        if (includeProperties != null) {
            includeProperties.add(Pattern.compile("id"));
            includeProperties.add(Pattern.compile("result"));
            includeProperties.add(Pattern.compile("error"));
            includeProperties.add(WildcardUtil.compileWildcardPattern("error.code"));
        }
    }

    /**
     * Returns the appropriate set of includes, based on debug setting. Derived classes can override if there
     * are additional, custom debug-only parameters.
     */
    protected List getIncludeProperties() {
        if (includeProperties != null && getDebug()) {
            final List<Pattern> list = new ArrayList<Pattern>(includeProperties);
            list.add(Pattern.compile("debug"));
            list.add(WildcardUtil.compileWildcardPattern("error.*"));
            return list;
        } else {
            return includeProperties;
        }
    }

    public boolean isEnableGZIP() {
        return enableGZIP;
    }

    /**
     * Setting this property to "true" will compress the output.
     *
     * @param enableGZIP
     *            Enable compressed output
     */
    public void setEnableGZIP(boolean enableGZIP) {
        enableGZIP = enableGZIP;
    }

    public boolean isNoCache() {
        return noCache;
    }

    /**
     * Add headers to response to prevent the browser from caching the response
     *
     * @param noCache
     */
    public void setNoCache(boolean noCache) {
        noCache = noCache;
    }

    public boolean isExcludeNullProperties() {
        return excludeNullProperties;
    }

    /**
     * Do not serialize properties with a null value
     *
     * @param excludeNullProperties
     */
    public void setExcludeNullProperties(boolean excludeNullProperties) {
        excludeNullProperties = excludeNullProperties;
    }

    public void setCallbackParameter(String callbackParameter) {
        callbackParameter = callbackParameter;
    }

    public String getCallbackParameter() {
        return callbackParameter;
    }

    /**
     * Add "{} && " to generated JSON
     *
     * @param prefix
     */
    public void setPrefix(boolean prefix) {
        prefix = prefix;
    }

    public void setContentType(String contentType) {
        contentType = contentType;
    }
}
