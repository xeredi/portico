package xeredi.integra.model.metamodelo.vo;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoVO.
 */
public final class TipoDatoVO {

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The tpht. */
    private TipoHtml tpht;

    /** The tppr. */
    private EntidadVO enti;

    /** The tipo elemento. */
    private TipoElemento tipoElemento;

    /** Lista de Codigos de Referencia (solo si el tipo de elemento es 'R'). */
    private List<CodigoReferenciaVO> cdrfList;

    /** The cdrf code set. */
    private Set<String> cdrfCodeSet;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the nombre.
     * 
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     * 
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

    /**
     * Gets the tpht.
     * 
     * @return the tpht
     */
    public TipoHtml getTpht() {
        return tpht;
    }

    /**
     * Sets the tpht.
     * 
     * @param value
     *            the new tpht
     */
    public void setTpht(final TipoHtml value) {
        tpht = value;
    }

    /**
     * Gets the enti.
     * 
     * @return the enti
     */
    public EntidadVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     * 
     * @param value
     *            the new enti
     */
    public void setEnti(final EntidadVO value) {
        enti = value;
    }

    /**
     * Gets the tipo elemento.
     * 
     * @return the tipo elemento
     */
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    /**
     * Sets the tipo elemento.
     * 
     * @param value
     *            the new tipo elemento
     */
    public void setTipoElemento(final TipoElemento value) {
        tipoElemento = value;
    }

    /**
     * Gets the cr list.
     * 
     * @return the cr list
     */
    public List<CodigoReferenciaVO> getCdrfList() {
        return cdrfList;
    }

    /**
     * Sets the cr list.
     * 
     * @param value
     *            the new cr list
     */
    public void setCdrfList(final List<CodigoReferenciaVO> value) {
        cdrfList = value;
    }

    /**
     * Gets the cdrf code set.
     * 
     * @return the cdrf code set
     */
    public Set<String> getCdrfCodeSet() {
        return cdrfCodeSet;
    }

    /**
     * Sets the cdrf code set.
     * 
     * @param value
     *            the new cdrf code set
     */
    public void setCdrfCodeSet(final Set<String> value) {
        cdrfCodeSet = value;
    }

    /**
     * Gets the codigo.
     * 
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     * 
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

}
