package xeredi.argo.model.seguridad.bo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.AccionBaseDAO;
import xeredi.argo.model.metamodelo.dao.AccionEntidadDAO;
import xeredi.argo.model.metamodelo.dao.AccionEspecialDAO;
import xeredi.argo.model.metamodelo.dao.ModuloDAO;
import xeredi.argo.model.metamodelo.dao.TramiteDAO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.ResultadoLoginVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.util.SqlMapperLocator;

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
    public ResultadoLoginVO acceso(final String login, final String contrasenia)
            throws InstanceNotFoundException, ContraseniaIncorrectaException {
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

            // Recuperacion de los modulos
            final Set<String> mdloSet = new HashSet<>();
            final ModuloDAO mdloDAO = session.getMapper(ModuloDAO.class);
            final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

            mdloCriterio.setUsroId(usro.getId());

            for (final ModuloVO mdlo : mdloDAO.selectList(mdloCriterio)) {
                mdloSet.add(mdlo.getCodigo());
            }

            // Recuperacion de los paths a las acciones base
            final Set<String> paths = new HashSet<>();
            final AccionBaseDAO acbsDAO = session.getMapper(AccionBaseDAO.class);
            final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

            acbsCriterio.setUsroId(usro.getId());

            for (final AccionBaseVO acbs : acbsDAO.selectList(acbsCriterio)) {
                paths.add(acbs.getPath());
            }

            // Recuperacion de las acciones de entidad
            final Map<Long, Set<AccionCodigo>> acenMap = new HashMap<>();
            final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);
            final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

            acenCriterio.setUsroId(usro.getId());

            for (final AccionEntidadVO acen : acenDAO.selectList(acenCriterio)) {
                if (!acenMap.containsKey(acen.getEntiId())) {
                    acenMap.put(acen.getEntiId(), new HashSet<>());
                }

                acenMap.get(acen.getEntiId()).add(acen.getAebs().getCodigo());
            }

            // Recuperacion del resto de funcionalidades (acciones especiales y tramites)
            final Set<Long> fncdIds = new HashSet<>();

            final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
            final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

            acesCriterio.setUsroId(usro.getId());

            for (final AccionEspecialVO aces : acesDAO.selectList(acesCriterio)) {
                fncdIds.add(aces.getId());
            }

            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);
            final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

            trmtCriterio.setUsroId(usro.getId());

            for (final TramiteVO trmt : trmtDAO.selectList(trmtCriterio)) {
                fncdIds.add(trmt.getId());
            }

            return new ResultadoLoginVO(usro.getId(), usro.getNombre(), usro.getSprt(), usro.getPrto(), usro.getOrga(),
                    mdloSet, paths, acenMap, fncdIds);
        }
    }
}
