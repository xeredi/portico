<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cdrf-${cdrf.accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="cdrf-guardar.action" method="post">
        <fieldset>
            <legend>
                <fmt:message key="cdrf" />
            </legend>

            <input type="hidden" name="cdrf.tpdtId" value="${cdrf.tpdtId}" /> <input type="hidden" name="cdrf.accion"
                value="${cdrf.accion}" />

            <div class="controls-row">
                <div class="span2">
                    <label for="cdrf.orden"><fmt:message key="cdrf.orden" /></label>
                    <div class="controls">
                        <input type="text" name="cdrf.orden" id="cdrf.orden" value="${cdrf.orden}" class="span2 number"
                            required="required" />
                    </div>
                </div>
                <div class="span2">
                    <label for="cdrf.valor"><fmt:message key="cdrf.valor" /></label>
                    <div class="controls">
                        <input type="text" name="cdrf.valor" id="cdrf.valor" value="${cdrf.valor}" class="span2"
                            required="required" />
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="controls">
            <button type="submit" class="btn">
                <fmt:message key="boton.guardar" />
            </button>
        </div>
    </form>
</body>
</html>
