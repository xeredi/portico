package xeredi.integra.model.vo.facturacion;

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
    public void setId(Long value) {
        this.id = value;
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
    public void setFini(Date value) {
        this.fini = value;
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
    public void setFfin(Date value) {
        this.ffin = value;
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
    public void setCpathInfo1(String value) {
        this.cpathInfo1 = value;
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
    public void setCetiqInfo1(String value) {
        this.cetiqInfo1 = value;
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
    public void setCpathInfo2(String value) {
        this.cpathInfo2 = value;
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
    public void setCetiqInfo2(String value) {
        this.cetiqInfo2 = value;
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
    public void setCpathInfo3(String value) {
        this.cpathInfo3 = value;
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
    public void setCetiqInfo3(String value) {
        this.cetiqInfo3 = value;
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
    public void setCpathInfo4(String value) {
        this.cpathInfo4 = value;
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
    public void setCetiqInfo4(String value) {
        this.cetiqInfo4 = value;
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
    public void setCpathInfo5(String value) {
        this.cpathInfo5 = value;
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
    public void setCetiqInfo5(String value) {
        this.cetiqInfo5 = value;
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
    public void setCpathInfo6(String value) {
        this.cpathInfo6 = value;
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
    public void setCetiqInfo6(String value) {
        this.cetiqInfo6 = value;
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
    public void setLsumCuant1(Boolean value) {
        this.lsumCuant1 = value;
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
    public void setLsumCuant2(Boolean value) {
        this.lsumCuant2 = value;
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
    public void setLsumCuant3(Boolean value) {
        this.lsumCuant3 = value;
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
    public void setLsumCuant4(Boolean value) {
        this.lsumCuant4 = value;
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
    public void setLsumCuant5(Boolean value) {
        this.lsumCuant5 = value;
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
    public void setLsumCuant6(Boolean value) {
        this.lsumCuant6 = value;
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
    public void setLgrpInfo1(Boolean value) {
        this.lgrpInfo1 = value;
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
    public void setLgrpInfo2(Boolean value) {
        this.lgrpInfo2 = value;
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
    public void setLgrpInfo3(Boolean value) {
        this.lgrpInfo3 = value;
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
    public void setLgrpInfo4(Boolean value) {
        this.lgrpInfo4 = value;
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
    public void setLgrpInfo5(Boolean value) {
        this.lgrpInfo5 = value;
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
    public void setLgrpInfo6(Boolean value) {
        this.lgrpInfo6 = value;
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
    public void setPrioridad(Integer value) {
        this.prioridad = value;
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
    public void setCpathInfo1Sql(String value) {
        this.cpathInfo1Sql = value;
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
    public void setCpathInfo2Sql(String value) {
        this.cpathInfo2Sql = value;
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
    public void setCpathInfo3Sql(String value) {
        this.cpathInfo3Sql = value;
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
    public void setCpathInfo4Sql(String value) {
        this.cpathInfo4Sql = value;
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
    public void setCpathInfo5Sql(String value) {
        this.cpathInfo5Sql = value;
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
    public void setCpathInfo6Sql(String value) {
        this.cpathInfo6Sql = value;
    }

}
