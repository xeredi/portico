package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

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

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        Preconditions.checkNotNull(fechaVigencia);

        enti = TipoParametroProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            i18nMap = new HashMap<String, I18nVO>();
        } else {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

            model = prmtBO.select(model.getId(), idioma, fechaVigencia);

            if (accion == ACCION_EDICION.duplicate_version) {
                if (model.getVersion().getFfin() != null) {
                    model.getVersion().setFini(model.getVersion().getFfin());
                    model.getVersion().setFfin(null);
                } else {
                    final Calendar ffin = Calendar.getInstance();

                    ffin.set(Calendar.HOUR_OF_DAY, 0);
                    ffin.set(Calendar.MINUTE, 0);
                    ffin.set(Calendar.SECOND, 0);
                    ffin.set(Calendar.MILLISECOND, 0);

                    model.getVersion().setFini(ffin.getTime());
                }
            }

            if (enti.getEnti().isI18n()) {
                i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getVersion().getId());
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
