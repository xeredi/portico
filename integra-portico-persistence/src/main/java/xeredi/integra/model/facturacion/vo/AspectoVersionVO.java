package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoVersionVO.
 */
public final class AspectoVersionVO {

    /** The id. */
    private Long id;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The descripcion. */
    private String descripcion;

    /** The prioridad. */
    private Integer prioridad;

    /** The cpath info1. */
    private String cpathInfo1;

    /** The cpath info1 sql. */
    private String cpathInfo1Sql;

    /** The cetiq info1. */
    private String cetiqInfo1;

    /** The cpath info2. */
    private String cpathInfo2;

    /** The cpath info2 sql. */
    private String cpathInfo2Sql;

    /** The cetiq info2. */
    private String cetiqInfo2;

    /** The cpath info3. */
    private String cpathInfo3;

    /** The cpath info3 sql. */
    private String cpathInfo3Sql;

    /** The cetiq info3. */
    private String cetiqInfo3;

    /** The cpath info4. */
    private String cpathInfo4;

    /** The cpath info4 sql. */
    private String cpathInfo4Sql;

    /** The cetiq info4. */
    private String cetiqInfo4;

    /** The cpath info5. */
    private String cpathInfo5;

    /** The cpath info5 sql. */
    private String cpathInfo5Sql;

    /** The cetiq info5. */
    private String cetiqInfo5;

    /** The cpath info6. */
    private String cpathInfo6;

    /** The cpath info6 sql. */
    private String cpathInfo6Sql;

    /** The cetiq info6. */
    private String cetiqInfo6;

    /** The lgrp info1. */
    private Boolean cgrpInfo1;

    /** The lgrp info2. */
    private Boolean cgrpInfo2;

    /** The lgrp info3. */
    private Boolean cgrpInfo3;

    /** The lgrp info4. */
    private Boolean cgrpInfo4;

    /** The lgrp info5. */
    private Boolean cgrpInfo5;

    /** The lgrp info6. */
    private Boolean cgrpInfo6;

    /** The lsum cuant1. */
    private Boolean lsumCuant1;

    /** The lsum cuant2. */
    private Boolean lsumCuant2;

    /** The lsum cuant3. */
    private Boolean lsumCuant3;

    /** The lsum cuant4. */
    private Boolean lsumCuant4;

    /** The lsum cuant5. */
    private Boolean lsumCuant5;

    /** The lsum cuant6. */
    private Boolean lsumCuant6;

    /** The lgrp info1. */
    private Boolean lgrpInfo1;

    /** The lgrp info2. */
    private Boolean lgrpInfo2;

    /** The lgrp info3. */
    private Boolean lgrpInfo3;

    /** The lgrp info4. */
    private Boolean lgrpInfo4;

    /** The lgrp info5. */
    private Boolean lgrpInfo5;

    /** The lgrp info6. */
    private Boolean lgrpInfo6;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Checks if is agrupa cabeceras.
     *
     * @return true, if checks if is agrupa cabeceras
     */
    public boolean isAgrupaCabeceras() {
        return Boolean.TRUE == cgrpInfo1 || Boolean.TRUE == cgrpInfo2 || Boolean.TRUE == cgrpInfo3
                || Boolean.TRUE == cgrpInfo4 || Boolean.TRUE == cgrpInfo5 || Boolean.TRUE == cgrpInfo6;
    }

