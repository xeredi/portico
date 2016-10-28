package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroEditAction.
 */
public final class ParametroEditAction extends ItemEditAction<ParametroVO, TipoParametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8716069938226934369L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The prto list. */
    @Getter
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        enti = TipoParametroProxy.select(model.getEntiId());

        if (accion == AccionCodigo.create) {
            i18nMap = new HashMap<String, I18nVO>();
        } else {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

            model = prmtBO.select(model.getId(), idioma, model.getFref());

            if (accion == AccionCodigo.duplicate_version) {
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
        if (enti.getEnti().getPuerto()) {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(getSprtId());
            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }
    }
}
