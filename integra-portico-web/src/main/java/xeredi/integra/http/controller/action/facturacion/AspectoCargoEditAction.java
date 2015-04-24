package xeredi.integra.http.controller.action.facturacion;

import java.util.Date;
import java.util.List;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoEditAction.
 */
public final class AspectoCargoEditAction extends CrudEditAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1292421221150084862L;

    /** The crgo list. */
    private List<CargoVO> crgoList;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getAspcId());
        Preconditions.checkNotNull(fechaVigencia);

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final AspectoCargoBO ascrBO = new AspectoCargoBO();
            final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

            ascrCriterio.setId(model.getId());
            ascrCriterio.setFechaVigencia(fechaVigencia);

            model = ascrBO.selectObject(ascrCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model.getAspcId());

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getAspcId());
        aspcCriterio.setFechaVigencia(fechaVigencia);
        aspcCriterio.setIdioma(getIdioma());

        final AspectoVO aspc = aspcBO.selectObject(aspcCriterio);

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setTpsrId(aspc.getTpsr().getId());
        crgoCriterio.setFechaVigencia(fechaVigencia);
        crgoCriterio.setIdioma(getIdioma());

        crgoList = crgoBO.selectList(crgoCriterio);
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }
}
