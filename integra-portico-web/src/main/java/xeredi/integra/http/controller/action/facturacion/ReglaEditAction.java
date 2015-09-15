package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ReglaVersionVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaEditAction.
 */
public final class ReglaEditAction extends CrudEditAction<ReglaVO> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7473288340314527092L;

    /** The enti facturable list. */
    private List<LabelValueVO> entiFacturableList;

    /** The tipos. */
    private ReglaTipo[] tipos;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getCrgo());
        Preconditions.checkNotNull(model.getCrgo().getId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final ReglaBO rglaBO = new ReglaBO();
            final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

            rglaCriterio.setId(model.getId());
            rglaCriterio.setFechaVigencia(model.getFref());

            model = rglaBO.selectObject(rglaCriterio);
        } else {
            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setId(model.getCrgo().getId());
            crgoCriterio.setFechaVigencia(model.getFref());
            crgoCriterio.setIdioma(idioma);

            final CargoVO crgo = crgoBO.selectObject(crgoCriterio);
            final ReglaVersionVO rglv = new ReglaVersionVO();

            rglv.setFini(Calendar.getInstance().getTime());

            model = new ReglaVO();
            model.setVersion(rglv);
            model.setCrgo(crgo);
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
     * Gets the enti facturable list.
     *
     * @return the enti facturable list
     */
    public List<LabelValueVO> getEntiFacturableList() {
        return entiFacturableList;
    }

    /**
     * Gets the tipos.
     *
     * @return the tipos
     */
    public ReglaTipo[] getTipos() {
        return tipos;
    }
}
