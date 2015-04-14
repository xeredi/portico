package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
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
    public void insert(final @Nonnull EntidadGrupoDatoVO engdVO, final @Nonnull Map<String, I18nVO> i18nMap) {
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final IgBO igBO = new IgBO();

            engdVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            // FIXME Deberia controlar duplicados
            engdDAO.insert(engdVO);

            I18nBO.insertMap(session, I18nPrefix.engd, engdVO.getId(), i18nMap);

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
    public void update(final @Nonnull EntidadGrupoDatoVO engdVO, final @Nonnull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            if (engdDAO.update(engdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.engd, engdVO);
            }

            I18nBO.updateMap(session, I18nPrefix.engd, engdVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @Nonnull Long id) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setId(id);

            if (engdDAO.delete(engdCriterioVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.engd, id);
            }

            I18nBO.deleteMap(session, I18nPrefix.engd, id);

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
    public EntidadGrupoDatoVO select(final @Nonnull Long id, final String idioma) throws InstanceNotFoundException {
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
     * @param entiId
     *            the enti id
     * @param idioma
     *            the idioma
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
