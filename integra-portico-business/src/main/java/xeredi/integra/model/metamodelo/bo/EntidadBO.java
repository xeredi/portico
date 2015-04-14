package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAdminBO.
 */
public final class EntidadBO {
    /**
     * Select list.
     *
     * @param entiCriterio
     *            the enti criterio vo
     * @return the list
     */
    public List<EntidadVO> selectList(final @Nonnull EntidadCriterioVO entiCriterio) {
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
    public List<LabelValueVO> selectLabelValues(final @Nonnull EntidadCriterioVO entiCriterio) {
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
