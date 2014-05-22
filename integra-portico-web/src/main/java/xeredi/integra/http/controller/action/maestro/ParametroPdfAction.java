package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dynamicreports.report.exception.DRException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.maestro.Subparametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.bo.util.pdf.ParametroPdf;
import xeredi.integra.model.proxy.metamodelo.TipoParametroProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubparametroProxy;
import xeredi.integra.model.vo.maestro.ParametroCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroI18nVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.maestro.SubparametroCriterioVO;
import xeredi.integra.model.vo.maestro.SubparametroVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdfAction.
 */
public final class ParametroPdfAction extends ItemAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7734329938605849510L;

	/** The item report. */
	private ParametroVO item;

	/** The enti. */
	private TipoParametroVO enti;

	/** The enti hijas list. */
	private List<TipoSubparametroVO> entiHijasList;

	/** The item hijos map. */
	private Map<Long, List<SubparametroVO>> itemHijosMap;

	/** The fecha vigencia. */
	private final Date fechaVigencia = Calendar.getInstance().getTime();

	/** The stream. */
	private InputStream stream;

	/**
	 * Imprimir.
	 * 
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws DRException
	 *             the DR exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	@Action(value = "prmt-imprimir", results = { @Result(name = "success", type = "stream", params = {
			"contentType", "application/pdf", "inputName", "stream",
			"contentDisposition", "filename=${enti.codigo}.pdf" }) })
	public String imprimir() throws IOException, DRException,
	InstanceNotFoundException {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getId());

		final Parametro prmtBO = BOFactory.getInjector().getInstance(
				Parametro.class);
		final Map<Long, TipoSubparametroVO> entiHijasMap = new HashMap<>();

		item = prmtBO.select(item.getId(), getIdioma(), getFechaVigencia());
		enti = TipoParametroProxy.select(item.getEntiId());

		if (enti.getEntiHijasList() != null) {
			itemHijosMap = new HashMap<>();

			final Subparametro sprmBO = BOFactory.getInjector().getInstance(
					Subparametro.class);
			final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

			prmtCriterioVO.setId(item.getId());
			prmtCriterioVO.setFechaVigencia(fechaVigencia);
			prmtCriterioVO.setIdioma(getIdioma());

			for (final Long entiId : enti.getEntiHijasList()) {
				final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

				sprmCriterioVO.setPrmt(prmtCriterioVO);
				sprmCriterioVO.setEntiId(entiId);
				sprmCriterioVO.setFechaVigencia(fechaVigencia);
				sprmCriterioVO.setIdioma(getIdioma());

				entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
				itemHijosMap.put(entiId, sprmBO.selectList(sprmCriterioVO));
			}
		}

		final Map<String, ParametroI18nVO> p18nMap = new HashMap<>();

		if (enti.isI18n()) {
			p18nMap.putAll(prmtBO.selectI18nMap(item.getPrvr().getId()));
		}

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

			prmtPdf.imprimir(item, enti, entiHijasMap, itemHijosMap, p18nMap,
					baos);

			stream = new ByteArrayInputStream(baos.toByteArray());
		}

		return SUCCESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ParametroVO getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 * 
	 * @param value
	 *            the new item
	 */
	public final void setItem(final ParametroVO value) {
		item = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TipoParametroVO getEnti() {
		return enti;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Date getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * Gets the stream.
	 * 
	 * @return the stream
	 */
	public final InputStream getStream() {
		return stream;
	}

	/**
	 * Gets the enti hijas list.
	 * 
	 * @return the enti hijas list
	 */
	public final List<TipoSubparametroVO> getEntiHijasList() {
		return entiHijasList;
	}

	/**
	 * Gets the item hijos map.
	 * 
	 * @return the item hijos map
	 */
	public final Map<Long, List<SubparametroVO>> getItemHijosMap() {
		return itemHijosMap;
	}

}
