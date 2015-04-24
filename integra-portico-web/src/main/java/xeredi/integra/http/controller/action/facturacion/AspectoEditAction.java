package xeredi.integra.http.controller.action.facturacion;

import java.util.Date;
import java.util.List;
import java.util.Map;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.AspectoVersionVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoEditAction.
 */
public final class AspectoEditAction extends CrudEditAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6065040172880726006L;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti list. */
    private List<LabelValueVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            model = new AspectoVO();
            model.setVersion(new AspectoVersionVO());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(fechaVigencia);

            final AspectoBO aspcBO = new AspectoBO();
            final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

            aspcCriterio.setId(model.getId());
            aspcCriterio.setFechaVigencia(fechaVigencia);
            aspcCriterio.setIdioma(idioma);

            model = aspcBO.selectObject(aspcCriterio);
            i18nMap = I18nBO.selectMap(I18nPrefix.aspv, model.getVersion().getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        tpsrList = TipoServicioProxy.selectLabelValues();
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}