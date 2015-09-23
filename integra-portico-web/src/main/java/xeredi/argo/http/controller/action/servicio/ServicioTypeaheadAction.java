package xeredi.argo.http.controller.action.servicio;

import java.util.StringTokenizer;

import xeredi.argo.http.controller.action.item.ItemTypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTypeaheadAction.
 */
public final class ServicioTypeaheadAction extends ItemTypeaheadAction<ServicioLupaCriterioVO, ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3651561999872993795L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificTypeahead() throws ApplicationException {
        final StringTokenizer tokenizer = new StringTokenizer(model.getTextoBusqueda(), "/");

        model.setSubpuerto(tokenizer.nextToken().toUpperCase());

        if (tokenizer.hasMoreTokens()) {
            model.setAnno(tokenizer.nextToken() + "%");
        }

        if (tokenizer.hasMoreTokens()) {
            model.setNumero(tokenizer.nextToken() + "%");
        }

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        resultList = srvcBO.selectLupaList(model, limit);
    }
}