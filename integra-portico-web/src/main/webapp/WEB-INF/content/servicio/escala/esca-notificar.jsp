<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="esca.notificar.title" /></title>
</head>
<body>
    <form action="esca-notificar-guardar.action" method="post">
        <input type="hidden" name="item.id" value="${item.id}" />

        <c:if test="${notificado}">
            <div class="alert alert-warning">
                Escala ya notificada al práctico
            </div>
        </c:if>

        <fieldset>
            <div class="row">
                <div class="col-md-2 form-group">
                    <label><fmt:message key="srvc.etiqueta" /></label> <input type="text"
                        name="item.etiqueta" id="item.etiqueta" value="${item.etiqueta}"
                        class="form-control input-sm" disabled='disabled' />
                </div>
                <div class="col-md-2 form-group">
                    <label><fmt:message key="srvc.estado" /></label><input type="text"
                        name="item.estado" id="item.estado" value="${item.estado}"
                        class="form-control input-sm" disabled='disabled' />
                </div>
                <div class="col-md-2 form-group">
                    <label>${enti.entdMap[41022].etiqueta}</label> <input type="text"
                        name="item.itdtMap[41022].cadena" id="item.itdtMap[41022].cadena"
                        value="${item.itdtMap[41022].cadena}" class="form-control input-sm"
                        required='required' />
                </div>
                <div class="col-md-2 form-group">
                    <fmt:formatDate value="${item.itdtMap[41101].fecha}"
                        pattern="${datetimePattern}" var="fechaString" />
                    <label>${enti.entdMap[41101].etiqueta}</label> <input type='text'
                        id="item.itdtMap[41101].fecha" name="item.itdtMap[41101].fecha"
                        class="form-control input-sm" data-format="${datetimePatternJS}"
                        value="${fechaString}" readonly="readonly" />
                </div>
            </div>
        </fieldset>

        <div class="controls">
            <button type="submit" class="btn btn-primary">
                <i class="glyphicon glyphicon-ok"></i>
                <fmt:message key="boton.notificar" />
            </button>
        </div>
    </form>
</body>
</html>
