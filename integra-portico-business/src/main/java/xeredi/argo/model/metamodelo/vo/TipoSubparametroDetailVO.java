package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new tipo subparametro detail vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoSubparametroDetailVO extends AbstractEntidadDetailVO {

    /** The tpsp. */
    private TipoSubparametroVO enti;

    /**
     * Creates the item.
     *
     * @return the subparametro vo
     */
    public SubparametroVO createItem() {
        final SubparametroVO item = new SubparametroVO();

        fillItem(item);

        return item;
    }
}
