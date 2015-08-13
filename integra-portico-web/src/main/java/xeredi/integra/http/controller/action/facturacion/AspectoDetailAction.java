package xeredi.integra.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoDetailAction.
 */
public final class AspectoDetailAction extends CrudDetailAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1363256002707100032L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The ascr list. */
    private List<AspectoCargoVO> ascrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getId());
        aspcCriterio.setIdioma(idioma);
        aspcCriterio.setFechaVigencia(fechaVigencia);

        model = aspcBO.selectObject(aspcCriterio);
        i18nMap = I18nBO.selectMap(I18nPrefix.aspv, model.getVersion().getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

        ascrCriterio.setAspcId(model.getId());
        ascrCriterio.setFechaVigencia(fechaVigencia);
        ascrCriterio.setIdioma(idioma);

        ascrList = ascrBO.selectList(ascrCriterio);
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Gets the ascr list.
     *
     * @return the ascr list
     */
    public List<AspectoCargoVO> getAscrList() {
        return ascrList;
    }
}
