package xeredi.argo.model.seguridad.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.GrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServiceImpl.
 */
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	/** The usro DAO. */
	@Inject
	private UsuarioDAO usroDAO;

	/** The usgr DAO. */
	@Inject
	private UsuarioGrupoDAO usgrDAO;

	/** The grpo DAO. */
	@Inject
	private GrupoDAO grpoDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void insert(@NonNull final UsuarioVO usro) throws DuplicateInstanceException {
		if (usroDAO.exists(usro)) {
			throw new DuplicateInstanceException(MessageI18nKey.usro, usro);
		}

		IgUtilBO.assignNextVal(usro);

		usroDAO.insert(usro);

		if (usro.getGrpoIds() != null) {
			for (final Long grpoId : usro.getGrpoIds()) {
				final UsuarioGrupoVO usgr = new UsuarioGrupoVO(usro.getId(), grpoId);

				usgrDAO.insert(usgr);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(@NonNull final UsuarioVO usro) throws InstanceNotFoundException {
		Preconditions.checkNotNull(usro.getId());

		if (usroDAO.update(usro) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.usro, usro);
		}

		final UsuarioGrupoCriterioVO usgrCriterio = new UsuarioGrupoCriterioVO();

		usgrCriterio.setUsroId(usro.getId());

		usgrDAO.deleteList(usgrCriterio);

		if (usro.getGrpoIds() != null) {
			for (final Long grpoId : usro.getGrpoIds()) {
				final UsuarioGrupoVO usgr = new UsuarioGrupoVO(usro.getId(), grpoId);

				usgrDAO.insert(usgr);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(@NonNull final UsuarioVO usro) throws InstanceNotFoundException {
		Preconditions.checkNotNull(usro.getId());

		final UsuarioGrupoCriterioVO usgrCriterio = new UsuarioGrupoCriterioVO();

		usgrCriterio.setUsroId(usro.getId());

		usgrDAO.deleteList(usgrCriterio);

		if (usroDAO.delete(usro) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.usro, usro);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public PaginatedList<UsuarioVO> selectList(@NonNull final UsuarioCriterioVO usroCriterio, int offset, int limit) {
		final int count = usroDAO.count(usroCriterio);

		return new PaginatedList<>(
				count > offset ? usroDAO.selectList(usroCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public UsuarioVO selectObject(@NonNull final UsuarioCriterioVO usroCriterio) {
		final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

		if (usro != null) {
			final Set<Long> grpoIds = new HashSet<Long>();
			final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

			grpoCriterio.setUsroId(usro.getId());

			for (final GrupoVO grpo : grpoDAO.selectList(grpoCriterio)) {
				grpoIds.add(grpo.getId());
			}

			usro.setGrpoIds(grpoIds);
		}

		return usro;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public UsuarioVO select(@NonNull final Long id, String idioma) throws InstanceNotFoundException {
		final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

		usroCriterio.setId(id);
		usroCriterio.setIdioma(idioma);

		final UsuarioVO usro = selectObject(usroCriterio);

		if (usro == null) {
			throw new InstanceNotFoundException(MessageI18nKey.usro, id);
		}

		return usro;
	}
}
