package xeredi.argo.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoEditAction.
 */
@Data
public final class TipoDatoEditAction extends CrudEditAction<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6202167642910897080L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpdt;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The tpht list. */
    private TipoHtml[] tphtList;

    /** The tpel list. */
    private TipoElemento[] tpelList;

    /** The tppr list. */
    private List<TipoParametroVO> tpprList;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            model = new TipoDatoVO();
            i18nMap = new HashMap<>();
        } else {
            Preconditions.checkNotNull(model.getId());

            final TipoDatoBO tpdtBO = new TipoDatoBO();

            model = tpdtBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(ClassPrefix.tpdt, model.getId());
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
}
