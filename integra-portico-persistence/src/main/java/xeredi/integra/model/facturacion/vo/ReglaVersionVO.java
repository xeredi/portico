package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaVersionVO.
 */
public final class ReglaVersionVO {

    /** The id. */
    private Long id;

    /** The finicio. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The orden. */
    private Integer orden;

    /** The importe base. */
    private Double importeBase;

    /** The condicion. */
    private String condicion;

    /** The condicion sql. */
    private String condicionSql;

    /** The formula. */
    private String formula;

    /** The formula sql. */
    private String formulaSql;

    /** The path impuesto. */
    private String pathImpuesto;

    /** The path impuesto sql. */
    private String pathImpuestoSql;

    /** The path pagador. */
    private String pathPagador;

    /** The path pagador sql. */
    private String pathPagadorSql;

    /** The path es suj pasivo. */
    private String pathEsSujPasivo;

    /** The path es suj pasivo sql. */
    private String pathEsSujPasivoSql;

    /** The path cod exen. */
    private String pathCodExen;

    /** The path cod exen sql. */
    private String pathCodExenSql;

    /** The etiq info1. */
    private String etiqInfo1;

    /** The path info1. */
    private String pathInfo1;

    /** The path info1 sql. */
    private String pathInfo1Sql;

    /** The etiq info2. */
    private String etiqInfo2;

    /** The path info2. */
    private String pathInfo2;

    /** The path info2 sql. */
    private String pathInfo2Sql;

    /** The etiq info3. */
    private String etiqInfo3;

    /** The path info3. */
    private String pathInfo3;

    /** The path info3 sql. */
    private String pathInfo3Sql;

    /** The etiq info4. */
    private String etiqInfo4;

    /** The path info4. */
    private String pathInfo4;

    /** The path info4 sql. */
    private String pathInfo4Sql;

    /** The etiq info5. */
    private String etiqInfo5;

    /** The path info5. */
    private String pathInfo5;

    /** The path info5 sql. */
    private String pathInfo5Sql;

    /** The etiq info6. */
    private String etiqInfo6;

    /** The path info6. */
    private String pathInfo6;

    /** The path info6 sql. */
    private String pathInfo6Sql;

    /** The etiq cuant1. */
    private String etiqCuant1;

    /** The path cuant1. */
    private String pathCuant1;

    /** The path cuant1 sql. */
    private String pathCuant1Sql;

    /** The etiq cuant2. */
    private String etiqCuant2;

    /** The path cuant2. */
    private String pathCuant2;

    /** The path cuant2 sql. */
    private String pathCuant2Sql;

    /** The etiq cuant3. */
    private String etiqCuant3;

    /** The path cuant3. */
    private String pathCuant3;

    /** The path cuant3 sql. */
    private String pathCuant3Sql;

    /** The etiq cuant4. */
    private String etiqCuant4;

    /** The path cuant4. */
    private String pathCuant4;

    /** The path cuant4 sql. */
    private String pathCuant4Sql;

    /** The etiq cuant5. */
    private String etiqCuant5;

    /** The path cuant5. */
    private String pathCuant5;

    /** The path cuant5 sql. */
    private String pathCuant5Sql;

    /** The etiq cuant6. */
    private String etiqCuant6;

    /** The path cuant6. */
    private String pathCuant6;

    /** The path cuant6 sql. */
    private String pathCuant6Sql;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the finicio
     */
    public void setFini(final Date value) {
        fini = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
    }

    /**
     * Gets the condicion.
     *
     * @return the condicion
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Sets the condicion.
     *
     * @param value
     *            the condicion
     */
    public void setCondicion(final String value) {
        condicion = value;
    }

    /**
     * Gets the formula.
     *
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Sets the formula.
     *
     * @param value
     *            the formula
     */
    public void setFormula(final String value) {
        formula = value;
    }

    /**
     * Gets the path impuesto.
     *
     * @return the path impuesto
     */
    public String getPathImpuesto() {
        return pathImpuesto;
    }

    /**
     * Sets the path impuesto.
     *
     * @param value
     *            the path impuesto
     */
    public void setPathImpuesto(final String value) {
        pathImpuesto = value;
    }

