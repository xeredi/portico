package xeredi.argo.http.controller.action.facturacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.proceso.facturacion.ProcesoFacturador;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorSaveAction.
 */
public final class FacturadorSaveAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2241047270819035432L;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The ffac. */
    private Date ffac;

    /** The aspc id. */
    private Long aspcId;

    /** The fcsr id. */
    private Long fcsrId;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        FieldValidator.validateRequired(this, MessageI18nKey.fctr_ffac, ffac);
        FieldValidator.validateRequired(this, MessageI18nKey.fcsr, fcsrId);

        if (!hasErrors()) {
            final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            final ProcesoBO prbtBO = new ProcesoBO();
            final List<Long> itemEntradaList = Arrays.asList(vlrc.getId());
            final Map<String, String> parametroMap = new HashMap<>();

            parametroMap.put(ProcesoFacturador.FFAC_PARAM, dateFormat.format(ffac));
            parametroMap.put(ProcesoFacturador.FCSRID_PARAM, fcsrId.toString());

            if (aspcId != null) {
                parametroMap.put(ProcesoFacturador.ASPCID_PARAM, aspcId.toString());
            }

            prbtBO.crear(ProcesoTipo.FACTURADOR, parametroMap, ItemTipo.vlrc, itemEntradaList, null);
        }
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the new vlrc
     */
    public void setVlrc(final ValoracionVO value) {
        vlrc = value;
    }

    /**
     * Sets the ffac.
     *
     * @param value
     *            the new ffac
     */
    public void setFfac(final Date value) {
        ffac = value;
    }

    /**
     * Sets the aspc id.
     *
     * @param value
     *            the new aspc id
     */
    public void setAspcId(final Long value) {
        aspcId = value;
    }

    /**
     * Sets the fcsr id.
     *
     * @param value
     *            the new fcsr id
     */
    public void setFcsrId(final Long value) {
        fcsrId = value;
    }
}
