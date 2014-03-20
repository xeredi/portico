<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnen-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="cnen-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="cnen.id" value="${cnen.id}" /> <input type="hidden"
                name="accion" value="${accion}" />

            <div class="row">
                <div class="col-md-2 form-group">
                    <label><fmt:message key="cnen.codigo" /></label> <input type="text"
                        name="cnen.codigo" id="cnen.codigo" value="${cnen.codigo}"
                        class="form-control input-sm" required="required"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-6 form-group">
                    <label><fmt:message key="cnen.nombre" /></label> <input type="text"
                        name="cnen.nombre" id="cnen.nombre" value="${cnen.nombre}"
                        class="form-control input-sm" required="required" />
                </div>
            </div>
        </fieldset>

        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.guardar" />
        </button>
    </form>
</body>
</html>
