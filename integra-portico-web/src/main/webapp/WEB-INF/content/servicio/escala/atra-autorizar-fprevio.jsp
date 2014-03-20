<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.datetime" var="datetimePattern" scope="page" />

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="atra.autorizar-fprevio.title" /></title>
</head>
<body>
    <form action="atra-autorizar-fprevio-guardar.action" method="post">
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
                    <jsp:include page="content/atra-autorizacion-content.jsp" flush="true">
                        <jsp:param value="false" name="disabled" />
                    </jsp:include>
                </div>
            </div>
        </fieldset>

        <div class="controls">
            <button type="submit" class="btn btn-primary">
                <i class="glyphicon glyphicon-ok"></i>
                <fmt:message key="boton.autorizar-fprevio" />
            </button>
        </div>
    </form>
</body>
</html>