    /**
     * Checks if is agrupa detalles.
     *
     * @return true, if checks if is agrupa detalles
     */
    public boolean isAgrupaDetalles() {
        return Boolean.TRUE == lgrpInfo1 || Boolean.TRUE == lgrpInfo2 || Boolean.TRUE == lgrpInfo3
                || Boolean.TRUE == lgrpInfo4 || Boolean.TRUE == lgrpInfo5 || Boolean.TRUE == lgrpInfo6
                || Boolean.TRUE == lsumCuant1 || Boolean.TRUE == lsumCuant2 || Boolean.TRUE == lsumCuant3
                || Boolean.TRUE == lsumCuant4 || Boolean.TRUE == lsumCuant5 || Boolean.TRUE == lsumCuant6;
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
     * Gets the fini.
     *
     * @return the fini
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the fini.
     *
     * @param value
     *            the fini
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
     * Gets the cpath info1.
     *
     * @return the cpath info1
     */
    public String getCpathInfo1() {
        return cpathInfo1;
    }

    /**
     * Sets the cpath info1.
     *
     * @param value
     *            the cpath info1
     */
    public void setCpathInfo1(final String value) {
        cpathInfo1 = value;
    }

    /**
     * Gets the cetiq info1.
     *
     * @return the cetiq info1
     */
    public String getCetiqInfo1() {
        return cetiqInfo1;
    }

    /**
     * Sets the cetiq info1.
     *
     * @param value
     *            the cetiq info1
     */
    public void setCetiqInfo1(final String value) {
        cetiqInfo1 = value;
    }

    /**
     * Gets the cpath info2.
     *
     * @return the cpath info2
     */
    public String getCpathInfo2() {
        return cpathInfo2;
    }

    /**
     * Sets the cpath info2.
     *
     * @param value
     *            the cpath info2
     */
    public void setCpathInfo2(final String value) {
        cpathInfo2 = value;
    }

    /**
     * Gets the cetiq info2.
     *
     * @return the cetiq info2
     */
    public String getCetiqInfo2() {
        return cetiqInfo2;
    }

    /**
     * Sets the cetiq info2.
     *
     * @param value
     *            the cetiq info2
     */
    public void setCetiqInfo2(final String value) {
        cetiqInfo2 = value;
    }

    /**
     * Gets the cpath info3.
     *
     * @return the cpath info3
     */
    public String getCpathInfo3() {
        return cpathInfo3;
    }

    /**
     * Sets the cpath info3.
     *
     * @param value
     *            the cpath info3
     */
    public void setCpathInfo3(final String value) {
        cpathInfo3 = value;
    }

    /**
     * Gets the cetiq info3.
     *
     * @return the cetiq info3
     */
    public String getCetiqInfo3() {
        return cetiqInfo3;
    }

    /**
     * Sets the cetiq info3.
     *
     * @param value
     *            the cetiq info3
     */
    public void setCetiqInfo3(final String value) {
        cetiqInfo3 = value;
    }

    /**
     * Gets the cpath info4.
     *
     * @return the cpath info4
     */
    public String getCpathInfo4() {
        return cpathInfo4;
    }

    /**
     * Sets the cpath info4.
     *
     * @param value
     *            the cpath info4
     */
    public void setCpathInfo4(final String value) {
        cpathInfo4 = value;
    }

    /**
     * Gets the cetiq info4.
     *
     * @return the cetiq info4
     */
    public String getCetiqInfo4() {
        return cetiqInfo4;
    }

    /**
     * Sets the cetiq info4.
     *
     * @param value
     *            the cetiq info4
     */
    public void setCetiqInfo4(final String value) {
        cetiqInfo4 = value;
    }

    /**
     * Gets the cpath info5.
     *
     * @return the cpath info5
     */
    public String getCpathInfo5() {
        return cpathInfo5;
    }

    /**
     * Sets the cpath info5.
     *
     * @param value
     *            the cpath info5
     */
    public void setCpathInfo5(final String value) {
        cpathInfo5 = value;
    }

    /**
     * Gets the cetiq info5.
     *
     * @return the cetiq info5
     */
    public String getCetiqInfo5() {
        return cetiqInfo5;
    }

    /**
     * Sets the cetiq info5.
     *
     * @param value
     *            the cetiq info5
     */
    public void setCetiqInfo5(final String value) {
        cetiqInfo5 = value;
    }

    /**
     * Gets the cpath info6.
     *
     * @return the cpath info6
     */
    public String getCpathInfo6() {
        return cpathInfo6;
    }

    /**
     * Sets the cpath info6.
     *
     * @param value
     *            the cpath info6
     */
    public void setCpathInfo6(final String value) {
        cpathInfo6 = value;
    }

    /**
     * Gets the cetiq info6.
     *
     * @return the cetiq info6
     */
    public String getCetiqInfo6() {
        return cetiqInfo6;
    }

    /**
     * Sets the cetiq info6.
     *
     * @param value
     *            the cetiq info6
     */
    public void setCetiqInfo6(final String value) {
        cetiqInfo6 = value;
    }

    /**
     * Gets the lsum cuant1.
     *
     * @return the lsum cuant1
     */
    public Boolean getLsumCuant1() {
        return lsumCuant1;
    }

    /**
     * Sets the lsum cuant1.
     *
     * @param value
     *            the lsum cuant1
     */
    public void setLsumCuant1(final Boolean value) {
        lsumCuant1 = value;
    }

    /**
     * Gets the lsum cuant2.
     *
     * @return the lsum cuant2
     */
    public Boolean getLsumCuant2() {
        return lsumCuant2;
    }

    /**
     * Sets the lsum cuant2.
     *
     * @param value
     *            the lsum cuant2
     */
    public void setLsumCuant2(final Boolean value) {
        lsumCuant2 = value;
    }

    /**
     * Gets the lsum cuant3.
     *
     * @return the lsum cuant3
     */
    public Boolean getLsumCuant3() {
        return lsumCuant3;
    }

    /**
     * Sets the lsum cuant3.
     *
     * @param value
     *            the lsum cuant3
     */
    public void setLsumCuant3(final Boolean value) {
        lsumCuant3 = value;
    }

    /**
     * Gets the lsum cuant4.
     *
     * @return the lsum cuant4
     */
    public Boolean getLsumCuant4() {
        return lsumCuant4;
    }

    /**
     * Sets the lsum cuant4.
     *
     * @param value
     *            the lsum cuant4
     */
    public void setLsumCuant4(final Boolean value) {
        lsumCuant4 = value;
    }

    /**
     * Gets the lsum cuant5.
     *
     * @return the lsum cuant5
     */
    public Boolean getLsumCuant5() {
        return lsumCuant5;
    }

    /**
     * Sets the lsum cuant5.
     *
     * @param value
     *            the lsum cuant5
     */
    public void setLsumCuant5(final Boolean value) {
        lsumCuant5 = value;
    }

    /**
     * Gets the lsum cuant6.
     *
     * @return the lsum cuant6
     */
    public Boolean getLsumCuant6() {
        return lsumCuant6;
    }

    /**
     * Sets the lsum cuant6.
     *
     * @param value
     *            the lsum cuant6
     */
    public void setLsumCuant6(final Boolean value) {
        lsumCuant6 = value;
    }

    /**
     * Gets the lgrp info1.
     *
     * @return the lgrp info1
     */
    public Boolean getLgrpInfo1() {
        return lgrpInfo1;
    }

    /**
     * Sets the lgrp info1.
     *
     * @param value
     *            the lgrp info1
     */
    public void setLgrpInfo1(final Boolean value) {
        lgrpInfo1 = value;
    }

    /**
     * Gets the lgrp info2.
     *
     * @return the lgrp info2
     */
    public Boolean getLgrpInfo2() {
        return lgrpInfo2;
    }

    /**
     * Sets the lgrp info2.
     *
     * @param value
     *            the lgrp info2
     */
    public void setLgrpInfo2(final Boolean value) {
        lgrpInfo2 = value;
    }

    /**
     * Gets the lgrp info3.
     *
     * @return the lgrp info3
     */
    public Boolean getLgrpInfo3() {
        return lgrpInfo3;
    }

    /**
     * Sets the lgrp info3.
     *
     * @param value
     *            the lgrp info3
     */
    public void setLgrpInfo3(final Boolean value) {
        lgrpInfo3 = value;
    }

    /**
     * Gets the lgrp info4.
     *
     * @return the lgrp info4
     */
    public Boolean getLgrpInfo4() {
        return lgrpInfo4;
    }

    /**
     * Sets the lgrp info4.
     *
     * @param value
     *            the lgrp info4
     */
    public void setLgrpInfo4(final Boolean value) {
        lgrpInfo4 = value;
    }

    /**
     * Gets the lgrp info5.
     *
     * @return the lgrp info5
     */
    public Boolean getLgrpInfo5() {
        return lgrpInfo5;
    }

    /**
     * Sets the lgrp info5.
     *
     * @param value
     *            the lgrp info5
     */
    public void setLgrpInfo5(final Boolean value) {
        lgrpInfo5 = value;
    }

    /**
     * Gets the lgrp info6.
     *
     * @return the lgrp info6
     */
    public Boolean getLgrpInfo6() {
        return lgrpInfo6;
    }

    /**
     * Sets the lgrp info6.
     *
     * @param value
     *            the lgrp info6
     */
    public void setLgrpInfo6(final Boolean value) {
        lgrpInfo6 = value;
    }

    /**
     * Gets the prioridad.
     *
     * @return the prioridad
     */
    public Integer getPrioridad() {
        return prioridad;
    }

    /**
     * Sets the prioridad.
     *
     * @param value
     *            the prioridad
     */
    public void setPrioridad(final Integer value) {
        prioridad = value;
    }

    /**
     * Gets the cpath info1 sql.
     *
     * @return the cpath info1 sql
     */
    public String getCpathInfo1Sql() {
        return cpathInfo1Sql;
    }

    /**
     * Sets the cpath info1 sql.
     *
     * @param value
     *            the cpath info1 sql
     */
    public void setCpathInfo1Sql(final String value) {
        cpathInfo1Sql = value;
    }

    /**
     * Gets the cpath info2 sql.
     *
     * @return the cpath info2 sql
     */
    public String getCpathInfo2Sql() {
        return cpathInfo2Sql;
    }

    /**
     * Sets the cpath info2 sql.
     *
     * @param value
     *            the cpath info2 sql
     */
    public void setCpathInfo2Sql(final String value) {
        cpathInfo2Sql = value;
    }

    /**
     * Gets the cpath info3 sql.
     *
     * @return the cpath info3 sql
     */
    public String getCpathInfo3Sql() {
        return cpathInfo3Sql;
    }

    /**
     * Sets the cpath info3 sql.
     *
     * @param value
     *            the cpath info3 sql
     */
    public void setCpathInfo3Sql(final String value) {
        cpathInfo3Sql = value;
    }

    /**
     * Gets the cpath info4 sql.
     *
     * @return the cpath info4 sql
     */
    public String getCpathInfo4Sql() {
        return cpathInfo4Sql;
    }

    /**
     * Sets the cpath info4 sql.
     *
     * @param value
     *            the cpath info4 sql
     */
    public void setCpathInfo4Sql(final String value) {
        cpathInfo4Sql = value;
    }

    /**
     * Gets the cpath info5 sql.
     *
     * @return the cpath info5 sql
     */
    public String getCpathInfo5Sql() {
        return cpathInfo5Sql;
    }

    /**
     * Sets the cpath info5 sql.
     *
     * @param value
     *            the cpath info5 sql
     */
    public void setCpathInfo5Sql(final String value) {
        cpathInfo5Sql = value;
    }

    /**
     * Gets the cpath info6 sql.
     *
     * @return the cpath info6 sql
     */
    public String getCpathInfo6Sql() {
        return cpathInfo6Sql;
    }

    /**
     * Sets the cpath info6 sql.
     *
     * @param value
     *            the cpath info6 sql
     */
    public void setCpathInfo6Sql(final String value) {
        cpathInfo6Sql = value;
    }

    /**
     * Gets the cgrp info1.
     *
     * @return the cgrp info1
     */
    public Boolean getCgrpInfo1() {
        return cgrpInfo1;
    }

    /**
     * Sets the cgrp info1.
     *
     * @param value
     *            the new cgrp info1
     */
    public void setCgrpInfo1(final Boolean value) {
        cgrpInfo1 = value;
    }

    /**
     * Gets the cgrp info2.
     *
     * @return the cgrp info2
     */
    public Boolean getCgrpInfo2() {
        return cgrpInfo2;
    }

    /**
     * Sets the cgrp info2.
     *
     * @param value
     *            the new cgrp info2
     */
    public void setCgrpInfo2(final Boolean value) {
        cgrpInfo2 = value;
    }

    /**
     * Gets the cgrp info3.
     *
     * @return the cgrp info3
     */
    public Boolean getCgrpInfo3() {
        return cgrpInfo3;
    }

    /**
     * Sets the cgrp info3.
     *
     * @param value
     *            the new cgrp info3
     */
    public void setCgrpInfo3(final Boolean value) {
        cgrpInfo3 = value;
    }

    /**
     * Gets the cgrp info4.
     *
     * @return the cgrp info4
     */
    public Boolean getCgrpInfo4() {
        return cgrpInfo4;
    }

    /**
     * Sets the cgrp info4.
     *
     * @param value
     *            the new cgrp info4
     */
    public void setCgrpInfo4(final Boolean value) {
        cgrpInfo4 = value;
    }

    /**
     * Gets the cgrp info5.
     *
     * @return the cgrp info5
     */
    public Boolean getCgrpInfo5() {
        return cgrpInfo5;
    }

    /**
     * Sets the cgrp info5.
     *
     * @param value
     *            the new cgrp info5
     */
    public void setCgrpInfo5(final Boolean value) {
        cgrpInfo5 = value;
    }

    /**
     * Gets the cgrp info6.
     *
     * @return the cgrp info6
     */
    public Boolean getCgrpInfo6() {
        return cgrpInfo6;
    }

    /**
     * Sets the cgrp info6.
     *
     * @param value
     *            the new cgrp info6
     */
    public void setCgrpInfo6(final Boolean value) {
        cgrpInfo6 = value;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion.
     *
     * @param value
     *            the descripcion
     */
    public void setDescripcion(final String value) {
        descripcion = value;
    }

}
