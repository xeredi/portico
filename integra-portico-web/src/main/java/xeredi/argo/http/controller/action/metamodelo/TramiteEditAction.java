package xeredi.argo.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteEditAction.
 */
public final class TramiteEditAction extends CrudEditAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5189072539193429710L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The enti. */
    @Getter
    private TipoDatoVO tpdtEstado;
    
    @Inject
    private TipoDatoService tpdtService;

	@Inject
	private TipoServicioService tpsrService;

    @Inject
	private EntidadService entiService;

	@Inject
	private I18nService i18nService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        final TramiteBO trmtBO = new TramiteBO();

        switch (accion) {
        case create:
            Preconditions.checkNotNull(model.getEntiId());

            i18nMap = new HashMap<>();

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            model = trmtBO.select(model.getId(), getIdioma());
            i18nMap = i18nService.selectMap(model);

            break;
        default:
            throw new Error("Invalid Action: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        final EntidadVO enti = entiService.select(model.getEntiId(), getIdioma());

        switch (enti.getTipo()) {
        case T:
            final TipoServicioVO tpsr = tpsrService.select(model.getEntiId(), getIdioma());

            Preconditions.checkNotNull(tpsr.getTpdtEstado());
            Preconditions.checkNotNull(tpsr.getTpdtEstado().getId());

            tpdtEstado = tpdtService.select(tpsr.getTpdtEstado().getId(), getIdioma());

            break;
        case S:
            final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
            final TipoSubservicioVO tpss = tpssBO.select(model.getEntiId(), getIdioma());

            Preconditions.checkNotNull(tpss.getTpdtEstado());
            Preconditions.checkNotNull(tpss.getTpdtEstado().getId());

            tpdtEstado = tpdtService.select(tpss.getTpdtEstado().getId(), getIdioma());

            break;
        default:
            throw new Error("Invalid Entity Type: " + enti.getTipo().name());
        }
    }
}
