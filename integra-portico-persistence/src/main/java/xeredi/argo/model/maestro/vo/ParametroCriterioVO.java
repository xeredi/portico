package xeredi.argo.model.maestro.vo;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.item.vo.ItemTypeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ParametroCriterioVO extends ItemCriterioVO implements ItemTypeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The prvr id. */
    private Long versionId;

    /** The prvr ids. */
    private Set<Long> versionIds;

    /** The parametro. */
    private String parametro;

    /** The parametros. */
    private Set<String> parametros;

    /** The prto. */
    private PuertoCriterioVO prto;

    /** The sprm map. */
    private Map<Long, SubparametroVO> sprmMap;

    /**
     * Sets the parametro.
     *
     * @param value
     *            the new parametro
     */
    public void setParametro(final String value) {
        if (value != null) {
            parametro = value.trim().toUpperCase();
        }
    }
}
