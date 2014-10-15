package xeredi.integra.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaI18nVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAction.
 */
public final class CodigoReferenciaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4021150215007821288L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cdrf form. */
    private CodigoReferenciaVO cdrf;

    /** The cdri map. */
    private Map<String, CodigoReferenciaI18nVO> cdriMap;

    /**
     * Instantiates a new codigo referencia action.
     */
    public CodigoReferenciaAction() {
        super();

        cdrf = new CodigoReferenciaVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("cdrf-create")
    public String create() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());

        accion = ACCION_EDICION.create;
        cdriMap = new HashMap<>();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("cdrf-edit")
    public String edit() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getId());

        accion = ACCION_EDICION.edit;

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrf = cdrfBO.select(cdrf.getId());

        if (cdrf == null) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
        }

        cdriMap = cdrfBO.selectI18nMap(cdrf.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("cdrf-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());
        Preconditions.checkNotNull(cdriMap);

        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            if (GenericValidator.isBlankOrNull(cdrf.getValor())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("cdrf_valor") }));
            }
        } else {
            Preconditions.checkNotNull(cdrf.getId());
            Preconditions.checkNotNull(cdrf.getValor());
        }

        if (cdrf.getOrden() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("cdrf_orden") }));
        }

        for (final String language : getAvailableLanguages()) {
            if (!cdriMap.containsKey(language) || GenericValidator.isBlankOrNull(cdriMap.get(language).getTexto())) {
                addActionError(getText(ErrorCode.E00002.name(), new String[] { language }));
            }
        }

        if (!hasErrors()) {
            final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

            if (accion == ACCION_EDICION.create) {
                try {
                    cdrfBO.insert(cdrf, cdriMap);
                } catch (final DuplicateInstanceException ex) {
                    addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("cdrf") }));
                }
            } else {
                try {
                    cdrfBO.update(cdrf, cdriMap);
                } catch (final InstanceNotFoundException ex) {
                    addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
                }
            }
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     */
    @Action("cdrf-remove")
    public String remove() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        try {
            cdrfBO.delete(cdrf);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("cdrf-detail")
    public String detail() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getId());

        accion = ACCION_EDICION.edit;

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrf = cdrfBO.select(cdrf.getId());

        if (cdrf == null) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
        }

        cdriMap = cdrfBO.selectI18nMap(cdrf.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the cdrf.
     *
     * @return the cdrf
     */
    public CodigoReferenciaVO getCdrf() {
        return cdrf;
    }

    /**
     * Sets the cdrf.
     *
     * @param value
     *            the new cdrf
     */
    public void setCdrf(final CodigoReferenciaVO value) {
        cdrf = value;
    }

    /**
     * Gets the cdri map.
     *
     * @return the cdri map
     */
    public Map<String, CodigoReferenciaI18nVO> getCdriMap() {
        return cdriMap;
    }

    /**
     * Sets the cdri map.
     *
     * @param value
     *            the value
     */
    public void setCdriMap(final Map<String, CodigoReferenciaI18nVO> value) {
        cdriMap = value;
    }

}
