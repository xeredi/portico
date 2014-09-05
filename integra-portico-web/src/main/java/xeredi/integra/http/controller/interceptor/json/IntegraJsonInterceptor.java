package xeredi.integra.http.controller.interceptor.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONCleaner;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONInterceptor;
import org.apache.struts2.json.JSONPopulator;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.SerializationParams;
import org.apache.struts2.json.rpc.RPCError;
import org.apache.struts2.json.rpc.RPCErrorCode;
import org.apache.struts2.json.rpc.RPCResponse;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegraJsonInterceptor.
 */
public final class IntegraJsonInterceptor extends JSONInterceptor {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(IntegraJsonInterceptor.class);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5259122487206877020L;

    /** The root. */
    private String root;

    /** The default encoding. */
    private String defaultEncoding = "ISO-8859-1";

    /** The wrap with comments. */
    private boolean wrapWithComments;

    /** The exclude null properties. */
    private boolean excludeNullProperties;

    /** The ignore hierarchy. */
    private boolean ignoreHierarchy = true;

    /** The prefix. */
    private boolean prefix;

    /** The data cleaner. */
    private JSONCleaner dataCleaner = null;

    /** The populator. */
    private JSONPopulator populator = new JSONPopulator();

    /** The exclude properties. */
    private List<Pattern> excludeProperties;

    /**
     * Clean empty strings.
     *
     * @param map
     *            the map
     */
    private void cleanEmptyStrings(final Map map) {
        if (map != null) {
            for (final Object key : map.keySet()) {
                final Object value = map.get(key);

                if (value == null) {
                    map.remove(key);
                } else if (value instanceof String) {
                    if (((String) value).isEmpty()) {
                        map.remove(key);
                    }
                } else if (value instanceof Map) {
                    cleanEmptyStrings((Map) value);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String contentType = request.getHeader("content-type");
        if (contentType != null) {
            int iSemicolonIdx;
            if ((iSemicolonIdx = contentType.indexOf(";")) != -1)
                contentType = contentType.substring(0, iSemicolonIdx);
        }

        Object rootObject = null;

        if (root != null) {
            ValueStack stack = invocation.getStack();

            rootObject = stack.findValue(root);

            if (rootObject == null) {
                throw new RuntimeException("Invalid root expression: '" + root + "'.");
            }
        }

        if ((contentType != null) && contentType.equalsIgnoreCase("application/json")) {
            // load JSON object
            Object obj = JSONUtil.deserialize(request.getReader());

            if (obj instanceof Map) {
                Map json = (Map) obj;

                cleanEmptyStrings(json);

                // clean up the values
                if (dataCleaner != null)
                    dataCleaner.clean("", json);

                if (rootObject == null) // model overrides action
                    rootObject = invocation.getStack().peek();

                // populate fields
                populator.populateObject(rootObject, json);
            } else {
                LOG.error("Unable to deserialize JSON object from request");
                throw new JSONException("Unable to deserialize JSON object from request");
            }
        } else if ((contentType != null) && contentType.equalsIgnoreCase("application/json-rpc")) {
            Object result;
            if (isEnableSMD()) {
                // load JSON object
                Object obj = JSONUtil.deserialize(request.getReader());

                if (obj instanceof Map) {
                    Map smd = (Map) obj;

                    if (rootObject == null) // model makes no sense when using RPC
                        rootObject = invocation.getAction();

                    // invoke method
                    try {
                        result = this.invoke(rootObject, smd);
                    } catch (Exception e) {
                        RPCResponse rpcResponse = new RPCResponse();
                        rpcResponse.setId(smd.get("id").toString());
                        rpcResponse.setError(new RPCError(e, RPCErrorCode.EXCEPTION, getDebug()));

                        result = rpcResponse;
                    }
                } else {
                    String message = "SMD request was not in the right format. See http://json-rpc.org";

                    RPCResponse rpcResponse = new RPCResponse();
                    rpcResponse.setError(new RPCError(message, RPCErrorCode.INVALID_PROCEDURE_CALL));
                    result = rpcResponse;
                }
            } else {
                String message = "Request with content type of 'application/json-rpc' was received but SMD is "
                        + "not enabled for this interceptor. Set 'enableSMD' to true to enable it";

                RPCResponse rpcResponse = new RPCResponse();
                rpcResponse.setError(new RPCError(message, RPCErrorCode.SMD_DISABLED));
                result = rpcResponse;
            }

            String json = JSONUtil.serialize(result, excludeProperties, getIncludeProperties(), ignoreHierarchy,
                    excludeNullProperties);
            json = addCallbackIfApplicable(request, json);
            boolean writeGzip = isEnableGZIP() && JSONUtil.isGzipInRequest(request);
            JSONUtil.writeJSONToResponse(new SerializationParams(response, this.defaultEncoding, this.wrapWithComments,
                    json, true, writeGzip, isNoCache(), -1, -1, prefix, "application/json"));

            return Action.NONE;
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Content type must be 'application/json' or 'application/json-rpc'. "
                        + "Ignoring request with content type " + contentType);
            }
        }

        return invocation.invoke();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRoot(String value) {
        super.setRoot(value);

        this.root = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultEncoding(String value) {
        super.setDefaultEncoding(value);

        this.defaultEncoding = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWrapWithComments(boolean value) {
        super.setWrapWithComments(value);

        this.wrapWithComments = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExcludeNullProperties(boolean value) {
        super.setExcludeNullProperties(value);

        this.excludeNullProperties = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIgnoreHierarchy(boolean value) {
        super.setIgnoreHierarchy(value);

        this.ignoreHierarchy = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrefix(boolean value) {
        super.setPrefix(value);

        this.prefix = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExcludeProperties(String value) {
        super.setExcludeProperties(value);

        Set<String> excludePatterns = JSONUtil.asSet(value);
        if (excludePatterns != null) {
            this.excludeProperties = new ArrayList<Pattern>(excludePatterns.size());
            for (String pattern : excludePatterns) {
                this.excludeProperties.add(Pattern.compile(pattern));
            }
        }
    }

}
