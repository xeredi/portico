package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioDetailVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoServicioDetailVO extends AbstractEntidadDetailVO {

    /** The tpsr. */
    private TipoServicioVO enti;

    /**
     * Creates the item.
     *
     * @return the servicio VO
     */
    public ServicioVO createItem() {
        final ServicioVO item = new ServicioVO();

        fillItem(item);

        item.setEstado(enti.getEstadoDef());

        return item;
    }
}
