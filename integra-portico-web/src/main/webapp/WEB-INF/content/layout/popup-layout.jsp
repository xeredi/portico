<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="app.title" /> - <decorator:title /></title>
</head>
<body>
    <div id="<decorator:title />">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <p class="modal-title">
                <decorator:title />
            </p>
        </div>
        <div class="modal-body">
            <c:if test="${not empty actionErrors || not empty fieldErrors}">
                <div class="alert alert-danger">
                    <s:actionerror />
                    <s:fielderror />
                </div>
            </c:if>
            <c:if test="${not empty actionMessages}">
                <div class="alert alert-success">
                    <s:actionmessage />
                </div>
            </c:if>

            <decorator:body />
        </div>
    </div>

    <script type="text/javascript">
                    jQuery(function($) {
                        $(document)
                                .on(
                                        'submit',
                                        'form[data-async]',
                                        function(event) {
                                            var $form = $(this);
                                            var $target = $($form
                                                    .attr('data-target'));
                                            var submitButton = $(
                                                    "input[type='submit'][clicked=true], button[type='submit'][clicked=true]",
                                                    $form);

                                            var formData = $form
                                                    .serializeArray();
                                            if (submitButton.size() === 1) {
                                                formData.push({
                                                    name : $(submitButton[0])
                                                            .attr("name"),
                                                    value : "1"
                                                });
                                            } else if (submitButton.size() !== 0) {
                                                console
                                                        .log("Multiple submit-buttons pressed. This should not happen!");
                                            }

                                            $
                                                    .ajax({
                                                        type : $form
                                                                .attr('method'),
                                                        url : $form
                                                                .attr('action'),
                                                        data : formData,

                                                        success : function(
                                                                data, status) {
                                                            $target.html(data);
                                                        }
                                                    });

                                            event.preventDefault();
                                        });

                        $(document)
                                .on(
                                        "click",
                                        'input[type="submit"], button[type="submit"]',
                                        function() {
                                            $(
                                                    'form[data-async] input[type=submit], form[data-async] button[type=submit]',
                                                    $(this).parents("form"))
                                                    .removeAttr("clicked");
                                            $(this).attr("clicked", "true");
                                        });
                    });
                </script>
</body>
</html>
