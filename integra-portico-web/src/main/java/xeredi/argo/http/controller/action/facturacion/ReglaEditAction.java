package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaEditAction.
 */
@Data
public final class ReglaEditAction extends CrudEditAction<ReglaVO> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7473288340314527092L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti facturable list. */
    private List<LabelValueVO> entiFacturableList;

    /** The tipos. */
    private ReglaTipo[] tipos;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            Preconditions.checkNotNull(model.getCrgo());
            Preconditions.checkNotNull(model.getCrgo().getId());

            final CargoBO crgoBO = new CargoBO();
            final CargoVO crgo = crgoBO.select(model.getCrgo().getId(), model.getFref(), getIdioma());

            model.setCrgo(crgo);
            model.getVersion().setFini(Calendar.getInstance().getTime());
        } else {
            Preconditions.checkNotNull(model.getId());

            final ReglaBO rglaBO = new ReglaBO();

            model = rglaBO.select(model.getId(), model.getFref(), getIdioma());
            i18nMap = I18nUtilBO.selectMap(model);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            tipos = ReglaTipo.values();

            final TipoServicioBO tpsrBO = new TipoServicioBO();
            final CargoBO crgoBO = new CargoBO();

            final CargoVO crgo = crgoBO.select(model.getCrgo().getId(), model.getFref(), getIdioma());
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
}
