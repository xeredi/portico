package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoEditAction.
 */
public final class TipoDatoEditAction extends CrudEditAction<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6202167642910897080L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The tpht list. */
    private TipoHtml[] tphtList;

    /** The tpel list. */
    private TipoElemento[] tpelList;

    /** The tppr list. */
    private List<TipoParametroVO> tpprList;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            model = new TipoDatoVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final TipoDatoBO tpdtBO = new TipoDatoBO();

            model = tpdtBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(I18nPrefix.tpdt, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        tpelList = TipoElemento.values();
        tphtList = TipoHtml.values();

        final TipoParametroBO tpprBO = new TipoParametroBO();
        final TipoParametroCriterioVO tpprCriterio = new TipoParametroCriterioVO();

        tpprCriterio.setIdioma(idioma);

        tpprList = tpprBO.selectList(tpprCriterio);

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

        tpsrCriterio.setIdioma(idioma);

        tpsrList = tpsrBO.selectList(tpsrCriterio);
    }

    /**
     * Gets the tpht list.
     *
     * @return the tpht list
     */
    public TipoHtml[] getTphtList() {
        return tphtList;
    }

    /**
     * Gets the tpel list.
     *
     * @return the tpel list
     */
    public TipoElemento[] getTpelList() {
        return tpelList;
    }

    /**
     * Gets the tppr list.
     *
     * @return the tppr list
     */
    public List<TipoParametroVO> getTpprList() {
        return tpprList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<TipoServicioVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}
