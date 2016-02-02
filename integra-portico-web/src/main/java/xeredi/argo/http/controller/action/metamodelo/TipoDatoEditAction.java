package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoEditAction.
 */
public final class TipoDatoEditAction extends CrudEditAction<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6202167642910897080L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The tpht list. */
    @Getter
    private TipoHtml[] tphtList;

    /** The tpel list. */
    @Getter
    private TipoElemento[] tpelList;

    /** The tppr list. */
    @Getter
    private List<TipoParametroVO> tpprList;

    /** The tpsr list. */
    @Getter
    private List<TipoServicioVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            model = new TipoDatoVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final TipoDatoBO tpdtBO = new TipoDatoBO();

            model = tpdtBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(I18nPrefix.tpdt, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        tpelList = TipoElemento.values();
        tphtList = TipoHtml.values();

        final TipoParametroBO tpprBO = new TipoParametroBO();
        final TipoParametroCriterioVO tpprCriterio = new TipoParametroCriterioVO();

        tpprCriterio.setIdioma(idioma);

        tpprList = tpprBO.selectList(tpprCriterio);

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

        tpsrCriterio.setIdioma(idioma);

        tpsrList = tpsrBO.selectList(tpsrCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpdt;
    }
}
