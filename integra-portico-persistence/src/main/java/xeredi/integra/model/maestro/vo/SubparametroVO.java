package xeredi.integra.model.maestro.vo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroVO.
 */
public final class SubparametroVO extends ItemVO {

    /** The prmt id. */
    private Long prmtId;

    /** The prmt asociado. */
    private ParametroVO prmtAsociado;

    /** The spvr. */
    private SubparametroVersionVO spvr;

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
     * @param tpspVO
     *            the tpsp vo
     * @return the subparametro vo
     */
    public static SubparametroVO newInstance(final TipoSubparametroVO tpspVO) {
        final SubparametroVO sprmVO = new SubparametroVO();

        sprmVO.setEntiId(tpspVO.getId());
        sprmVO.setSpvr(new SubparametroVersionVO());

        if (tpspVO.isI18n()) {
            // TODO Implementar si puede haber i18n
        }

        if (tpspVO.getEntdList() != null && !tpspVO.getEntdList().isEmpty()) {
            final Map<Long, ItemDatoVO> itdtMap = new HashMap<>();

            for (final Long tpdtId : tpspVO.getEntdList()) {
                final ItemDatoVO itdtVO = new ItemDatoVO();

                itdtVO.setTpdtId(tpdtId);
                itdtMap.put(itdtVO.getTpdtId(), itdtVO);
            }

            sprmVO.setItdtMap(itdtMap);
        }

        return sprmVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        return prmtAsociado == null ? null : prmtAsociado.getEtiqueta();
    }

    /**
     * Gets the prmt id.
     * 
     * @return the prmt id
     */
    public Long getPrmtId() {
        return prmtId;
    }

    /**
     * Sets the prmt id.
     * 
     * @param value
     *            the new prmt id
     */
    public void setPrmtId(Long value) {
        this.prmtId = value;
    }

    /**
     * Gets the prmt asociado.
     * 
     * @return the prmt asociado
     */
    public ParametroVO getPrmtAsociado() {
        return prmtAsociado;
    }

    /**
     * Sets the prmt asociado.
     * 
     * @param value
     *            the new prmt asociado
     */
    public void setPrmtAsociado(ParametroVO value) {
        this.prmtAsociado = value;
    }

    /**
     * Gets the spvr.
     * 
     * @return the spvr
     */
    public SubparametroVersionVO getSpvr() {
        return spvr;
    }

    /**
     * Sets the spvr.
     * 
     * @param value
     *            the new spvr
     */
    public void setSpvr(SubparametroVersionVO value) {
        this.spvr = value;
    }

}
