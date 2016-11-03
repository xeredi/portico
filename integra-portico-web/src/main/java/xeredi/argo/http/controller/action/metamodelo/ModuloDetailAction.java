package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ModuloDetailAction extends CrudDetailAction<ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 696320810765547190L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final ModuloBO mdloBO = new ModuloBO();
        final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

        mdloCriterio.setId(model.getId());

        model = mdloBO.selectObject(mdloCriterio);
        i18nMap = I18nUtilBO.selectMap(model);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setFncdId(model.getId());
        grpoCriterio.setIdioma(getIdioma());

        grpoList = grpoBO.selectList(grpoCriterio);
    }
}
