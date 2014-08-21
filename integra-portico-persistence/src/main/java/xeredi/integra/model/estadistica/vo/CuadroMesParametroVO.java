package xeredi.integra.model.estadistica.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.util.TipoDato;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesParametroVO.
 */
public final class CuadroMesParametroVO {

    /** The cdms id. */
    private final Long cdmsId;

    /** The pepr id. */
    private final Long peprId;

    /** The tipo dato. */
    private final TipoDato tipoDato;

    /** The cocu. */
    private final CuadroMesConcepto cocu;

    /** The opet. */
    private final String opet;

    /** The navt. */
    private final String navt;

    /** The pais. */
    private final String pais;

    /** The opet. */
    private final String opetParam;

    /** The navt. */
    private final String navtParam;

    /** The campo adicional. */
    private final String campoAdicionalParam;

    /**
     * Instantiates a new cuadro mes parametro vo.
     * 
     * @param acdmsId
     *            the acdms id
     * @param apeprId
     *            the apepr id
     * @param atipoDato
     *            the atipo dato
     * @param acocu
     *            the acocu
     * @param aopet
     *            the aopet
     * @param anavt
     *            the anavt
     * @param apais
     *            the apais
     * @param aopetParam
     *            the aopet param
     * @param anavtParam
     *            the anavt param
     * @param acampoAdicionalParam
     *            the acampo adicional param
     */
    public CuadroMesParametroVO(final Long acdmsId, final Long apeprId, final TipoDato atipoDato,
            final CuadroMesConcepto acocu, final String aopet, final String anavt, final String apais, final String aopetParam,
            final String anavtParam, final String acampoAdicionalParam) {
        super();
        cdmsId = acdmsId;
        peprId = apeprId;
        tipoDato = atipoDato;
        cocu = acocu;
        opet = aopet;
        navt = anavt;
        pais = apais;
        opetParam = aopetParam;
        navtParam = anavtParam;
        campoAdicionalParam = acampoAdicionalParam;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the cdms id.
     * 
     * @return the cdms id
     */
    public Long getCdmsId() {
        return cdmsId;
    }

    /**
     * Gets the pepr id.
     * 
     * @return the pepr id
     */
    public Long getPeprId() {
        return peprId;
    }

    /**
     * Gets the cocu.
     *
     * @return the cocu
     */
    public CuadroMesConcepto getCocu() {
        return cocu;
    }

    /**
     * Gets the opet.
     *
     * @return the opet
     */
    public String getOpet() {
        return opet;
    }

    /**
     * Gets the navt.
     *
     * @return the navt
     */
    public String getNavt() {
        return navt;
    }

    /**
     * Gets the pais.
     *
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Gets the tipo dato.
     *
     * @return the tipo dato
     */
    public TipoDato getTipoDato() {
        return tipoDato;
    }

    /**
     * Gets the opet param.
     *
     * @return the opet param
     */
    public String getOpetParam() {
        return opetParam;
    }

    /**
     * Gets the navt param.
     *
     * @return the navt param
     */
    public String getNavtParam() {
        return navtParam;
    }

    /**
     * Gets the campo adicional param.
     *
     * @return the campo adicional param
     */
    public String getCampoAdicionalParam() {
        return campoAdicionalParam;
    }
}
