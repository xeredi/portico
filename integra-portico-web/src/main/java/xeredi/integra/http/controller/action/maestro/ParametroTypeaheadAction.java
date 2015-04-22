package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;

import xeredi.integra.http.controller.action.item.ItemTypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroTypeaheadCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroTypeaheadAction.
 */
public final class ParametroTypeaheadAction extends ItemTypeaheadAction<ParametroTypeaheadCriterioVO, ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7639038275412903995L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doSpecificTypeahead() throws ApplicationException {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());
        final TipoParametroDetailVO entiDetail = TipoParametroProxy.select(model.getEntiId());

        if (entiDetail.getEnti().isPuerto()) {
            Preconditions.checkNotNull(model.getPrtoId());
        }

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        model.setIdioma(entiDetail.getEnti().isI18n() ? idioma : null);
        model.setTpdtNombreId(entiDetail.getEnti().getTpdtNombre() == null ? null : entiDetail.getEnti()
                .getTpdtNombre().getId());

        resultList = prmtBO.selectLupaList(model, limit);
    }
}
