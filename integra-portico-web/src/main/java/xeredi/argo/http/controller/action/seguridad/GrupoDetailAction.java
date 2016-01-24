package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
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

    /** The enti list. */
    private List<Long> entiList;

    /** The acen map. */
    private Map<Long, List<AccionEntidadVO>> acenMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final GrupoBO grpoBO = new GrupoBO();

        model = grpoBO.select(model.getId());

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

        final AccionEntidadBO acenBO = new AccionEntidadBO();
        final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

        acenCriterio.setGrpoId(model.getId());
        acenCriterio.setIdioma(getIdioma());

        final List<AccionEntidadVO> acenList = acenBO.selectList(acenCriterio);

        entiList = new ArrayList<>();
        acenMap = new HashMap<>();

        for (final AccionEntidadVO acen : acenList) {
            if (!acenMap.containsKey(acen.getEntiId())) {
                entiList.add(acen.getEntiId());
                acenMap.put(acen.getEntiId(), new ArrayList<AccionEntidadVO>());
            }

            acenMap.get(acen.getEntiId()).add(acen);
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
     * Gets the enti list.
     *
     * @return the enti list
     */
    public List<Long> getEntiList() {
        return entiList;
    }

    /**
     * Gets the acen map.
     *
     * @return the acen map
     */
    public Map<Long, List<AccionEntidadVO>> getAcenMap() {
        return acenMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grpo;
    }
}
