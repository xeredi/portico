package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadAccionDAO;
import xeredi.integra.model.metamodelo.dao.EntidadAccionGridDAO;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.integra.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;
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
            final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);

            final Map<Long, EntidadVO> entiMap = entiDAO.selectMap(new EntidadCriterioVO());

            for (final EntidadEntidadVO enen : enenDAO.selectList(new EntidadEntidadCriterioVO())) {
                final EntidadVO entiPadre = entiMap.get(enen.getEntiPadreId());
                final EntidadVO entiHija = entiMap.get(enen.getEntiHija().getId());

                if (entiPadre.getEntiHijasList() == null) {
                    entiPadre.setEntiHijasList(new ArrayList<Long>());
                }
                entiPadre.getEntiHijasList().add(entiHija.getId());

                if (entiHija.getEntiPadresList() == null) {
                    entiHija.setEntiPadresList(new ArrayList<Long>());
                }
                entiHija.getEntiPadresList().add(entiPadre.getId());
            }

            for (final EntidadGrupoDatoVO engd : engdDAO.selectAll()) {
                final EntidadVO enti = entiMap.get(engd.getEntiId());

                if (enti.getEngdList() == null) {
                    enti.setEngdList(new ArrayList<EntidadGrupoDatoVO>());
                }
                enti.getEngdList().add(engd);
                engd.setEntiId(null);
            }

            for (final EntidadTipoDatoVO entd : entdDAO.selectAll()) {
                final EntidadVO enti = entiMap.get(entd.getEntiId());

                entd.setTpdt(tpdtMap.get(entd.getTpdt().getId()));

                if (enti.getEntdList() == null) {
                    enti.setEntdList(new ArrayList<EntidadTipoDatoVO>());
                }

                enti.getEntdList().add(entd);
                entd.setEntiId(null);
            }

            for (final EntidadAccionVO enac : enacDAO.selectAll()) {
                final EntidadVO enti = entiMap.get(enac.getEntiId());

                if (enti.getEnacList() == null) {
                    enti.setEnacList(new ArrayList<EntidadAccionVO>());
                }
                enti.getEnacList().add(enac);
                enac.setEntiId(null);
            }

            for (final EntidadAccionGridVO enag : enagDAO.selectAll()) {
                final EntidadVO enti = entiMap.get(enag.getEntiId());

                if (enti.getEnagList() == null) {
                    enti.setEnagList(new ArrayList<EntidadAccionGridVO>());
                }
                enti.getEnagList().add(enag);
                enag.setEntiId(null);
            }

            return entiMap;
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

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param enti
     *            the enti vo
     * @param idioma
     *            the idioma
     */
    void fillDependencies(final @Nonnull SqlSession session, final @Nonnull EntidadVO enti, final String idioma) {
        Preconditions.checkNotNull(enti.getId());

        final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
        final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);
        final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
        final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);
        final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);

        // Grupos de datos de la entidad
        final EntidadGrupoDatoCriterioVO engdCriterio = new EntidadGrupoDatoCriterioVO();

        engdCriterio.setEntiId(enti.getId());
        engdCriterio.setIdioma(idioma);

        final List<EntidadGrupoDatoVO> engdList = engdDAO.selectList(engdCriterio);

        if (!engdList.isEmpty()) {
            enti.setEngdList(new ArrayList<EntidadGrupoDatoVO>());

            for (final EntidadGrupoDatoVO engd : engdList) {
                if (engd.getNumero() > 1) {
                    enti.getEngdList().add(engd);
                    engd.setEntiId(null);
                }
            }
        }

        // Datos asociados a la entidad
        final EntidadTipoDatoCriterioVO entdCriterio = new EntidadTipoDatoCriterioVO();

        entdCriterio.setEntiId(enti.getId());
        entdCriterio.setIdioma(idioma);

        final List<EntidadTipoDatoVO> entdList = entdDAO.selectList(entdCriterio);

        if (!entdList.isEmpty()) {
            enti.setEntdList(new ArrayList<EntidadTipoDatoVO>());

            for (final EntidadTipoDatoVO entd : entdList) {
                enti.getEntdList().add(entd);
                entd.setEntiId(null);
            }
        }

        // Entidades padres e hijas
        EntidadCriterioVO entiCriterio = null;

        entiCriterio = new EntidadCriterioVO();
        entiCriterio.setEntiHijaId(enti.getId());

        final List<EntidadVO> entiPadres = entiDAO.selectList(entiCriterio);

        if (!entiPadres.isEmpty()) {
            enti.setEntiPadresList(new ArrayList<Long>());

            for (final EntidadVO entiPadre : entiPadres) {
                enti.getEntiPadresList().add(entiPadre.getId());
            }
        }

        entiCriterio = new EntidadCriterioVO();
        entiCriterio.setEntiPadreId(enti.getId());

        final List<EntidadVO> entiHijas = entiDAO.selectList(entiCriterio);

        if (!entiHijas.isEmpty()) {
            enti.setEntiHijasList(new ArrayList<Long>());

            for (final EntidadVO entiHija : entiHijas) {
                enti.getEntiHijasList().add(entiHija.getId());
            }
        }

        // Acciones asociadas a la entidad
        final EntidadAccionCriterioVO enacCriterio = new EntidadAccionCriterioVO();

        enacCriterio.setEntiId(enti.getId());
        enacCriterio.setIdioma(idioma);

        final List<EntidadAccionVO> enacList = enacDAO.selectList(enacCriterio);

        enti.setEnacList(enacList);

        final EntidadAccionGridCriterioVO enagCriterio = new EntidadAccionGridCriterioVO();

        enagCriterio.setEntiId(enti.getId());
        enagCriterio.setIdioma(idioma);

        final List<EntidadAccionGridVO> enagList = enagDAO.selectList(enagCriterio);

        enti.setEnagList(enagList);
    }

}
