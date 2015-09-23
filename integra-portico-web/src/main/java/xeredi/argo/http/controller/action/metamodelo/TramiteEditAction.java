package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteEditAction.
 */
public final class TramiteEditAction extends CrudEditAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5189072539193429710L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti. */
    private TipoDatoVO tpdtEstado;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        final TramiteBO trmtBO = new TramiteBO();

        switch (accion) {
        case create:
            Preconditions.checkNotNull(model.getEntiId());

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            model = trmtBO.select(model.getId(), getIdioma());

            i18nMap = I18nBO.selectMap(I18nPrefix.trmt, model.getId());

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
        final EntidadBO entiBO = new EntidadBO();
        final TipoDatoBO tpdtBO = new TipoDatoBO();

        final EntidadVO enti = entiBO.select(model.getEntiId(), getIdioma());

        switch (enti.getTipo()) {
        case T:
            final TipoServicioBO tpsrBO = new TipoServicioBO();
            final TipoServicioVO tpsr = tpsrBO.select(model.getEntiId(), getIdioma());

            Preconditions.checkNotNull(tpsr.getTpdtEstado().getId());

            tpdtEstado = tpdtBO.select(tpsr.getTpdtEstado().getId(), getIdioma());

            break;
        case S:
            final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
            final TipoSubservicioVO tpss = tpssBO.select(model.getEntiId(), getIdioma());

            Preconditions.checkNotNull(tpss.getTpdtEstado().getId());

            tpdtEstado = tpdtBO.select(tpss.getTpdtEstado().getId(), getIdioma());

            break;
        default:
            throw new Error("Invalid Entity Type: " + enti.getTipo().name());
        }
    }

    /**
     * Gets the tpdt estado.
     *
     * @return the tpdt estado
     */
    public TipoDatoVO getTpdtEstado() {
        return tpdtEstado;
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
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.trmt;
    }
}
