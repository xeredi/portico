package xeredi.argo.model.seguridad.bo;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.AccionDAO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAccesoBO.
 */
public final class UsuarioAccesoBO {

    /**
     * Acceso.
     *
     * @param login
     *            the login
     * @param contrasenia
     *            the contrasenia
     * @return the resultado login vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws ContraseniaIncorrectaException
     *             the contrasenia incorrecta exception
     */
    public ResultadoLoginVO acceso(final String login, final String contrasenia) throws InstanceNotFoundException,
    ContraseniaIncorrectaException {
        Preconditions.checkNotNull(login);
        Preconditions.checkNotNull(contrasenia);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);
            final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

            usroCriterio.setLogin(login);

            final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

            if (usro == null) {
                throw new InstanceNotFoundException(MessageI18nKey.usro, login);
            }

            if (!contrasenia.equals(usro.getContrasenia())) {
                throw new ContraseniaIncorrectaException(login);
            }

            final AccionDAO accnDAO = session.getMapper(AccionDAO.class);
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setUsroId(usro.getId());

            final Set<String> paths = new HashSet<>();

            for (final AccionVO accn : accnDAO.selectList(accnCriterio)) {
                paths.add(accn.getCodigo());
            }

            return new ResultadoLoginVO(usro.getId(), usro.getNombre(), usro.getSprt(), usro.getPrto(), paths);
        }
    }
}