    /**
     * Gets the path pagador.
     *
     * @return the path pagador
     */
    public String getPathPagador() {
        return pathPagador;
    }

    /**
     * Sets the path pagador.
     *
     * @param value
     *            the path pagador
     */
    public void setPathPagador(final String value) {
        pathPagador = value;
    }

    /**
     * Gets the path es suj pasivo.
     *
     * @return the path es suj pasivo
     */
    public String getPathEsSujPasivo() {
        return pathEsSujPasivo;
    }

    /**
     * Sets the path es suj pasivo.
     *
     * @param value
     *            the path es suj pasivo
     */
    public void setPathEsSujPasivo(final String value) {
        pathEsSujPasivo = value;
    }

    /**
     * Gets the path cod exen.
     *
     * @return the path cod exen
     */
    public String getPathCodExen() {
        return pathCodExen;
    }

    /**
     * Sets the path cod exen.
     *
     * @param value
     *            the path cod exen
     */
    public void setPathCodExen(final String value) {
        pathCodExen = value;
    }

    /**
     * Gets the etiq info1.
     *
     * @return the etiq info1
     */
    public String getEtiqInfo1() {
        return etiqInfo1;
    }

    /**
     * Sets the etiq info1.
     *
     * @param value
     *            the etiq info1
     */
    public void setEtiqInfo1(final String value) {
        etiqInfo1 = value;
    }

    /**
     * Gets the path info1.
     *
     * @return the path info1
     */
    public String getPathInfo1() {
        return pathInfo1;
    }

    /**
     * Sets the path info1.
     *
     * @param value
     *            the path info1
     */
    public void setPathInfo1(final String value) {
        pathInfo1 = value;
    }

    /**
     * Gets the etiq info2.
     *
     * @return the etiq info2
     */
    public String getEtiqInfo2() {
        return etiqInfo2;
    }

    /**
     * Sets the etiq info2.
     *
     * @param value
     *            the etiq info2
     */
    public void setEtiqInfo2(final String value) {
        etiqInfo2 = value;
    }

    /**
     * Gets the path info2.
     *
     * @return the path info2
     */
    public String getPathInfo2() {
        return pathInfo2;
    }

    /**
     * Sets the path info2.
     *
     * @param value
     *            the path info2
     */
    public void setPathInfo2(final String value) {
        pathInfo2 = value;
    }

    /**
     * Gets the etiq info3.
     *
     * @return the etiq info3
     */
    public String getEtiqInfo3() {
        return etiqInfo3;
    }

    /**
     * Sets the etiq info3.
     *
     * @param value
     *            the etiq info3
     */
    public void setEtiqInfo3(final String value) {
        etiqInfo3 = value;
    }

    /**
     * Gets the path info3.
     *
     * @return the path info3
     */
    public String getPathInfo3() {
        return pathInfo3;
    }

    /**
     * Sets the path info3.
     *
     * @param value
     *            the path info3
     */
    public void setPathInfo3(final String value) {
        pathInfo3 = value;
    }

    /**
     * Gets the etiq info4.
     *
     * @return the etiq info4
     */
    public String getEtiqInfo4() {
        return etiqInfo4;
    }

    /**
     * Sets the etiq info4.
     *
     * @param value
     *            the etiq info4
     */
    public void setEtiqInfo4(final String value) {
        etiqInfo4 = value;
    }

    /**
     * Gets the path info4.
     *
     * @return the path info4
     */
    public String getPathInfo4() {
        return pathInfo4;
    }

    /**
     * Sets the path info4.
     *
     * @param value
     *            the path info4
     */
    public void setPathInfo4(final String value) {
        pathInfo4 = value;
    }

    /**
     * Gets the etiq info5.
     *
     * @return the etiq info5
     */
    public String getEtiqInfo5() {
        return etiqInfo5;
    }

    /**
     * Sets the etiq info5.
     *
     * @param value
     *            the etiq info5
     */
    public void setEtiqInfo5(final String value) {
        etiqInfo5 = value;
    }

