<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="atra.iniciar.title" /></title>
</head>
<body>
    <form action="atra-iniciar-guardar.action" method="post">
        <input type="hidden" name="item.id" value="${item.id}" />

        <fieldset>
            <div class="row">
                <div class="col-md-8">
                    <jsp:include page="content/atra-srvcinfo-content.jsp" flush="true" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <jsp:include page="content/atra-autorizacion-content.jsp" flush="true">
                        <jsp:param value="true" name="disabled" />
                    </jsp:include>
                </div>
                <div class="col-md-6">
                    <jsp:include page="content/atra-real-content.jsp" flush="true">
                        <jsp:param value="false" name="disabled" />
                    </jsp:include>
                </div>
            </div>
        </fieldset>

        <div class="controls">
            <button type="submit" class="btn btn-primary">
                <i class="glyphicon glyphicon-ok"></i>
                <fmt:message key="boton.iniciar" />
            </button>
        </div>
    </form>
</body>
</html>
