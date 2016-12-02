package xeredi.argo.model.seguridad.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.seguridad.dao.UsuarioPermisoDAO;
import xeredi.argo.model.seguridad.vo.UsuarioPermisoCriterioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * Validador de permisos de usuario.
 */
public final class UsuarioPermisoBO {

    /** The usro id. */
    private final transient Long usroId;

    /**
     * Instantiates a new usuario permiso BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public UsuarioPermisoBO(@NonNull final Long ausroId) {
        super();

        this.usroId = ausroId;
    }

    /**
     * Checks for fncd.
     *
     * @param fncdId
     *            the fncd id
     * @return true, if successful
     */
    public boolean hasFncd(@NonNull final Long fncdId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioPermisoDAO usprDAO = session.getMapper(UsuarioPermisoDAO.class);

            final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

            usprCriterio.setUsroId(usroId);
            usprCriterio.setFncdId(fncdId);

            return usprDAO.exists(usprCriterio);
        }
    }

    /**
     * Checks for acbs.
     *
     * @param prefix
     *            the prefix
     * @param codigo
     *            the codigo
     * @return true, if successful
     */
    public boolean hasAcbs(@NonNull final String prefix, @NonNull final String codigo) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioPermisoDAO usprDAO = session.getMapper(UsuarioPermisoDAO.class);

            final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

            usprCriterio.setUsroId(usroId);
            usprCriterio.setAcbsPrefix(prefix);
            usprCriterio.setAcbsCodigo(codigo);

            return usprDAO.exists(usprCriterio);
        }
    }

    /**
     * Checks for acen.
     *
     * @param prefix
     *            the prefix
     * @param codigo
     *            the codigo
     * @param entiId
     *            the enti id
     * @return true, if successful
     */
    public boolean hasAcen(@NonNull final String prefix, @NonNull final String codigo, @NonNull final Long entiId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioPermisoDAO usprDAO = session.getMapper(UsuarioPermisoDAO.class);

            final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

            usprCriterio.setUsroId(usroId);
            usprCriterio.setAcenPrefix(prefix);
            usprCriterio.setAcenCodigo(codigo);
            usprCriterio.setEntiId(entiId);

            return usprDAO.exists(usprCriterio);
        }
    }
}