    /**
     * Gets the path info5.
     *
     * @return the path info5
     */
    public String getPathInfo5() {
        return pathInfo5;
    }

    /**
     * Sets the path info5.
     *
     * @param value
     *            the path info5
     */
    public void setPathInfo5(final String value) {
        pathInfo5 = value;
    }

    /**
     * Gets the etiq info6.
     *
     * @return the etiq info6
     */
    public String getEtiqInfo6() {
        return etiqInfo6;
    }

    /**
     * Sets the etiq info6.
     *
     * @param value
     *            the etiq info6
     */
    public void setEtiqInfo6(final String value) {
        etiqInfo6 = value;
    }

    /**
     * Gets the path info6.
     *
     * @return the path info6
     */
    public String getPathInfo6() {
        return pathInfo6;
    }

    /**
     * Sets the path info6.
     *
     * @param value
     *            the path info6
     */
    public void setPathInfo6(final String value) {
        pathInfo6 = value;
    }

    /**
     * Gets the etiq cuant1.
     *
     * @return the etiq cuant1
     */
    public String getEtiqCuant1() {
        return etiqCuant1;
    }

    /**
     * Sets the etiq cuant1.
     *
     * @param value
     *            the etiq cuant1
     */
    public void setEtiqCuant1(final String value) {
        etiqCuant1 = value;
    }

    /**
     * Gets the path cuant1.
     *
     * @return the path cuant1
     */
    public String getPathCuant1() {
        return pathCuant1;
    }

    /**
     * Sets the path cuant1.
     *
     * @param value
     *            the path cuant1
     */
    public void setPathCuant1(final String value) {
        pathCuant1 = value;
    }

    /**
     * Gets the etiq cuant2.
     *
     * @return the etiq cuant2
     */
    public String getEtiqCuant2() {
        return etiqCuant2;
    }

    /**
     * Sets the etiq cuant2.
     *
     * @param value
     *            the etiq cuant2
     */
    public void setEtiqCuant2(final String value) {
        etiqCuant2 = value;
    }

    /**
     * Gets the path cuant2.
     *
     * @return the path cuant2
     */
    public String getPathCuant2() {
        return pathCuant2;
    }

    /**
     * Sets the path cuant2.
     *
     * @param value
     *            the path cuant2
     */
    public void setPathCuant2(final String value) {
        pathCuant2 = value;
    }

    /**
     * Gets the etiq cuant3.
     *
     * @return the etiq cuant3
     */
    public String getEtiqCuant3() {
        return etiqCuant3;
    }

    /**
     * Sets the etiq cuant3.
     *
     * @param value
     *            the etiq cuant3
     */
    public void setEtiqCuant3(final String value) {
        etiqCuant3 = value;
    }

    /**
     * Gets the path cuant3.
     *
     * @return the path cuant3
     */
    public String getPathCuant3() {
        return pathCuant3;
    }

    /**
     * Sets the path cuant3.
     *
     * @param value
     *            the path cuant3
     */
    public void setPathCuant3(final String value) {
        pathCuant3 = value;
    }

    /**
     * Gets the etiq cuant4.
     *
     * @return the etiq cuant4
     */
    public String getEtiqCuant4() {
        return etiqCuant4;
    }

    /**
     * Sets the etiq cuant4.
     *
     * @param value
     *            the etiq cuant4
     */
    public void setEtiqCuant4(final String value) {
        etiqCuant4 = value;
    }

    /**
     * Gets the path cuant4.
     *
     * @return the path cuant4
     */
    public String getPathCuant4() {
        return pathCuant4;
    }

    /**
     * Sets the path cuant4.
     *
     * @param value
     *            the path cuant4
     */
    public void setPathCuant4(final String value) {
        pathCuant4 = value;
    }

    /**
     * Gets the etiq cuant5.
     *
     * @return the etiq cuant5
     */
    public String getEtiqCuant5() {
        return etiqCuant5;
    }

    /**
     * Sets the etiq cuant5.
     *
     * @param value
     *            the etiq cuant5
     */
    public void setEtiqCuant5(final String value) {
        etiqCuant5 = value;
    }

