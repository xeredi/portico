package xeredi.integra.model.estadistica.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesParametroVO.
 */
public final class CuadroMesParametroVO {

    /** The pepr id. */
    private final Long peprId;

    /** The enti. */
    private final Entidad enti;

    /** The cocu. */
    private final CuadroMesConcepto cocu;

    /** The orden. */
    private final int orden;

    /** The tipo dato. */
    private final TipoDato tipoDato;

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
     * @param apeprId
     *            the apepr id
     * @param aenti
     *            the aenti
     * @param acocu
     *            the acocu
     * @param aorden
     *            the aorden
     * @param atipoDato
     *            the atipo dato
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
    public CuadroMesParametroVO(final Long apeprId, final Entidad aenti, final CuadroMesConcepto acocu,
            final int aorden, final TipoDato atipoDato, final String aopet, final String anavt, final String apais,
            final String aopetParam, final String anavtParam, final String acampoAdicionalParam) {
        super();
        peprId = apeprId;
        enti = aenti;
        cocu = acocu;
        orden = aorden;
        tipoDato = atipoDato;
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

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final Entidad getEnti() {
        return enti;
    }

    /**
     * Gets the orden.
     *
     * @return the orden
     */
    public final int getOrden() {
        return orden;
    }
}
