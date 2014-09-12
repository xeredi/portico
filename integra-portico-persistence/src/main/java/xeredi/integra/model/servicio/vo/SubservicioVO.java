package xeredi.integra.model.servicio.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioVO.
 */
public final class SubservicioVO extends ItemVO {

    /** The srvc id. */
    private ServicioVO srvc;

    /** The numero. */
    private Integer numero;

    /** The finicio. */
    private Date finicio;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private String estado;

    /**
     * Instancia un nuevo {@link SubservicioVO} con todos sus datos asociados.
     *
     * @param tpssVO
     *            Tipo de Subervicio del que se quiere instanciar un subservicio.
     * @return Subservicio creado.
     */
    public static SubservicioVO newInstance(final TipoSubservicioVO tpssVO) {
        final SubservicioVO ssrvVO = new SubservicioVO();

        ssrvVO.setEntiId(tpssVO.getId());

        if (tpssVO.getEntdList() != null && !tpssVO.getEntdList().isEmpty()) {
            final Map<String, ItemDatoVO> itdtMap = new HashMap<>();

            for (final Long tpdtId : tpssVO.getEntdList()) {
                final ItemDatoVO itdtVO = new ItemDatoVO();

                itdtVO.setTpdtId(tpdtId);
                itdtMap.put(itdtVO.getTpdtId().toString(), itdtVO);
            }

            ssrvVO.setItdtMap(itdtMap);
        }

        return ssrvVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        final StringBuffer buffer = new StringBuffer();

        if (srvc != null) {
            buffer.append(srvc.getEtiqueta());
            buffer.append(" - ");
        }

        buffer.append(numero);

        return buffer.toString();
    }

    /**
     * Gets the srvc id.
     *
     * @return the srvc id
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc id.
     *
     * @param value
     *            the new srvc id
     */
    public void setSrvc(final ServicioVO value) {
        srvc = value;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param value
     *            the new numero
     */
    public void setNumero(final Integer value) {
        numero = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the new finicio
     */
    public void setFinicio(final Date value) {
        finicio = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the new ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the new estado
     */
    public void setEstado(final String value) {
        estado = value;
    }

}
