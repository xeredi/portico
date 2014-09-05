package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoDato;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoListadoLVAction.
 */
public final class TipoDatoListadoLVAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3287472620715124846L;

    /** The lv list. */
    private final List<LabelValueVO> lvList = new ArrayList<>();

    /** The tpdt criterio. */
    private TipoDatoCriterioVO tpdtCriterio;

    /**
     * List.
     *
     * @return the string
     */
    @Action("tpdt-lv-list")
    public String list() {
        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDatoBO.class);

        lvList.addAll(tpdtBO.selectLabelValues(tpdtCriterio));

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
     * Gets the tpdt criterio.
     *
     * @return the tpdt criterio
     */
    public TipoDatoCriterioVO getTpdtCriterio() {
        return tpdtCriterio;
    }

    /**
     * Sets the tpdt criterio.
     *
     * @param value
     *            the new tpdt criterio
     */
    public void setTpdtCriterio(final TipoDatoCriterioVO value) {
        tpdtCriterio = value;
    }

}
