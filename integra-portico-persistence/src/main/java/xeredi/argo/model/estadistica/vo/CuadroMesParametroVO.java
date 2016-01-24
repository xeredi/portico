package xeredi.argo.model.estadistica.vo;

import lombok.Data;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesParametroVO.
 */
@Data
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
}
