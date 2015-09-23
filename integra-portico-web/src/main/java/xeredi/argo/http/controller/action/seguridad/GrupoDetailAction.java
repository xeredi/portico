package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoDetailAction.
 */
public final class GrupoDetailAction extends CrudDetailAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1779406545837488228L;

    /** The prefix list. */
    private List<AccionPrefix> prefixList;

    /** The accn map. */
    private Map<AccionPrefix, List<AccionVO>> accnMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setId(model.getId());

        model = grpoBO.selectObject(grpoCriterio);

        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        accnCriterio.setGrpoId(model.getId());

        final List<AccionVO> accnList = accnBO.selectList(accnCriterio);

        prefixList = new ArrayList<>();
        accnMap = new HashMap<>();

        for (final AccionVO accn : accnList) {
            if (!accnMap.containsKey(accn.getPrefix())) {
                prefixList.add(accn.getPrefix());
                accnMap.put(accn.getPrefix(), new ArrayList<AccionVO>());
            }

            accnMap.get(accn.getPrefix()).add(accn);
        }
    }

    /**
     * Gets the prefix list.
     *
     * @return the prefix list
     */
    public List<AccionPrefix> getPrefixList() {
        return prefixList;
    }

    /**
     * Gets the accn map.
     *
     * @return the accn map
     */
    public Map<AccionPrefix, List<AccionVO>> getAccnMap() {
        return accnMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grpo;
    }
}
