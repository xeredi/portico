package xeredi.integra.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Entidad.
 */
public interface Entidad {

    /**
     * Select tipo entidad.
     * 
     * @param id
     *            the id
     * @return the tipo entidad
     */
    TipoEntidad selectTipoEntidad(final Long id);

    /**
     * Select list.
     * 
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    List<EntidadVO> selectList(final EntidadCriterioVO entiCriterioVO);

    /**
     * Select map.
     * 
     * @param tpdtMap
     *            the tpdt map
     * @return the map
     */
    Map<Long, EntidadVO> selectMap(final Map<Long, TipoDatoVO> tpdtMap);

    /**
     * Select label values.
     * 
     * @return the list
     */
    List<LabelValueVO> selectLabelValues();

    /**
     * Fill dependencies.
     * 
     * @param entiVO
     *            the enti vo
     */
    void fillDependencies(final EntidadVO entiVO);
}
