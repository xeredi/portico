package xeredi.argo.model.servicio.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

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
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private String estado;

    /**
     * Instantiates a new subservicio vo.
     */
    public SubservicioVO() {
        super();
    }

    /**
     * Instantiates a new subservicio vo.
     *
     * @param entiDetail
     *            the enti detail
     */
    public SubservicioVO(final TipoSubservicioDetailVO entiDetail) {
        super(entiDetail);

        estado = entiDetail.getEnti().getEstadoDef();
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
        if (srvc == null || srvc.getId() == null) {
            return null;
        }

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
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the new finicio
     */
    public void setFini(final Date value) {
        fini = value;
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