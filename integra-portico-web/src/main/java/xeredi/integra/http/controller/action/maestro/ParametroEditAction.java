package xeredi.integra.http.controller.action.maestro;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xeredi.integra.http.controller.action.item.ItemEditAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroEditAction.
 */
public final class ParametroEditAction extends ItemEditAction<ParametroVO, TipoParametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8716069938226934369L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        enti = TipoParametroProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            model = new ParametroVO();
            i18nMap = new HashMap<String, I18nVO>();
        } else {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

            model = prmtBO.select(model.getId(), idioma, fechaVigencia);

            if (enti.getEnti().isI18n()) {
                i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getPrvr().getId());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadSpecificDependencies() throws ApplicationException {
        if (enti.getEnti().isPuerto()) {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(getSprtId());
            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    @Override
    public Date getFechaVigencia() {
        return fechaVigencia;
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

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }
}