    /**
     * Gets the path cuant5.
     *
     * @return the path cuant5
     */
    public String getPathCuant5() {
        return pathCuant5;
    }

    /**
     * Sets the path cuant5.
     *
     * @param value
     *            the path cuant5
     */
    public void setPathCuant5(final String value) {
        pathCuant5 = value;
    }

    /**
     * Gets the etiq cuant6.
     *
     * @return the etiq cuant6
     */
    public String getEtiqCuant6() {
        return etiqCuant6;
    }

    /**
     * Sets the etiq cuant6.
     *
     * @param value
     *            the etiq cuant6
     */
    public void setEtiqCuant6(final String value) {
        etiqCuant6 = value;
    }

    /**
     * Gets the path cuant6.
     *
     * @return the path cuant6
     */
    public String getPathCuant6() {
        return pathCuant6;
    }

    /**
     * Sets the path cuant6.
     *
     * @param value
     *            the path cuant6
     */
    public void setPathCuant6(final String value) {
        pathCuant6 = value;
    }

    /**
     * Gets the condicion sql.
     *
     * @return the condicion sql
     */
    public String getCondicionSql() {
        return condicionSql;
    }

    /**
     * Sets the condicion sql.
     *
     * @param value
     *            the condicion sql
     */
    public void setCondicionSql(final String value) {
        condicionSql = value;
    }

    /**
     * Gets the formula sql.
     *
     * @return the formula sql
     */
    public String getFormulaSql() {
        return formulaSql;
    }

    /**
     * Sets the formula sql.
     *
     * @param value
     *            the formula sql
     */
    public void setFormulaSql(final String value) {
        formulaSql = value;
    }

    /**
     * Gets the path impuesto sql.
     *
     * @return the path impuesto sql
     */
    public String getPathImpuestoSql() {
        return pathImpuestoSql;
    }

    /**
     * Sets the path impuesto sql.
     *
     * @param value
     *            the path impuesto sql
     */
    public void setPathImpuestoSql(final String value) {
        pathImpuestoSql = value;
    }

    /**
     * Gets the path pagador sql.
     *
     * @return the path pagador sql
     */
    public String getPathPagadorSql() {
        return pathPagadorSql;
    }

    /**
     * Sets the path pagador sql.
     *
     * @param value
     *            the path pagador sql
     */
    public void setPathPagadorSql(final String value) {
        pathPagadorSql = value;
    }

    /**
     * Gets the path es suj pasivo sql.
     *
     * @return the path es suj pasivo sql
     */
    public String getPathEsSujPasivoSql() {
        return pathEsSujPasivoSql;
    }

    /**
     * Sets the path es suj pasivo sql.
     *
     * @param value
     *            the path es suj pasivo sql
     */
    public void setPathEsSujPasivoSql(final String value) {
        pathEsSujPasivoSql = value;
    }

    /**
     * Gets the path cod exen sql.
     *
     * @return the path cod exen sql
     */
    public String getPathCodExenSql() {
        return pathCodExenSql;
    }

    /**
     * Sets the path cod exen sql.
     *
     * @param value
     *            the path cod exen sql
     */
    public void setPathCodExenSql(final String value) {
        pathCodExenSql = value;
    }

    /**
     * Gets the path info1 sql.
     *
     * @return the path info1 sql
     */
    public String getPathInfo1Sql() {
        return pathInfo1Sql;
    }

    /**
     * Sets the path info1 sql.
     *
     * @param value
     *            the path info1 sql
     */
    public void setPathInfo1Sql(final String value) {
        pathInfo1Sql = value;
    }

    /**
     * Gets the path info2 sql.
     *
     * @return the path info2 sql
     */
    public String getPathInfo2Sql() {
        return pathInfo2Sql;
    }

    /**
     * Sets the path info2 sql.
     *
     * @param value
     *            the path info2 sql
     */
    public void setPathInfo2Sql(final String value) {
        pathInfo2Sql = value;
    }

    /**
     * Gets the path info3 sql.
     *
     * @return the path info3 sql
     */
    public String getPathInfo3Sql() {
        return pathInfo3Sql;
    }

