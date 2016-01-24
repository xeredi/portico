package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaEditAction.
 */
public final class ReglaEditAction extends CrudEditAction<ReglaVO> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7473288340314527092L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The enti facturable list. */
    @Getter
    private List<LabelValueVO> entiFacturableList;

    /** The tipos. */
    @Getter
    private ReglaTipo[] tipos;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getCrgo());
            Preconditions.checkNotNull(model.getCrgo().getId());

            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setId(model.getCrgo().getId());
            crgoCriterio.setFechaVigencia(model.getFref());
            crgoCriterio.setIdioma(idioma);

            final CargoVO crgo = crgoBO.selectObject(crgoCriterio);

            model.setCrgo(crgo);
            model.getVersion().setFini(Calendar.getInstance().getTime());
        } else {
            Preconditions.checkNotNull(model.getId());

            final ReglaBO rglaBO = new ReglaBO();
            final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

            rglaCriterio.setId(model.getId());
            rglaCriterio.setFechaVigencia(model.getFref());

            model = rglaBO.selectObject(rglaCriterio);
            i18nMap = I18nBO.selectMap(I18nPrefix.rglv, model.getVersion().getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            tipos = ReglaTipo.values();

            final TipoServicioBO tpsrBO = new TipoServicioBO();
            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setId(model.getCrgo().getId());
            crgoCriterio.setFechaVigencia(model.getFref());
            crgoCriterio.setIdioma(getIdioma());

            final CargoVO crgo = crgoBO.selectObject(crgoCriterio);
            final TipoServicioCriterioVO tpsrCriterioVO = new TipoServicioCriterioVO();

            tpsrCriterioVO.setId(crgo.getTpsr().getId());
            tpsrCriterioVO.setFacturable(Boolean.TRUE);
            tpsrCriterioVO.setIdioma(getIdioma());

            entiFacturableList = tpsrBO.selectLabelValues(tpsrCriterioVO);

            final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
            final TipoSubservicioCriterioVO tpssCriterioVO = new TipoSubservicioCriterioVO();

            tpssCriterioVO.setTpsrId(crgo.getTpsr().getId());
            tpssCriterioVO.setFacturable(Boolean.TRUE);
            tpssCriterioVO.setIdioma(getIdioma());

            entiFacturableList.addAll(tpssBO.selectLabelValues(tpssCriterioVO));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.rgla;
    }
}
