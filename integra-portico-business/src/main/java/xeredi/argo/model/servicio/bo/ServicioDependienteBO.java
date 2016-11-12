package xeredi.argo.model.servicio.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioDependienteBO.
 */
public final class ServicioDependienteBO {

    /** The usro id. */
    private final transient Long usroId;

    /**
     * Instantiates a new servicio dependiente BO.
     *
     * @param usroId
     *            the usro id
     */
    public ServicioDependienteBO(Long usroId) {
        super();
        this.usroId = usroId;
    }

    /**
     * Select list.
     *
     * @param srvcDeoId
     *            the srvc deo id
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<ServicioVO> selectList(final @NonNull Long srvcDeoId, final String idioma) {
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setSrvcDepId(srvcDeoId);
        srvcCriterio.setIdioma(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            fillUserSpecificFilter(session, srvcCriterio);

            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);

            return srvcDAO.selectList(srvcCriterio);
        }
    }

    /**
     * Fill user specific filter.
     *
     * @param session
     *            the session
     * @param srvcCriterio
     *            the srvc criterio
     */
    private void fillUserSpecificFilter(final @NonNull SqlSession session,
            final @NonNull ServicioCriterioVO srvcCriterio) {
        final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
        final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

        usroCriterio.setId(usroId);

        final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

        if (usro == null) {
            throw new Error("Usuario no encontrado: " + usroId);
        }

        srvcCriterio.setUsroId(usro.getId());

        if (usro.getSprt() != null) {
            srvcCriterio.setUsroSprtId(usro.getSprt().getId());
        }

        if (usro.getPrto() != null) {
            srvcCriterio.setUsroPrtoId(usro.getPrto().getId());
        }

        if (usro.getOrga() != null) {
            srvcCriterio.setUsroOrgaId(usro.getPrto().getId());
        }
    }
}
