package xeredi.integra.http.controller.action.facturacion;

import java.util.Date;
import java.util.List;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionEditAction.
 */
public final class ValoracionEditAction extends CrudEditAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5032238434151606002L;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    /** The pagador enti id. */
    private Long pagadorEntiId;

    /** The tpdt cod exencion. */
    private TipoDatoVO tpdtCodExencion;

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

            final ValoracionBO vlrcBO = new ValoracionBO();
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(model.getId());
            vlrcCriterio.setIdioma(getIdioma());

            model = vlrcBO.selectObject(vlrcCriterio);

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
        tpsrList = TipoServicioProxy.selectLabelValues();
        pagadorEntiId = Entidad.ORGANIZACION.getId();
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the pagador enti id.
     *
     * @return the pagador enti id
     */
    public Long getPagadorEntiId() {
        return pagadorEntiId;
    }

    /**
     * Gets the tpdt cod exencion.
     *
     * @return the tpdt cod exencion
     */
    public TipoDatoVO getTpdtCodExencion() {
        return tpdtCodExencion;
    }
}
