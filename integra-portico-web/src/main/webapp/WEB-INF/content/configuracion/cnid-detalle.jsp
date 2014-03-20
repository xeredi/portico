<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnid-detalle.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-2 form-group">
                <label for="cnid.codigo"><fmt:message key="cnid.codigo" /></label>
                <p class="form-control-static">
                    ${cnid.codigo}
                </p>
            </div>
            <div class="col-md-6 form-group">
                <label for="cnid.descripcion"><fmt:message key="cnid.descripcion" /></label>
                <p class="form-control-static">
                    ${cnid.descripcion}
                </p>
            </div>
        </div>
    </fieldset>
</body>
</html>
