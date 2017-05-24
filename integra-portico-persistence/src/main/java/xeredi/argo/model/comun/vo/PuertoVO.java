package xeredi.argo.model.comun.vo;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoVO.
 */
@Data
public final class PuertoVO implements Identifiable, I18nable, Serializable {

	/** The prefix. */
	private final transient ClassPrefix prefix = ClassPrefix.prto;

	/** The id. */
	private Long id;

	/** The sprt. */
	private SuperpuertoVO sprt = new SuperpuertoVO();

	/** The codigo. */
	private String codigo;

	/** The codigo corto. */
	private String codigoCorto;

	/** The codigo edi. */
	private String codigoEdi;

	/** The rec aduanero. */
	private String recAduanero;

	/** The unlocode. */
	private String unlocode;

	/** The nombre. */
	private String nombre;

	/**
	 * Gets the etiqueta.
	 *
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		final StringBuffer buffer = new StringBuffer();

		if (codigo != null) {
			buffer.append(codigo);
		}

		if (nombre != null) {
			buffer.append(" - ").append(nombre);
		}

		return buffer.toString();
	}
}
