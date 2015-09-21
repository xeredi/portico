package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAdminBO.
 */
public final class EntidadBO {

    /**
     * Select.
     *
     * @param entiId
     *            the enti id
     * @param idioma
     *            the idioma
     * @return the entidad vo
     */
    public EntidadVO select(final @NonNull Long entiId, final String idioma) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

            entiCriterio.setId(entiId);
            entiCriterio.setIdioma(idioma);

            return entiDAO.selectObject(entiCriterio);
        }
    }

    /**
     * Select list.
     *
     * @param entiCriterio
     *            the enti criterio vo
     * @return the list
     */
    public List<EntidadVO> selectList(final EntidadCriterioVO entiCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            return entiDAO.selectList(entiCriterio);
        }
    }

    /**
     * Select label values.
     *
     * @param entiCriterio
     *            the enti criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final EntidadCriterioVO entiCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final EntidadVO enti : entiDAO.selectList(entiCriterio)) {
                list.add(new LabelValueVO(enti.getNombre(), enti.getId()));
            }

            return list;
        }
    }

}
