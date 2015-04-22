package xeredi.integra.http.controller.action.seguridad;

import java.util.List;

import xeredi.integra.http.controller.action.GridFilterAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioFilterAction.
 */
public final class UsuarioFilterAction extends GridFilterAction<UsuarioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6193819984435577729L;

    /** The sprt list. */
    private List<SuperpuertoVO> sprtList;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setIdioma(getIdioma());

        sprtList = sprtBO.selectList(sprtCriterio);

        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);
    }

    /**
     * Gets the sprt list.
     *
     * @return the sprt list
     */
    public List<SuperpuertoVO> getSprtList() {
        return sprtList;
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
