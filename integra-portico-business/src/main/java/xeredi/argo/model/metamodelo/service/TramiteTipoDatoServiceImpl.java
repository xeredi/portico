package xeredi.argo.model.metamodelo.service;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.TramiteTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TramiteTipoDatoServiceImpl implements TramiteTipoDatoService {

	/** The trtd DAO. */
	@Inject
	private TramiteTipoDatoDAO trtdDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TramiteTipoDatoVO> selectList(@NonNull final TramiteTipoDatoCriterioVO criterio) {
		return trtdDAO.selectList(criterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TramiteTipoDatoVO select(@NonNull final Long trmtId, @NonNull final Long tpdtId, final String idioma)
			throws InstanceNotFoundException {
		final TramiteTipoDatoCriterioVO criterio = new TramiteTipoDatoCriterioVO();

		criterio.setTrmtId(trmtId);
		criterio.setTpdtId(tpdtId);
		criterio.setIdioma(idioma);

		final TramiteTipoDatoVO trtd = trtdDAO.selectObject(criterio);

		if (trtd == null) {
			throw new InstanceNotFoundException(MessageI18nKey.trtd, criterio);
		}

		return trtd;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final TramiteTipoDatoVO trtd) throws DuplicateInstanceException {
		Preconditions.checkNotNull(trtd.getTrmtId());
		Preconditions.checkNotNull(trtd.getObligatorio());
		Preconditions.checkNotNull(trtd.getEntd());
		Preconditions.checkNotNull(trtd.getEntd().getTpdt());
		Preconditions.checkNotNull(trtd.getEntd().getTpdt().getId());

		if (trtdDAO.exists(trtd)) {
			throw new DuplicateInstanceException(MessageI18nKey.trtd, trtd);
		}

		trtdDAO.insert(trtd);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final TramiteTipoDatoVO trtd) throws InstanceNotFoundException {
		Preconditions.checkNotNull(trtd.getTrmtId());
		Preconditions.checkNotNull(trtd.getObligatorio());
		Preconditions.checkNotNull(trtd.getEntd());
		Preconditions.checkNotNull(trtd.getEntd().getTpdt());
		Preconditions.checkNotNull(trtd.getEntd().getTpdt().getId());

		if (trtdDAO.update(trtd) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.trtd, trtd);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final TramiteTipoDatoVO trtd) throws InstanceNotFoundException {
		Preconditions.checkNotNull(trtd.getTrmtId());
		Preconditions.checkNotNull(trtd.getEntd());
		Preconditions.checkNotNull(trtd.getEntd().getTpdt());
		Preconditions.checkNotNull(trtd.getEntd().getTpdt().getId());

		if (trtdDAO.delete(trtd) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.trtd, trtd);
		}
	}
}
