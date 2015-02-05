package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadAccionDAO;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.integra.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAdminBO.
 */
public final class EntidadBO {
    /**
     * Select list.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    public List<EntidadVO> selectList(final @Nonnull EntidadCriterioVO entiCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            return entiDAO.selectList(entiCriterioVO);
        }
    }

    /**
     * Select map.
     *
     * @param tpdtMap
     *            the tpdt map
     * @return the map
     */
    public Map<Long, EntidadVO> selectMap(final @Nonnull Map<Long, TipoDatoVO> tpdtMap) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);
            final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
            final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);

            final Map<Long, EntidadVO> entiMap = entiDAO.selectMap(new EntidadCriterioVO());

            for (final EntidadEntidadVO enenVO : enenDAO.selectList(new EntidadEntidadCriterioVO())) {
                final EntidadVO entiPadreVO = entiMap.get(enenVO.getEntiPadreId());
                final EntidadVO entiHijaVO = entiMap.get(enenVO.getEntiHija().getId());

                if (entiPadreVO.getEntiHijasList() == null) {
                    entiPadreVO.setEntiHijasList(new ArrayList<Long>());
                }
                entiPadreVO.getEntiHijasList().add(entiHijaVO.getId());

                if (entiHijaVO.getEntiPadresList() == null) {
                    entiHijaVO.setEntiPadresList(new ArrayList<Long>());
                }
                entiHijaVO.getEntiPadresList().add(entiPadreVO.getId());
            }

            for (final EntidadGrupoDatoVO engdVO : engdDAO.selectAll()) {
                final EntidadVO entiVO = entiMap.get(engdVO.getEntiId());

                if (entiVO.getEngdList() == null) {
                    entiVO.setEngdList(new ArrayList<EntidadGrupoDatoVO>());
                }
                entiVO.getEngdList().add(engdVO);
                engdVO.setEntiId(null);
            }

            for (final EntidadTipoDatoVO entdVO : entdDAO.selectAll()) {
                final EntidadVO entiVO = entiMap.get(entdVO.getEntiId());

                entdVO.setTpdt(tpdtMap.get(entdVO.getTpdt().getId()));

                if (entiVO.getEntdList() == null) {
                    entiVO.setEntdList(new ArrayList<EntidadTipoDatoVO>());
                }

                entiVO.getEntdList().add(entdVO);
                entdVO.setEntiId(null);
            }

            for (final EntidadAccionVO enacVO : enacDAO.selectAll()) {
                final EntidadVO entiVO = entiMap.get(enacVO.getEntiId());

                if (entiVO.getEnacList() == null) {
                    entiVO.setEnacList(new ArrayList<EntidadAccionVO>());
                }
                entiVO.getEnacList().add(enacVO);
                enacVO.setEntiId(null);
            }

            return entiMap;
        }
    }

    /**
     * Select label values.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final @Nonnull EntidadCriterioVO entiCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final EntidadVO enti : entiDAO.selectList(entiCriterioVO)) {
                list.add(new LabelValueVO(enti.getNombre(), enti.getId()));
            }

            return list;
        }
    }

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param entiVO
     *            the enti vo
     * @param idioma
     *            the idioma
     */
    void fillDependencies(final @Nonnull SqlSession session, final @Nonnull EntidadVO entiVO, final String idioma) {
        Preconditions.checkNotNull(entiVO.getId());

        final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
        final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
        final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
        final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);

        // Grupos de datos de la entidad
        final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

        engdCriterioVO.setEntiId(entiVO.getId());
        engdCriterioVO.setIdioma(idioma);

        final List<EntidadGrupoDatoVO> engdList = engdDAO.selectList(engdCriterioVO);

        if (!engdList.isEmpty()) {
            entiVO.setEngdList(new ArrayList<EntidadGrupoDatoVO>());

            for (final EntidadGrupoDatoVO engdVO : engdList) {
                if (engdVO.getNumero() > 1) {
                    entiVO.getEngdList().add(engdVO);
                    engdVO.setEntiId(null);
                }
            }
        }

        // Datos asociados a la entidad
        final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

        entdCriterioVO.setEntiId(entiVO.getId());
        entdCriterioVO.setIdioma(idioma);

        final List<EntidadTipoDatoVO> entdList = entdDAO.selectList(entdCriterioVO);

        if (!entdList.isEmpty()) {
            entiVO.setEntdList(new ArrayList<EntidadTipoDatoVO>());

            for (final EntidadTipoDatoVO entdVO : entdList) {
                entiVO.getEntdList().add(entdVO);
                entdVO.setEntiId(null);
            }
        }

        // Entidades padres e hijas
        EntidadCriterioVO entiCriterioVO = null;

        entiCriterioVO = new EntidadCriterioVO();
        entiCriterioVO.setEntiHijaId(entiVO.getId());

        final List<EntidadVO> entiPadres = entiDAO.selectList(entiCriterioVO);

        if (!entiPadres.isEmpty()) {
            entiVO.setEntiPadresList(new ArrayList<Long>());

            for (final EntidadVO entiPadreVO : entiPadres) {
                entiVO.getEntiPadresList().add(entiPadreVO.getId());
            }
        }

        entiCriterioVO = new EntidadCriterioVO();
        entiCriterioVO.setEntiPadreId(entiVO.getId());

        final List<EntidadVO> entiHijas = entiDAO.selectList(entiCriterioVO);

        if (!entiHijas.isEmpty()) {
            entiVO.setEntiHijasList(new ArrayList<Long>());

            for (final EntidadVO entiHijaVO : entiHijas) {
                entiVO.getEntiHijasList().add(entiHijaVO.getId());
            }
        }

        // Acciones asociadas a la entidad
        final EntidadAccionCriterioVO enacCriterioVO = new EntidadAccionCriterioVO();

        enacCriterioVO.setEntiId(entiVO.getId());
        enacCriterioVO.setIdioma(idioma);

        final List<EntidadAccionVO> enacList = enacDAO.selectList(enacCriterioVO);

        entiVO.setEnacList(enacList);
    }

}
