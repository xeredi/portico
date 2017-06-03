package xeredi.argo.model.seguridad.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
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

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAccesoService.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class UsuarioAccesoService {

	/** The usro DAO. */
	@Inject
	private UsuarioDAO usroDAO;

	/** The mdlo DAO. */
	@Inject
	private ModuloDAO mdloDAO;

	/** The acbs DAO. */
	@Inject
	private AccionBaseDAO acbsDAO;

	/** The acen DAO. */
	@Inject
	private AccionEntidadDAO acenDAO;

	/** The aces DAO. */
	@Inject
	private AccionEspecialDAO acesDAO;

	/** The trmt DAO. */
	@Inject
	private TramiteDAO trmtDAO;

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
	public ResultadoLoginVO acceso(final @NonNull String login, final @NonNull String contrasenia)
			throws InstanceNotFoundException, ContraseniaIncorrectaException {
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
		final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

		mdloCriterio.setUsroId(usro.getId());

		for (final ModuloVO mdlo : mdloDAO.selectList(mdloCriterio)) {
			mdloSet.add(mdlo.getCodigo());
		}

		// Recuperacion de los paths a las acciones base
		final Set<String> paths = new HashSet<>();
		final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

		acbsCriterio.setUsroId(usro.getId());

		for (final AccionBaseVO acbs : acbsDAO.selectList(acbsCriterio)) {
			paths.add(acbs.getPath());
		}

		// Recuperacion de las acciones de entidad
		final Map<Long, Set<AccionCodigo>> acenMap = new HashMap<>();
		final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

		acenCriterio.setUsroId(usro.getId());

		for (final AccionEntidadVO acen : acenDAO.selectList(acenCriterio)) {
			if (!acenMap.containsKey(acen.getEntiId())) {
				acenMap.put(acen.getEntiId(), new HashSet<>());
			}

			acenMap.get(acen.getEntiId()).add(acen.getAebs().getCodigo());
		}

		// Recuperacion del resto de funcionalidades (acciones especiales y
		// tramites)
		final Set<Long> fncdIds = new HashSet<>();

		final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

		acesCriterio.setUsroId(usro.getId());

		for (final AccionEspecialVO aces : acesDAO.selectList(acesCriterio)) {
			fncdIds.add(aces.getId());
		}

		final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

		trmtCriterio.setUsroId(usro.getId());

		for (final TramiteVO trmt : trmtDAO.selectList(trmtCriterio)) {
			fncdIds.add(trmt.getId());
		}

		return new ResultadoLoginVO(usro.getId(), usro.getNombre(), usro.getSprt(), usro.getPrto(), usro.getOrga(),
				mdloSet, paths, acenMap, fncdIds);
	}
}
