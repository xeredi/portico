package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class EntidadBO {

    /** The enti dao. */
    EntidadDAO entiDAO;

    /** The entd dao. */
    EntidadTipoDatoDAO entdDAO;

    /** The engd dao. */
    EntidadGrupoDatoDAO engdDAO;

    /** The enac dao. */
    EntidadAccionDAO enacDAO;

    /** The enen dao. */
    EntidadEntidadDAO enenDAO;

    /**
     * Select list.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    public final List<EntidadVO> selectList(final EntidadCriterioVO entiCriterioVO) {
        Preconditions.checkNotNull(entiCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            return entiDAO.selectList(entiCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select map.
     *
     * @param tpdtMap
     *            the tpdt map
     * @return the map
     */
    public final Map<Long, EntidadVO> selectMap(final Map<Long, TipoDatoVO> tpdtMap) {
        Preconditions.checkNotNull(tpdtMap);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entiDAO = session.getMapper(EntidadDAO.class);
        enenDAO = session.getMapper(EntidadEntidadDAO.class);
        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
        entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
        enacDAO = session.getMapper(EntidadAccionDAO.class);

        try {
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
        } finally {
            session.close();
        }
    }

    /**
     * Select label values.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues(final EntidadCriterioVO entiCriterioVO) {
        Preconditions.checkNotNull(entiCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entiDAO = session.getMapper(EntidadDAO.class);

        try {
            final List<LabelValueVO> list = new ArrayList<>();

            for (final EntidadVO enti : entiDAO.selectList(entiCriterioVO)) {
                list.add(new LabelValueVO(enti.getNombre(), enti.getId()));
            }

            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Fill dependencies.
     *
     * @param entiVO
     *            the enti vo
     * @param idioma
     *            the idioma
     */
    final void fillDependencies(final EntidadVO entiVO, final String idioma) {
        Preconditions.checkNotNull(entiVO);
        Preconditions.checkNotNull(entiVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entiDAO = session.getMapper(EntidadDAO.class);
        enenDAO = session.getMapper(EntidadEntidadDAO.class);
        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
        entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
        enacDAO = session.getMapper(EntidadAccionDAO.class);

        try {
            // Grupos de datos de la entidad
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setEntiId(entiVO.getId());

            final List<EntidadGrupoDatoVO> engdList = engdDAO.selectList(engdCriterioVO);

            if (!engdList.isEmpty()) {
                entiVO.setEngdList(new ArrayList<EntidadGrupoDatoVO>());

                for (final EntidadGrupoDatoVO engdVO : engdList) {
                    if (engdVO.getNumero() > 1) {
                        entiVO.getEngdList().add(engdVO);
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

            final List<EntidadAccionVO> enacList = enacDAO.selectList(enacCriterioVO);

            entiVO.setEnacList(enacList);
        } finally {
            session.close();
        }
    }

}
