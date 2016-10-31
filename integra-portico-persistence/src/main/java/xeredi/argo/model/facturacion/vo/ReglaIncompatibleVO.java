package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleVO.
 */
@Data
public final class ReglaIncompatibleVO implements Versionable<ReglaIncompatibleVersionVO> {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.rgin;

    /** The id. */
    private Long id;

    /** The rgla1 id. */
    private Long rgla1Id;

    /** The rgla2. */
    private ReglaVO rgla2;

    /** The rgiv. */
    private ReglaIncompatibleVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new regla incompatible vo.
     */
    public ReglaIncompatibleVO() {
        super();

        version = new ReglaIncompatibleVersionVO();
    }
}
