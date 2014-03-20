<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Cuadro Mensual</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th colspan="9">RESUMEN MENSUAL DE TRAFICO PORTUARIO</th>
                <th colspan="4">A.P: ${pepr.autp.parametro} - Año: ${pepr.anio} - Mes: ${pepr.mes}</th>
            </tr>
            <tr>
                <th colspan="4" rowspan="3" />
                <th colspan="4">CABOTAJE (Tm.)</th>
                <th colspan="4">EXTERIOR (Tm.)</th>
                <th colspan="1">TRANSB. (Tm.)</th>
            </tr>
            <tr>
                <th colspan="1" rowspan="2">Emb.</th>
                <th colspan="1" rowspan="2">Desemb.</th>
                <th colspan="2">Transito</th>
                <th colspan="1" rowspan="2">Emb.</th>
                <th colspan="1" rowspan="2">Desemb.</th>
                <th colspan="2">Transito</th>
            </tr>
            <tr>
                <th colspan="1">Emb.</th>
                <th colspan="1">Desemb.</th>
                <th colspan="1">Emb.</th>
                <th colspan="1">Desemb.</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th colspan="1" rowspan="4">GRANELES LIQUIDOS</th>
                <th colspan="3">CRUDOS DE PETROLEO</th>
                <c:forEach items="${cdmsMap['GLPETR']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="3">GAS NATURAL</th>
                <c:forEach items="${cdmsMap['GLGASN']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="3">PRODUCTOS PETROLIFEROS REFINADOS</th>
                <c:forEach items="${cdmsMap['GLPREF']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="3">OTROS GRANELES LIQUIDOS</th>
                <c:forEach items="${cdmsMap['GLOTRO']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>

            <tr>
                <th colspan="1" rowspan="2">GRANELES SOLIDOS</th>
                <th colspan="3">POR INSTALACION ESPECIAL</th>
                <c:forEach items="${cdmsMap['GSIESP']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="3">SIN INSTALACION ESPECIAL</th>
                <c:forEach items="${cdmsMap['GSNIES']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="4">MERCANCIA GENERAL</th>
                <c:forEach items="${cdmsMap['MG']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="4">Nº PASAJEROS (EXCLUIDO T. BAHIA)</th>
                <c:forEach items="${cdmsMap['PASAJE']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="4">Nº PASAJEROS DE CRUCERO</th>
                <c:forEach items="${cdmsMap['PASCRU']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="4">Nº VEHICULOS (Turismos en rég. pasaje, Automóviles y Autobuses)</th>
                <c:forEach items="${cdmsMap['VET2']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="1" rowspan="5">CONTENEDORES</th>
                <th colspan="1" rowspan="4">&ge; 20 pies</th>
                <th colspan="1" rowspan="2">Con carga</th>
                <th colspan="1">Nº</th>
                <c:forEach items="${cdmsMap['CNUMCA']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="1">Tm.</th>
                <c:forEach items="${cdmsMap['CTONCA']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="1" rowspan="2">Vacios</th>
                <th colspan="1">Nº</th>
                <c:forEach items="${cdmsMap['CNUMVA']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="1">Tm.</th>
                <c:forEach items="${cdmsMap['CTONVA']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="2">TEUS (con carga y vacios)</th>
                <th colspan="1">Nº</th>
                <c:forEach items="${cdmsMap['CTEUS']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="2" rowspan="3">TRAFICO RO-RO</th>
                <th colspan="1" rowspan="2">EN CONTENEDORES</th>
                <th colspan="1">TEUS</th>
                <c:forEach items="${cdmsMap['RRTEUS']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="1">Tm.</th>
                <c:forEach items="${cdmsMap['RRTONC']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="1">EN OTROS MEDIOS</th>
                <th colspan="1">Tm.</th>
                <c:forEach items="${cdmsMap['RRTONO']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
        </tbody>
    </table>

    <table class="table table-condensed table-hover table-nonfluid">
        <tbody>
            <tr>
                <th colspan="4" />
                <th colspan="1">Emb.</th>
                <th colspan="1">Desemb.</th>
                <th colspan="1">Tránsito</th>
                <th colspan="1">Transb.</th>
            </tr>
            <tr>
                <th colspan="4">TRAFICO LOCAL</th>
                <c:forEach items="${cdmsMap['TRALOC']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="4">PESCA FRESCA</th>
                <td />
                <c:forEach items="${cdmsMap['PESCAF']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="2" rowspan="2">AVITUALLAMIENTO</th>
                <th colspan="2">PROD. PETROLIFEROS</th>
                <c:forEach items="${cdmsMap['AVPPET']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="2">OTROS</th>
                <c:forEach items="${cdmsMap['AVOTRO']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
        </tbody>
    </table>

    <table class="table table-condensed table-hover table-nonfluid">
        <tbody>
            <tr>
                <th colspan="4" />
                <th colspan="1">NACIONALES</th>
                <th colspan="1">EXTRANJEROS</th>
                <th colspan="1">CRUCEROS</th>
            </tr>
            <tr>
                <th colspan="4">BUQUES ENTRADOS (Nº)</th>
                <c:forEach items="${cdmsMap['BUQUNI']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
                <c:forEach items="${cdmsMap['CRUBUQ']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
            <tr>
                <th colspan="4">UDS. ARQUEO (GT)</th>
                <c:forEach items="${cdmsMap['BUQGT']}" var="cdms">
                    <td><span class="pull-right"><fmt:formatNumber value="${cdms.cantidad}"
                                pattern="${integerPattern}" /></span></td>
                </c:forEach>
            </tr>
        </tbody>
    </table>

</body>
</html>
