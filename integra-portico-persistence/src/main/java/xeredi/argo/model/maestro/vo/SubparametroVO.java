package xeredi.argo.model.maestro.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroVO.
 */
@Data
public final class SubparametroVO extends ItemVO implements Versionable<SubparametroVersionVO> {

    /** The prmt id. */
    private Long prmtId;

    /** The prmt asociado. */
    private ParametroVO prmtAsociado;

    /** The spvr. */
    private SubparametroVersionVO version;

    /** The prto id. */
    private Long prtoId;

    /**
     * Instantiates a new subparametro vo.
     */
    public SubparametroVO() {
        super();

        version = new SubparametroVersionVO();
    }

    /**
     * Instantiates a new subparametro vo.
     *
     * @param entiDetail
     *            the enti detail
     */
    public SubparametroVO(final TipoSubparametroDetailVO entiDetail) {
        super(entiDetail);

        version = new SubparametroVersionVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        return prmtAsociado == null ? null : prmtAsociado.getEtiqueta();
    }
}
