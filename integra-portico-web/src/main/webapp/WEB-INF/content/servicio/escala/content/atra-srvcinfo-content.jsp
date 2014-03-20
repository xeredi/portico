<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="form">
    <div class="row">
        <div class="col-md-3 form-group">
            <label><fmt:message key="srvc.etiqueta" /></label> <input type="text"
                name="item.srvc.etiqueta" id="item.srvc.etiqueta" value="${item.srvc.etiqueta}"
                class="form-control input-sm" disabled='disabled' />
        </div>
        <div class="col-md-1 form-group">
            <label><fmt:message key="ssrv.numero" /></label><input type="text" name="item.numero"
                id="item.numero" value="${item.numero}" class="form-control input-sm"
                disabled='disabled' />
        </div>
        <div class="col-md-5 form-group">
            <label>${enti.tpsr.entdMap[45010].etiqueta}</label> <input type="text"
                name="item.srvc.itdtMap[45010].prmt.etiqueta"
                id="item.srvc.itdtMap[45010].prmt.etiqueta"
                value="${item.srvc.itdtMap[45010].prmt.etiqueta}" class="form-control input-sm"
                disabled='disabled' />
        </div>
    </div>
</div>
