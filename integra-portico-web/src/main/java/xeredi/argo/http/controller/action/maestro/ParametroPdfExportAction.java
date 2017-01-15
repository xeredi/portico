package xeredi.argo.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemFileExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.maestro.report.ParametroPdf;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.service.SubparametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdfExportAction.
 */
public final class ParametroPdfExportAction extends ItemFileExportAction<ParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8831808221487676723L;

	@Inject
	private ParametroService prmtService;

	@Inject
	private SubparametroService sprmService;

	@Inject
	private I18nService i18nService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doSpecificFileExport() throws ApplicationException, IOException {
		Preconditions.checkNotNull(model.getFref());

		model = prmtService.select(model.getId(), getIdioma(), model.getFref());

		final TipoParametroDetailVO entiDetail = entiProxy.selectTppr(model.getEntiId());
		final Map<Long, TipoSubparametroDetailVO> entiHijasMap = new HashMap<>();
		final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

		if (entiDetail.getEntiHijasList() != null) {
			final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

			prmtCriterioVO.setId(model.getId());
			prmtCriterioVO.setFechaVigencia(model.getFref());
			prmtCriterioVO.setIdioma(getIdioma());

			for (final Long entiId : entiDetail.getEntiHijasList()) {
				final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

				sprmCriterioVO.setPrmt(prmtCriterioVO);
				sprmCriterioVO.setEntiId(entiId);
				sprmCriterioVO.setFechaVigencia(model.getFref());
				sprmCriterioVO.setIdioma(getIdioma());

				entiHijasMap.put(entiId, entiProxy.selectTpsp(entiId));
				itemHijosMap.put(entiId, sprmService.selectList(sprmCriterioVO));
			}
		}

		final Map<String, I18nVO> i18nMap = entiDetail.getEnti().isI18n() ? i18nService.selectMap(model)
				: new HashMap<>();

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

			prmtPdf.imprimir(model, entiDetail, entiHijasMap, itemHijosMap, i18nMap, baos);

			stream = new ByteArrayInputStream(baos.toByteArray());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getFilename() {
		return MessageI18nKey.prmt.name() + '_' + model.getEntiId() + '_' + model.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ContentType getContentType() {
		return ContentType.pdf;
	}
}
