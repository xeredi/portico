package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroDetailAction.
 */
public final class ParametroDetailAction extends ItemDetailAction<ParametroVO, TipoParametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6639690925171727021L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

        model = prmtBO.select(model.getId(), idioma, fechaVigencia);
        enti = TipoParametroProxy.select(model.getEntiId());

        if (enti.getEnti().isI18n()) {
            i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getPrvr().getId());
        }
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
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
}
