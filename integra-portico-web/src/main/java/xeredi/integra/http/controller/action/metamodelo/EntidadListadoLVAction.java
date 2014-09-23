package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadListadoLVAction.
 */
public final class EntidadListadoLVAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8905486687387327395L;

    /** The enti criterio. */
    private EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

    /** The lv list. */
    private final List<LabelValueVO> lvList = new ArrayList<>();

    /**
     * List.
     *
     * @return the string
     */
    @Action("enti-lv-list")
    public String list() {
        final EntidadBO entiBO = new EntidadBO();

        lvList.addAll(entiBO.selectLabelValues(entiCriterio));

        return SUCCESS;
    }

    /**
     * Gets the lv list.
     *
     * @return the lv list
     */
    public List<LabelValueVO> getLvList() {
        return lvList;
    }

    /**
     * Gets the enti criterio.
     *
     * @return the enti criterio
     */
    public EntidadCriterioVO getEntiCriterio() {
        return entiCriterio;
    }

    /**
     * Sets the enti criterio.
     *
     * @param value
     *            the new enti criterio
     */
    public void setEntiCriterio(final EntidadCriterioVO value) {
        entiCriterio = value;
    }

}
