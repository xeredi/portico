<%@ page language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tppr-listado.title" /></title>
</head>
<body>
    <div class="row">
        <div class="col-md-3 form-group">
            <input type="text" ng-model="tpprSearch" maxlength="30" class="form-control input-sm" />
        </div>
    </div>

    <ul class="list-group">
        <c:forEach items="${tpprs}" var="enti">
            <li class="list-group-item col-md-3"><a
                href="prmt-listado.action?itemCriterio.entiId=${enti.value}">${enti.label}</a></li>
        </c:forEach>
    </ul>

    <script type="text/javascript" async src="${pageContext.request.contextPath}/js/maestro/tppr.js"></script>
</body>
</html>
