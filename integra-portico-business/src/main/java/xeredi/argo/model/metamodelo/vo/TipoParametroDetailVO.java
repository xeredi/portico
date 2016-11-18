package xeredi.argo.model.metamodelo.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoParametroDetailVO extends AbstractEntidadDetailVO {

    /** The tppr. */
    private TipoParametroVO enti;

    /** The subenti list. */
    private List<TipoSubparametroVO> subentiList = new ArrayList<>();

    /**
     * Creates the item.
     *
     * @return the parametro vo
     */
    public ParametroVO createItem() {
        final ParametroVO item = new ParametroVO();

        fillItem(item);

        return item;
    }
}
