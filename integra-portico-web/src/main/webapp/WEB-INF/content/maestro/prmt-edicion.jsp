<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.${accion}" var="title">
        <fmt:param value="${enti.nombre}" />
    </fmt:message>${title}</title>
</head>
<body>
    <div id="target-modal">
        <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
        <fmt:message key="format.date" var="datePattern" scope="page" />
        <fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />
        <fmt:message key="format.date.js" var="datePatternJS" scope="page" />

        <form id="prmt-guardar-form"  data-async data-target="#${title}" action="prmt-guardar.action" method="post">
            <fieldset>
                <input type="hidden" name="item.entiId" value="${item.entiId}" /> <input
                    type="hidden" name="item.prvr.id" value="${item.prvr.id}" /> <input
                    type="hidden" name="item.id" value="${item.id}" /> <input type="hidden"
                    name="accion" value="${accion}" />

                <div class="row">
                    <div class="col-md-2 form-group">
                        <label><fmt:message key="prmt.parametro" /></label> <input type="text"
                            name="item.parametro" id="item.parametro" value="${item.parametro}"
                            required="required" maxlength="30" class="form-control input-sm"
                            <c:if test="${accion eq 'modificar'}">disabled="disabled"</c:if> />
                    </div>

                    <c:if test="${enti.tempExp}">
                        <div class="col-md-2 form-group">
                            <fmt:formatDate value="${item.prvr.finicio}" pattern="${datePattern}"
                                var="fechaString" />
                            <label><fmt:message key="prmt.prvr.finicio" /></label>
                            <div class='input-group date' id='datepickerFinicio'>
                                <input type='text' class="form-control input-sm"
                                    id="item.prvr.finicio" name="item.prvr.finicio"
                                    value="${fechaString}" data-format="${datePatternJS}" /> <span
                                    class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span> </span>
                            </div>
                        </div>

                        <div class="col-md-2 form-group">
                            <fmt:formatDate value="${item.prvr.ffin}" pattern="${datePattern}"
                                var="fechaString" />
                            <label><fmt:message key="prmt.prvr.ffin" /></label>
                            <div class='input-group date' id='datepickerFfin'>
                                <input type='text' class="form-control input-sm" id="item.prvr.ffin"
                                    name="item.prvr.ffin" value="${fechaString}"
                                    data-format="${datePatternJS}" /> <span
                                    class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span> </span>
                            </div>
                        </div>

                        <script type="text/javascript">
                                                                                                    $(function() {
                                                                                                        $(
                                                                                                                '#datepickerFinicio')
                                                                                                                .datetimepicker(
                                                                                                                        {
                                                                                                                            pickTime : false
                                                                                                                        });
                                                                                                    });
                                                                                                    $(function() {
                                                                                                        $(
                                                                                                                '#datepickerFfin')
                                                                                                                .datetimepicker(
                                                                                                                        {
                                                                                                                            pickTime : false
                                                                                                                        });
                                                                                                    });
                                                                                                </script>
                    </c:if>
                </div>

                <c:if test="${enti.i18n}">
                    <c:forEach items="${availableLanguages}" var="availableLanguage">
                        <div class="row">
                            <div class="col-md-10 form-group">
                                <label>Texto ${availableLanguage}</label> <input type="text"
                                    id="p18nMap['${availableLanguage}'].texto"
                                    name="p18nMap['${availableLanguage}'].texto"
                                    value="${p18nMap[availableLanguage].texto}" required="required"
                                    maxlength="350" class="form-control input-sm" />
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

                <jsp:include page="/WEB-INF/content/include/item/item-edicion.jsp" flush="true" />
            </fieldset>

            <button type="submit" class="btn btn-primary">
                <i class="glyphicon glyphicon-ok"></i>
                <fmt:message key="boton.guardar" />
            </button>
        </form>
        <%--
        <script type="text/javascript">
                                    $(function() {
                                        $("#prmt-guardar-form")
                                                .submit(
                                                        function(e) {
                                                            e.preventDefault();

                                                            alert(this.action);
                                                            alert(this.elements);

                                                            $
                                                                    .post(
                                                                            this.action,
                                                                            this.elements)
                                                                    .done(
                                                                            function(
                                                                                    data) {
                                                                                alert("SUCCESS");
                                                                            })
                                                                    .fail(
                                                                            function(
                                                                                    data) {
                                                                                alert("ERROR");
                                                                            });
                                                        });
                                    });
                                </script>
 --%>
    </div>
</body>
</html>
