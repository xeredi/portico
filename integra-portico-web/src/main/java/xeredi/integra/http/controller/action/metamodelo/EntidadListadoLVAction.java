package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadListadoLVAction.
 */
public final class EntidadListadoLVAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8905486687387327395L;

    /** The lv list. */
    private final List<LabelValueVO> lvList = new ArrayList<>();

    /**
     * List.
     *
     * @return the string
     */
    @Action("enti-lv-list")
    public String list() {
        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);

        lvList.addAll(entiBO.selectLabelValues());

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

}
