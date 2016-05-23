package xeredi.argo.model.maestro.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class SubparametroVO extends ItemVO implements Versionable<SubparametroVersionVO> {

    /** The prmt id. */
    private Long prmtId;

    /** The prmt asociado. */
    private ParametroVO prmtAsociado;

    /** The spvr. */
    private SubparametroVersionVO version = new SubparametroVersionVO();

    /** The prto id. */
    private Long prtoId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        return prmtAsociado == null ? null : prmtAsociado.getEtiqueta();
    }
}
