package xeredi.argo.model.servicio.bo.suministrored;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.dao.suministrored.SuministroRedDAO;
import xeredi.argo.model.servicio.vo.ServicioMaestroCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioRedBO.
 */
public final class SuministroRedBO extends ServicioBO {

	/**
	 * Instantiates a new servicio red BO.
	 *
	 * @param ausroId
	 *            the ausro id
	 */
	public SuministroRedBO(Long ausroId) {
		super(Entidad.SUMINISTRO_RED.getId(), ausroId);
	}

	/**
	 * Select list.
	 *
	 * @param ffin
	 *            the ffin
	 * @return the list
	 */
	public List<ServicioMaestroVO> selectGenerateList(final @NonNull ServicioMaestroCriterioVO srmsCriterio) {
		Preconditions.checkNotNull(srmsCriterio.getFfin());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuministroRedDAO sredDAO = session.getMapper(SuministroRedDAO.class);

			return sredDAO.selectGenerateList(srmsCriterio);
		}
	}

	/**
	 * Creates the.
	 *
	 * @param srms
	 *            the srms
	 * @return the servicio VO
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public ServicioVO create(final @NonNull ServicioMaestroVO srms) throws DuplicateInstanceException {
		Preconditions.checkNotNull(srms.getPrmt());
		Preconditions.checkNotNull(srms.getPrmt().getId());
		Preconditions.checkNotNull(srms.getPrmt().getPrto());
		Preconditions.checkNotNull(srms.getPrmt().getPrto().getId());
		Preconditions.checkNotNull(srms.getFini());
		Preconditions.checkNotNull(srms.getFfin());

		Preconditions.checkArgument(srms.getFini().before(srms.getFfin()));

		Preconditions.checkNotNull(srms.getItdtMap());
		Preconditions.checkNotNull(srms.getItdtMap().get(TipoDato.ORGA.getId()));
		Preconditions.checkNotNull(srms.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
		Preconditions.checkNotNull(srms.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
		Preconditions.checkNotNull(srms.getItdtMap().get(TipoDato.COD_EXEN.getId()));

		final ServicioVO srvc = new ServicioVO();
		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(srms.getFini());

		srvc.setEntiId(getEntiId());
		srvc.setPrto(srms.getPrmt().getPrto());
		srvc.setFini(srms.getFini());
		srvc.setFfin(srms.getFfin());
		srvc.setFref(srms.getFini());
		srvc.setEstado("F");
		srvc.setAnno(String.valueOf(calendar.get(Calendar.YEAR)));

		srvc.addItdt(TipoDato.ORGA.getId(), srms.getItdtPrmt(TipoDato.ORGA.name()));
		srvc.addItdt(TipoDato.DECIMAL_01.getId(), srms.getItdtDouble(TipoDato.DECIMAL_01.name()));
		srvc.addItdt(TipoDato.DECIMAL_02.getId(), srms.getItdtDouble(TipoDato.DECIMAL_02.name()));
		srvc.addItdt(TipoDato.COD_EXEN.getId(), srms.getItdtDouble(TipoDato.COD_EXEN.name()));

		insert(srvc, null, null, null);

		return srvc;
	}
}
