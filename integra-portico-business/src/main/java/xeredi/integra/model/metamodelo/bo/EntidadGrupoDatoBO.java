package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoBO.
 */
public class EntidadGrupoDatoBO {

    /** The engd dao. */
    EntidadGrupoDatoDAO engdDAO;

    /**
     * Insert.
     *
     * @param engdVO
     *            the engd vo
     * @param i18nMap
     *            the i18n map
     */
    public final void insert(final EntidadGrupoDatoVO engdVO, final Map<String, I18nVO> i18nMap) {
        Preconditions.checkNotNull(engdVO);
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final IgBO igBO = new IgBO();

            engdVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
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
    public final void update(final EntidadGrupoDatoVO engdVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(engdVO);
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            if (engdDAO.update(engdVO) == 0) {
                throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdVO);
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
    public final void delete(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setId(id);
            engdDAO.delete(engdCriterioVO);
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
    public final EntidadGrupoDatoVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setId(id);
            engdCriterioVO.setIdioma(idioma);

            final EntidadGrupoDatoVO engdVO = engdDAO.selectObject(engdCriterioVO);

            if (engdVO == null) {
                throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), id);
            }

            return engdVO;
        }
    }

    /**
     * Select list.
     *
     * @param entiId
     *            the enti id
     * @param idioma
     *            the idioma
     * @return the list
     */
    public final List<EntidadGrupoDatoVO> selectList(final Long entiId, final String idioma) {
        Preconditions.checkNotNull(entiId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setEntiId(entiId);
            engdCriterioVO.setIdioma(idioma);

            return engdDAO.selectList(engdCriterioVO);
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
    public final List<LabelValueVO> selectLabelValues(final Long entiId, final String idioma) {
        final List<LabelValueVO> list = new ArrayList<>();

        for (final EntidadGrupoDatoVO engd : selectList(entiId, idioma)) {
            list.add(new LabelValueVO(engd.getEtiqueta(), engd.getNumero()));
        }

        return list;
    }
}
