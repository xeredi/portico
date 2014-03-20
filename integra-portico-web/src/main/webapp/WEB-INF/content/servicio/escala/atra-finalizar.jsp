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
<title><fmt:message key="atra.finalizar.title" /></title>
</head>
<body>
    <form action="atra-finalizar-guardar.action" method="post">
        <input type="hidden" name="item.id" value="${item.id}" />

        <fieldset>
            <div class="row">
                <div class="col-md-8">
                    <jsp:include page="content/atra-srvcinfo-content.jsp" flush="true" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <jsp:include page="content/atra-real-content.jsp" flush="true">
                        <jsp:param value="true" name="disabled" />
                    </jsp:include>
                </div>
                <div class="col-md-6">
                    <div class="form-horizontal">
                        <fieldset>
                            <legend> ${enti.engdMap[4].etiqueta} </legend>
                            <div class="form-group">
                                <label class="col-md-3 control-label">${enti.entdMap[41055].etiqueta}</label>
                                <div class="col-md-9">
                                    <input type="text" name="item.itdtMap[41055].cantidadDecimal"
                                        id="item.itdtMap[41055].cantidadDecimal"
                                        value="${item.itdtMap[41055].cantidadDecimal}"
                                        class="form-control input-sm number" maxlength="15"
                                        required="required" />
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
                <fmt:message key="boton.finalizar" />
            </button>
        </div>
    </form>
</body>
</html>
