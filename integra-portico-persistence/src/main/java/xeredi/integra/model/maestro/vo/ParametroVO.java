package xeredi.integra.model.maestro.vo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * Datos de un parametro.
 */
public final class ParametroVO extends ItemVO {

    /** Descripcion del parametro. */
    private String parametro;

    /** The prvr. */
    private ParametroVersionVO prvr;

    /** Datos de i18n del parametro. */
    private ParametroI18nVO i18n;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * New instance.
     * 
     * @param tpprVO
     *            the tppr vo
     * @return the parametro vo
     */
    public static ParametroVO newInstance(final TipoParametroVO tpprVO) {
        final ParametroVO prmtVO = new ParametroVO();

        prmtVO.setEntiId(tpprVO.getId());
        prmtVO.setPrvr(new ParametroVersionVO());

        if (tpprVO.isI18n()) {
            prmtVO.setI18n(new ParametroI18nVO());
        }

        if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
            final Map<Long, ItemDatoVO> itdtMap = new HashMap<>();

            for (final Long tpdtId : tpprVO.getEntdList()) {
                final ItemDatoVO itdtVO = new ItemDatoVO();

                itdtVO.setTpdtId(tpdtId);
                itdtMap.put(itdtVO.getTpdtId(), itdtVO);
            }

            prmtVO.setItdtMap(itdtMap);
        }

        return prmtVO;
    }

    /**
     * Gets the etiqueta string buffer.
     * 
     * @return the etiqueta string buffer
     */
    private StringBuffer getEtiquetaStringBuffer() {
        final StringBuffer buffer = new StringBuffer();

        if (parametro != null) {
            buffer.append(parametro);
        }

        if (i18n != null && i18n.getTexto() != null) {
            buffer.append(" - ").append(i18n.getTexto());
        }

        return buffer;
    }

    /**
     * Gets the etiqueta.
     * 
     * @return the etiqueta
     */
    @Override
    public String getEtiqueta() {
        final StringBuffer buffer = getEtiquetaStringBuffer();

        return buffer.length() == 0 ? null : StringEscapeUtils.escapeHtml4(buffer.toString());
    }

    /**
     * Gets the etiqueta csv.
     * 
     * @return the etiqueta csv
     */
    public String getEtiquetaCSV() {
        final StringBuffer buffer = getEtiquetaStringBuffer();

        return buffer.length() == 0 ? null : StringEscapeUtils.escapeCsv(buffer.toString());
    }

    /**
     * Gets the descripcion.
     * 
     * @return the descripcion
     */
    public String getParametro() {
        return parametro;
    }

    /**
     * Sets the descripcion.
     * 
     * @param value
     *            the new descripcion
     */
    public void setParametro(final String value) {
        if (value != null) {
            parametro = value.trim().toUpperCase();
        }
    }

    /**
     * Gets the i18n.
     * 
     * @return the i18n
     */
    public ParametroI18nVO getI18n() {
        return i18n;
    }

    /**
     * Sets the i18n.
     * 
     * @param value
     *            the new i18n
     */
    public void setI18n(final ParametroI18nVO value) {
        i18n = value;
    }

    /**
     * Gets the prvr.
     * 
     * @return the prvr
     */
    public ParametroVersionVO getPrvr() {
        return prvr;
    }

    /**
     * Sets the prvr.
     * 
     * @param value
     *            the new prvr
     */
    public void setPrvr(final ParametroVersionVO value) {
        prvr = value;
    }

}
