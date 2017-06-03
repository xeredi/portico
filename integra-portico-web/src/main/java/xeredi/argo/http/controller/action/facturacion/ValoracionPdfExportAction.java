package xeredi.argo.http.controller.action.facturacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.report.ValoracionPdf;
import xeredi.argo.model.facturacion.service.ValoracionCargoService;
import xeredi.argo.model.facturacion.service.ValoracionImpuestoService;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyService;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionPdfExportAction.
 */
public final class ValoracionPdfExportAction extends CrudFileExportAction<ValoracionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5178479812829740439L;

	@Inject
	private ParametroService prmtService;

	@Inject
	private ValoracionService vlrcService;

	@Inject
	private ValoracionLineaService vlrlService;

	@Inject
	private ValoracionCargoService vlrgService;

	@Inject
	private ValoracionImpuestoService vlriService;

	@Inject
	private TipoDatoProxyService tpdtProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExport() throws ApplicationException, IOException {
		Preconditions.checkNotNull(model.getId());

		model = vlrcService.select(model.getId(), getIdioma());

		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setId(model.getId());
		vlrcCriterio.setIdioma(getIdioma());

		final List<ValoracionCargoVO> vlrgList = vlrgService.selectList(vlrcCriterio);
		final List<ValoracionImpuestoVO> vlriList = vlriService.selectList(vlrcCriterio);

		final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

		vlrlCriterio.setVlrcId(model.getId());
		vlrlCriterio.setIdioma(getIdioma());

		final List<ValoracionLineaVO> vlrlList = vlrlService.selectList(vlrlCriterio);

		final TipoDatoVO tpdtCodExencion = tpdtProxy.select(TipoDato.COD_EXEN.getId());
		final ParametroVO pagador = prmtService.select(model.getPagador().getId(), getIdioma(), model.getFref());

		if (LOG.isInfoEnabled()) {
			LOG.info("Impresion Valoracion");
		}

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			final ValoracionPdf vlrcPdf = new ValoracionPdf(getBundle());

			vlrcPdf.imprimir(model, pagador, tpdtCodExencion, vlrgList, vlriList, vlrlList, baos);

			stream = new ByteArrayInputStream(baos.toByteArray());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilename() {
		return MessageI18nKey.vlrc.name() + '_' + model.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CrudFileExportAction.ContentType getContentType() {
		return ContentType.pdf;
	}
}
