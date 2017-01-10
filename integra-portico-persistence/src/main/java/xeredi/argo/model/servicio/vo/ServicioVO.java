package xeredi.argo.model.servicio.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioVO.
 */

/**
 * Instantiates a new servicio VO.
 */
@Data

/*
 * (non-Javadoc)
 *
 * @see xeredi.argo.model.item.vo.ItemVO#hashCode()
 */
@EqualsAndHashCode(callSuper = true)

/*
 * (non-Javadoc)
 *
 * @see xeredi.argo.model.item.vo.ItemVO#toString()
 */
@ToString(callSuper = true)
public final class ServicioVO extends ItemVO implements I18nable {

	/** The Constant NUMERO_LENGTH. */
	public static final int NUMERO_LENGTH = 5;

	/** The subpuerto. */
	private PuertoVO prto;

	/** The anno. */
	private String anno;

	/** The numero. */
	private String numero;

	/** The falta. */
	private Date falta;

	/** The fbaja. */
	private Date fbaja;

	/** The finicio. */
	private Date fini;

	/** The ffin. */
	private Date ffin;

	/** The estado. */
	private String estado;

	/**
	 * Convert numero.
	 *
	 * @param numero
	 *            the numero
	 * @return the string
	 */
	public static final String convertNumero(final Integer numero) {
		return StringUtils.leftPad(String.valueOf(numero), NUMERO_LENGTH, '0');
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEtiqueta() {
		if ((prto == null || prto.getCodigo() == null) && anno == null && numero == null) {
			return null;
		}

		final StringBuffer buffer = new StringBuffer();

		buffer.append(prto == null ? "-" : prto.getCodigo()).append('/').append(anno).append('/').append(numero);

		return buffer.toString();
	}
}
