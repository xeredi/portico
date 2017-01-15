package xeredi.argo.http.controller.action.facturacion;

import java.util.Date;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionEditAction.
 */
public final class ValoracionEditAction extends CrudEditAction<ValoracionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5032238434151606002L;

	/** The tpsr list. */
	@Getter
	private List<LabelValueVO> tpsrList;

	/** The pagador enti id. */
	@Getter
	private Long pagadorEntiId;

	/** The tpdt cod exencion. */
	@Getter
	private TipoDatoVO tpdtCodExencion;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private TipoDatoProxyService tpdtProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		switch (accion) {
		case create:
			model = new ValoracionVO();

			model.setFalta(new Date());
			model.setFliq(new Date());

			break;
		case edit:
			Preconditions.checkNotNull(model.getId());

			model = vlrcService.select(model.getId(), getIdioma());

			break;
		default:
			throw new Error("Accion no valida: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		tpsrList = tpsrService.selectLabelValues(new TipoServicioCriterioVO());
		pagadorEntiId = Entidad.ORGANIZACION.getId();
		tpdtCodExencion = tpdtProxy.select(TipoDato.COD_EXEN.getId());
	}
}
