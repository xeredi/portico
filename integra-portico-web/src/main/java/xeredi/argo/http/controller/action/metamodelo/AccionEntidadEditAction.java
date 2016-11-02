package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBaseBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadEditAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEntidadEditAction extends CrudEditAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6298953902914627135L;

    /** The accn list. */
    private List<AccionEntidadBaseVO> aebsList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            Preconditions.checkNotNull(model.getEntiId());
        } else {
            Preconditions.checkNotNull(model.getId());

            final AccionEntidadBO acenBO = new AccionEntidadBO();
            final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

            acenCriterio.setId(model.getId());

            model = acenBO.selectObject(acenCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final AccionEntidadBaseBO aebsBO = new AccionEntidadBaseBO();
        final AccionEntidadBaseCriterioVO aebsCriterio = new AccionEntidadBaseCriterioVO();

        aebsCriterio.setPrefix(ClassPrefix.item);

        aebsList = aebsBO.selectList(aebsCriterio);
    }
}
