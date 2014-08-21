package xeredi.integra.model.bo.metamodelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.metamodelo.dao.EntidadAccionDAO;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.integra.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAdminBO.
 */
@Singleton
public class EntidadBO implements Entidad {

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /** The entd dao. */
    @Inject
    EntidadTipoDatoDAO entdDAO;

    /** The engd dao. */
    @Inject
    EntidadGrupoDatoDAO engdDAO;

    /** The enac dao. */
    @Inject
    EntidadAccionDAO enacDAO;

    /** The enen dao. */
    @Inject
    EntidadEntidadDAO enenDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoEntidad selectTipoEntidad(final Long id) {
        Preconditions.checkNotNull(id);

        final TipoEntidad tipoEntidad = entiDAO.selectTipoEntidad(id);

        if (tipoEntidad == null) {
            throw new Error("Entidad no encontrada: " + id);
        }

        return tipoEntidad;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<EntidadVO> selectList(final EntidadCriterioVO entiCriterioVO) {
        Preconditions.checkNotNull(entiCriterioVO);

        return entiDAO.selectList(entiCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<Long, EntidadVO> selectMap(final Map<Long, TipoDatoVO> tpdtMap) {
        Preconditions.checkNotNull(tpdtMap);

        final Map<Long, EntidadVO> entiMap = entiDAO.selectMap(new EntidadCriterioVO());
        final List<EntidadEntidadVO> enenList = enenDAO.selectList();

        for (final EntidadEntidadVO enenVO : enenList) {
            final EntidadVO entiPadreVO = entiMap.get(enenVO.getEntiPadreId());
            final EntidadVO entiHijaVO = entiMap.get(enenVO.getEntiHijaId());

            if (entiPadreVO.getEntiHijasList() == null) {
                entiPadreVO.setEntiHijasList(new ArrayList<Long>());
            }
            entiPadreVO.getEntiHijasList().add(entiHijaVO.getId());

            if (entiHijaVO.getEntiPadresList() == null) {
                entiHijaVO.setEntiPadresList(new ArrayList<Long>());
            }
            entiHijaVO.getEntiPadresList().add(entiPadreVO.getId());
        }

        final List<EntidadGrupoDatoVO> engdList = engdDAO.selectAll();

        for (final EntidadGrupoDatoVO engdVO : engdList) {
            final EntidadVO entiVO = entiMap.get(engdVO.getEntiId());

            if (entiVO.getEngdList() == null) {
                entiVO.setEngdList(new ArrayList<Integer>());
                entiVO.setEngdMap(new HashMap<Integer, EntidadGrupoDatoVO>());
            }
            entiVO.getEngdList().add(engdVO.getNumero());
            entiVO.getEngdMap().put(engdVO.getNumero(), engdVO);
        }

        final List<EntidadTipoDatoVO> entdList = entdDAO.selectAll();

        for (final EntidadTipoDatoVO entdVO : entdList) {
            final EntidadVO entiVO = entiMap.get(entdVO.getEntiId());

            entdVO.setTpdt(tpdtMap.get(entdVO.getTpdt().getId()));

            if (entiVO.getEntdList() == null) {
                entiVO.setEntdList(new ArrayList<Long>());
                entiVO.setEntdGridList(new ArrayList<Long>());
                entiVO.setEntdMap(new HashMap<Long, EntidadTipoDatoVO>());
            }

            entiVO.getEntdList().add(entdVO.getTpdt().getId());
            entiVO.getEntdMap().put(entdVO.getTpdt().getId(), entdVO);

            if (entdVO.isGridable()) {
                entiVO.getEntdGridList().add(entdVO.getTpdt().getId());
            }

            if (entiVO.getEngdList() != null) {
                // if (entdVO.getGrupo() > 1) {
                if (entiVO.getEngdEntdMap() == null) {
                    entiVO.setEngdEntdMap(new HashMap<Integer, List<Long>>());
                }

                if (!entiVO.getEngdEntdMap().containsKey(entdVO.getGrupo())) {
                    entiVO.getEngdEntdMap().put(entdVO.getGrupo(), new ArrayList<Long>());
                }

                entiVO.getEngdEntdMap().get(entdVO.getGrupo()).add(entdVO.getTpdt().getId());
                // }
            }
        }

        final List<EntidadAccionVO> enacList = enacDAO.selectAll();

        for (final EntidadAccionVO enacVO : enacList) {
            final EntidadVO entiVO = entiMap.get(enacVO.getEntiId());

            if (entiVO.getEnacList() == null) {
                entiVO.setEnacList(new ArrayList<EntidadAccionVO>());
            }
            entiVO.getEnacList().add(enacVO);
        }

        return entiMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return entiDAO.selectLabelValues(new EntidadCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void fillDependencies(final EntidadVO entiVO) {
        // Grupos de datos de la entidad
        final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

        engdCriterioVO.setEntiId(entiVO.getId());

        final List<EntidadGrupoDatoVO> engdList = engdDAO.selectList(engdCriterioVO);

        if (!engdList.isEmpty()) {
            entiVO.setEngdList(new ArrayList<Integer>());
            entiVO.setEngdMap(new HashMap<Integer, EntidadGrupoDatoVO>());

            for (final EntidadGrupoDatoVO engdVO : engdList) {
                if (engdVO.getNumero() > 1) {
                    entiVO.getEngdList().add(engdVO.getNumero());
                    entiVO.getEngdMap().put(engdVO.getNumero(), engdVO);
                }
            }
        }

        // Datos asociados a la entidad
        final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

        entdCriterioVO.setEntiId(entiVO.getId());

        final List<EntidadTipoDatoVO> entdList = entdDAO.selectList(entdCriterioVO);

        if (!entdList.isEmpty()) {
            entiVO.setEntdMap(new HashMap<Long, EntidadTipoDatoVO>());
            entiVO.setEntdList(new ArrayList<Long>());
            entiVO.setEntdGridList(new ArrayList<Long>());

            for (final EntidadTipoDatoVO entdVO : entdList) {
                entiVO.getEntdMap().put(entdVO.getTpdt().getId(), entdVO);
                entiVO.getEntdList().add(entdVO.getTpdt().getId());

                if (entdVO.isGridable()) {
                    entiVO.getEntdGridList().add(entdVO.getTpdt().getId());
                }
            }

            if (!engdList.isEmpty()) {
                final Map<Integer, List<Long>> engdEntdMap = new HashMap<>();

                for (final EntidadTipoDatoVO entdVO : entdList) {
                    if (entdVO.getGrupo() > 1) {
                        if (!engdEntdMap.containsKey(entdVO.getGrupo())) {
                            engdEntdMap.put(entdVO.getGrupo(), new ArrayList<Long>());
                        }

                        engdEntdMap.get(entdVO.getGrupo()).add(entdVO.getTpdt().getId());
                    }
                }

                entiVO.setEngdEntdMap(engdEntdMap);
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
    }

}
