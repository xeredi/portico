package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoBO.
 */
public final class EntidadGrupoDatoBO {
    /**
     * Insert.
     *
     * @param engdVO
     *            the engd vo
     * @param i18nMap
     *            the i18n map
     */
    public void insert(final EntidadGrupoDatoVO engdVO, final Map<String, I18nVO> i18nMap) {
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final IgBO igBO = new IgBO();

            engdVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            // FIXME Deberia controlar duplicados
            engdDAO.insert(engdVO);

            I18nBO.insertMap(session, ClassPrefix.engd, engdVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param engdVO
     *            the engd vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final EntidadGrupoDatoVO engdVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            if (engdDAO.update(engdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.engd, engdVO);
            }

            I18nBO.updateMap(session, ClassPrefix.engd, engdVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param engd the engd
     * @throws InstanceNotFoundException             the instance not found exception
     */
    public void delete(final EntidadGrupoDatoVO engd) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            if (engdDAO.delete(engd) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.engd, engd);
            }

            I18nBO.deleteMap(session, ClassPrefix.engd, engd.getId());

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the entidad grupo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EntidadGrupoDatoVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setId(id);
            engdCriterioVO.setIdioma(idioma);

            final EntidadGrupoDatoVO engdVO = engdDAO.selectObject(engdCriterioVO);

            if (engdVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.engd, id);
            }

            return engdVO;
        }
    }

    /**
     * Select list.
     *
     * @param engdCriterio
     *            the engd criterio
     * @return the list
     */
    public List<EntidadGrupoDatoVO> selectList(final EntidadGrupoDatoCriterioVO engdCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            return engdDAO.selectList(engdCriterio);
        }
    }

    /**
     * Select label values.
     *
     * @param engdCriterio
     *            the engd criterio
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final EntidadGrupoDatoCriterioVO engdCriterio) {
        final List<LabelValueVO> list = new ArrayList<>();

        for (final EntidadGrupoDatoVO engd : selectList(engdCriterio)) {
            list.add(new LabelValueVO(engd.getEtiqueta(), engd.getNumero()));
        }

        return list;
    }
}
