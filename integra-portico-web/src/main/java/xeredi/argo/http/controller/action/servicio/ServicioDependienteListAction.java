package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.controller.action.item.ProtectedItemAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.servicio.bo.ServicioDependienteBO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new servicio dependiente list action.
 */
@Data
public final class ServicioDependienteListAction extends BaseAction implements ProtectedItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7971595471442007469L;

    /** The accion. */
    private final AccionCodigo accion = AccionCodigo.depList;

    /** The model. */
    private ServicioVO model;

    /** The result list. */
    private List<ServicioVO> resultList;

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getEntiId() {
        Preconditions.checkNotNull(model);

        return model.getEntiId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getId());

        final ServicioDependienteBO srdpBO = new ServicioDependienteBO(usroId);

        resultList = srdpBO.selectList(model.getId(), idioma);
    }

}
