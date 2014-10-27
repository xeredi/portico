package xeredi.integra.http.controller.action.administracion.messagei18n;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.MessageI18nBO;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nAction.
 */
public final class MessageI18nAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3463508301087452779L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The m18n. */
    private MessageI18nVO m18n;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("m18n-detail")
    public String detail() {
        Preconditions.checkNotNull(m18n);
        Preconditions.checkNotNull(m18n.getKey());

        final MessageI18nBO m18nBO = new MessageI18nBO();

        // m18n = m18nBO.select(m18n.getKey());

        return SUCCESS;
    }

    /**
     * Update.
     *
     * @return the string
     */
    @Action("m18n-edit")
    public String edit() {
        Preconditions.checkNotNull(m18n);
        Preconditions.checkNotNull(m18n.getKey());

        accion = ACCION_EDICION.edit;
        i18nMap = new HashMap<String, I18nVO>();

        final MessageI18nBO m18nBO = new MessageI18nBO();
        final List<MessageI18nVO> m18nList = m18nBO.selectList(m18n.getKey());

        for (final MessageI18nVO vo : m18nList) {
            m18n = vo;
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("m18n-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(m18n);
        Preconditions.checkNotNull(m18n.getKey());

        final MessageI18nBO m18nBO = new MessageI18nBO();

        if (accion == ACCION_EDICION.edit) {
            // m18nBO.update(m18n);
        }

        return SUCCESS;
    }

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the m18n.
     *
     * @return the m18n
     */
    public MessageI18nVO getM18n() {
        return m18n;
    }

    /**
     * Sets the m18n.
     *
     * @param value
     *            the new m18n
     */
    public void setM18n(final MessageI18nVO value) {
        m18n = value;
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
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }

}
