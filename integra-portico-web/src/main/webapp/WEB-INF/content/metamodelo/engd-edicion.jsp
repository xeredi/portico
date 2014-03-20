<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="engd-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="engd-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="engd.entiId" value="${engd.entiId}" /> <input type="hidden" name="accion"
                value="${accion}" />

            <div class="row">
                <div class="col-md-1 form-group">
                    <label for="engd.numero"><fmt:message key="engd.numero" /></label> <input type="text"
                        name="engd.numero" id="engd.numero" value="${engd.numero}" class="form-control input-sm"
                        required="required" maxlength="2" />
                </div>
                <div class="col-md-6 form-group">
                    <label for="engd.etiqueta"><fmt:message key="engd.etiqueta" /></label> <input type="text"
                        name="engd.etiqueta" id="engd.etiqueta" value="${engd.etiqueta}" class="form-control input-sm"
                        required="required" maxlength="30" />
                </div>
            </div>
        </fieldset>

        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.guardar" />
        </button>
    </form>
</body>
</html>