    /**
     * Sets the path info3 sql.
     *
     * @param value
     *            the path info3 sql
     */
    public void setPathInfo3Sql(final String value) {
        pathInfo3Sql = value;
    }

    /**
     * Gets the path info4 sql.
     *
     * @return the path info4 sql
     */
    public String getPathInfo4Sql() {
        return pathInfo4Sql;
    }

    /**
     * Sets the path info4 sql.
     *
     * @param value
     *            the path info4 sql
     */
    public void setPathInfo4Sql(final String value) {
        pathInfo4Sql = value;
    }

    /**
     * Gets the path info5 sql.
     *
     * @return the path info5 sql
     */
    public String getPathInfo5Sql() {
        return pathInfo5Sql;
    }

    /**
     * Sets the path info5 sql.
     *
     * @param value
     *            the path info5 sql
     */
    public void setPathInfo5Sql(final String value) {
        pathInfo5Sql = value;
    }

    /**
     * Gets the path info6 sql.
     *
     * @return the path info6 sql
     */
    public String getPathInfo6Sql() {
        return pathInfo6Sql;
    }

    /**
     * Sets the path info6 sql.
     *
     * @param value
     *            the path info6 sql
     */
    public void setPathInfo6Sql(final String value) {
        pathInfo6Sql = value;
    }

    /**
     * Gets the path cuant1 sql.
     *
     * @return the path cuant1 sql
     */
    public String getPathCuant1Sql() {
        return pathCuant1Sql;
    }

    /**
     * Sets the path cuant1 sql.
     *
     * @param value
     *            the path cuant1 sql
     */
    public void setPathCuant1Sql(final String value) {
        pathCuant1Sql = value;
    }

    /**
     * Gets the path cuant2 sql.
     *
     * @return the path cuant2 sql
     */
    public String getPathCuant2Sql() {
        return pathCuant2Sql;
    }

    /**
     * Sets the path cuant2 sql.
     *
     * @param value
     *            the path cuant2 sql
     */
    public void setPathCuant2Sql(final String value) {
        pathCuant2Sql = value;
    }

    /**
     * Gets the path cuant3 sql.
     *
     * @return the path cuant3 sql
     */
    public String getPathCuant3Sql() {
        return pathCuant3Sql;
    }

    /**
     * Sets the path cuant3 sql.
     *
     * @param value
     *            the path cuant3 sql
     */
    public void setPathCuant3Sql(final String value) {
        pathCuant3Sql = value;
    }

    /**
     * Gets the path cuant4 sql.
     *
     * @return the path cuant4 sql
     */
    public String getPathCuant4Sql() {
        return pathCuant4Sql;
    }

    /**
     * Sets the path cuant4 sql.
     *
     * @param value
     *            the path cuant4 sql
     */
    public void setPathCuant4Sql(final String value) {
        pathCuant4Sql = value;
    }

    /**
     * Gets the path cuant5 sql.
     *
     * @return the path cuant5 sql
     */
    public String getPathCuant5Sql() {
        return pathCuant5Sql;
    }

    /**
     * Sets the path cuant5 sql.
     *
     * @param value
     *            the path cuant5 sql
     */
    public void setPathCuant5Sql(final String value) {
        pathCuant5Sql = value;
    }

    /**
     * Gets the path cuant6 sql.
     *
     * @return the path cuant6 sql
     */
    public String getPathCuant6Sql() {
        return pathCuant6Sql;
    }

    /**
     * Sets the path cuant6 sql.
     *
     * @param value
     *            the path cuant6 sql
     */
    public void setPathCuant6Sql(final String value) {
        pathCuant6Sql = value;
    }

    /**
     * Gets the orden.
     *
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * Sets the orden.
     *
     * @param value
     *            the new orden
     */
    public void setOrden(final Integer value) {
        orden = value;
    }

    /**
     * Gets the importe base.
     *
     * @return the importe base
     */
    public Double getImporteBase() {
        return importeBase;
    }

    /**
     * Sets the importe base.
     *
     * @param value
     *            the new importe base
     */
    public void setImporteBase(final Double value) {
        importeBase = value;
    }

}
