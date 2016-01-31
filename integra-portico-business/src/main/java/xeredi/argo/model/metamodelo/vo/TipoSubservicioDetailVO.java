package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioDetailVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoSubservicioDetailVO extends AbstractEntidadDetailVO {

    /** The tpss. */
    private TipoSubservicioVO enti;

    public SubservicioVO createItem() {
        final SubservicioVO item = new SubservicioVO();

        fillItem(item);

        item.setEstado(enti.getEstadoDef());

        return item;
    }
}
