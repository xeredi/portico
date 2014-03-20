<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="atra.denegar.title" /></title>
</head>
<body>
    <form action="atra-denegar-guardar.action" method="post">
        <input type="hidden" name="item.id" value="${item.id}" />
        <fmt:formatDate value="${item.itdtMap[41101].fecha}" pattern="${datetimePattern}"
            var="fechaString" />
        <input type="hidden" name="item.itdtMap[41101].fecha" value="${fechaString}" />

        <fieldset>
            <div class="row">
                <div class="col-md-8">
                    <jsp:include page="content/atra-srvcinfo-content.jsp" flush="true" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <c:if test="${item.estado eq 'S'}">
                        <jsp:include page="content/atra-solicitud-content.jsp" flush="true">
                            <jsp:param value="true" name="disabled" />
                        </jsp:include>
                    </c:if>
                    <c:if test="${item.estado eq 'C'}">
                        <jsp:include page="content/atra-autorizacion-content.jsp" flush="true">
                            <jsp:param value="true" name="disabled" />
                        </jsp:include>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <div class="form-horizontal">
                        <fieldset>
                            <legend> ${enti.engdMap[3].etiqueta} </legend>
                            <div class="form-group">
                                <label class="col-md-3 control-label">${enti.entdMap[41100].etiqueta}</label>
                                <div class="col-md-9">
                                    <fmt:formatDate value="${item.itdtMap[41100].fecha}"
                                        pattern="${datetimePattern}" var="fechaString" />
                                    <div class='input-group date' id='datetimepicker_41100'>
                                        <input type='text' id="item.itdtMap[41100].fecha"
                                            name="item.itdtMap[41100].fecha"
                                            class="form-control input-sm"
                                            data-format="${datetimePatternJS}"
                                            value="${fechaString}" required="required" /> <span
                                            class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span> </span>
                                    </div>
                                    <script type="text/javascript">
																																					$(function() {
																																						$(
																																								'#datetimepicker_41100')
																																								.datetimepicker(
																																										{});
																																					});
																																				</script>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">${enti.entdMap[41081].etiqueta}</label>
                                <div class="col-md-9">
                                    <textarea name="item.itdtMap[41081].cadena"
                                        id="item.itdtMap[41081].cadena" rows="4"
                                        class="form-control input-sm">${item.itdtMap[41081].cadena}</textarea>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="controls">
            <button type="submit" class="btn btn-primary">
                <i class="glyphicon glyphicon-ok"></i>
                <fmt:message key="boton.denegar" />
            </button>
        </div>
    </form>
</body>
</html>
