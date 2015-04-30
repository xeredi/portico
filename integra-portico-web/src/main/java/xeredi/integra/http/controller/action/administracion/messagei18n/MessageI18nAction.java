package xeredi.integra.http.controller.action.administracion.messagei18n;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.bo.MessageBO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.MessageI18nVO;

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
    private MessageI18nKey key;

    /** The i18n map. */
    private Map<String, MessageI18nVO> m18nMap;

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("m18n-detail")
    public String detail() {
        Preconditions.checkNotNull(key);

        final MessageBO mesgBO = new MessageBO();

        m18nMap = mesgBO.selectKeyMap(key);

        return SUCCESS;
    }

    /**
     * Update.
     *
     * @return the string
     */
    @Action("m18n-edit")
    public String edit() {
        Preconditions.checkNotNull(key);

        final MessageBO mesgBO = new MessageBO();

        m18nMap = mesgBO.selectKeyMap(key);
        accion = ACCION_EDICION.edit;

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
        Preconditions.checkNotNull(key);

        final MessageBO mesgBO = new MessageBO();

        if (accion == ACCION_EDICION.edit) {
            mesgBO.updateKeyMap(key, m18nMap);
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
     * Gets the key.
     *
     * @return the key
     */
    public MessageI18nKey getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param value
     *            the new key
     */
    public void setKey(final MessageI18nKey value) {
        key = value;
    }

    /**
     * Gets the m18n map.
     *
     * @return the m18n map
     */
    public Map<String, MessageI18nVO> getM18nMap() {
        return m18nMap;
    }

    /**
     * Sets the m18n map.
     *
     * @param value
     *            the value
     */
    public void setM18nMap(final Map<String, MessageI18nVO> value) {
        m18nMap = value;
    }

}
