<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnid-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="cnid-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="cnid.id" value="${cnid.id}" /> <input type="hidden"
                name="accion" value="${accion}" />

            <div class="row">
                <div class="col-md-2 form-group">
                    <label><fmt:message key="cnid.codigo" /></label> <input type="text"
                        name="cnid.codigo" id="cnid.codigo" value="${cnid.codigo}"
                        class="form-control input-sm" required="required"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-6 form-group">
                    <label><fmt:message key="cnid.descripcion" /></label> <input type="text"
                        name="cnid.descripcion" id="cnid.descripcion" value="${cnid.descripcion}"
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
