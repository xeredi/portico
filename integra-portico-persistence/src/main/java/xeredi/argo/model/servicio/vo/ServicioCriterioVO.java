package xeredi.argo.model.servicio.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class ServicioCriterioVO extends ItemCriterioVO {

	/**
	 * The Enum OrderByColumn.
	 */
	public enum OrderByColumn {
		/** The srvc pk. */
		srvc_pk,
		/** The srvc subp pk. */
		srvc_subp_pk,
		/** The srvc anno. */
		srvc_anno,
		/** The srvc numero. */
		srvc_numero,
		/** The srvc estado. */
		srvc_estado,
		/** The srvc fref. */
		srvc_fref,
		/** The srvc fini. */
		srvc_fini,
		/** The srvc ffin. */
		srvc_ffin
	}

	/** The usro id. */
	private Long usroId;

	/** The subp id. */
	private PuertoCriterioVO prto;

	/** The anno. */
	private String anno;

	/** The numero. */
	private String numero;

	/** The estado. */
	private String estado;

	/** The fref min. */
	private Date frefMin;

	/** The fref max. */
	private Date frefMax;

	/** The fini min. */
	private Date finiMin;

	/** The fini max. */
	private Date finiMax;

	/** The ffin min. */
	private Date ffinMin;

	/** The ffin max. */
	private Date ffinMax;

	/** The srvc dep id. */
	private Long srvcDepId;
}
