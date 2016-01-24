package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoVersionVO.
 */
@Data
public final class AspectoVersionVO extends VersionVO {
    /** The descripcion. */
    private String descripcion;

    /** The prioridad. */
    private Integer prioridad;

    /** The cpath info1. */
    private String cpathInfo1;

    /** The cpath info1 sql. */
    private String cpathInfo1Sql;

    /** The cetiq info1. */
    private String cetiqInfo1;

    /** The cpath info2. */
    private String cpathInfo2;

    /** The cpath info2 sql. */
    private String cpathInfo2Sql;

    /** The cetiq info2. */
    private String cetiqInfo2;

    /** The cpath info3. */
    private String cpathInfo3;

    /** The cpath info3 sql. */
    private String cpathInfo3Sql;

    /** The cetiq info3. */
    private String cetiqInfo3;

    /** The cpath info4. */
    private String cpathInfo4;

    /** The cpath info4 sql. */
    private String cpathInfo4Sql;

    /** The cetiq info4. */
    private String cetiqInfo4;

    /** The cpath info5. */
    private String cpathInfo5;

    /** The cpath info5 sql. */
    private String cpathInfo5Sql;

    /** The cetiq info5. */
    private String cetiqInfo5;

    /** The cpath info6. */
    private String cpathInfo6;

    /** The cpath info6 sql. */
    private String cpathInfo6Sql;

    /** The cetiq info6. */
    private String cetiqInfo6;

    /** The lgrp info1. */
    private Boolean cgrpInfo1;

    /** The lgrp info2. */
    private Boolean cgrpInfo2;

    /** The lgrp info3. */
    private Boolean cgrpInfo3;

    /** The lgrp info4. */
    private Boolean cgrpInfo4;

    /** The lgrp info5. */
    private Boolean cgrpInfo5;

    /** The lgrp info6. */
    private Boolean cgrpInfo6;

    /** The lsum cuant1. */
    private Boolean lsumCuant1;

    /** The lsum cuant2. */
    private Boolean lsumCuant2;

    /** The lsum cuant3. */
    private Boolean lsumCuant3;

    /** The lsum cuant4. */
    private Boolean lsumCuant4;

    /** The lsum cuant5. */
    private Boolean lsumCuant5;

    /** The lsum cuant6. */
    private Boolean lsumCuant6;

    /** The lgrp info1. */
    private Boolean lgrpInfo1;

    /** The lgrp info2. */
    private Boolean lgrpInfo2;

    /** The lgrp info3. */
    private Boolean lgrpInfo3;

    /** The lgrp info4. */
    private Boolean lgrpInfo4;

    /** The lgrp info5. */
    private Boolean lgrpInfo5;

    /** The lgrp info6. */
    private Boolean lgrpInfo6;

    /**
     * Checks if is agrupa cabeceras.
     *
     * @return true, if checks if is agrupa cabeceras
     */
    public boolean isAgrupaCabeceras() {
        return Boolean.TRUE == cgrpInfo1 || Boolean.TRUE == cgrpInfo2 || Boolean.TRUE == cgrpInfo3
                || Boolean.TRUE == cgrpInfo4 || Boolean.TRUE == cgrpInfo5 || Boolean.TRUE == cgrpInfo6;
    }

    /**
     * Checks if is agrupa detalles.
     *
     * @return true, if checks if is agrupa detalles
     */
    public boolean isAgrupaDetalles() {
        return Boolean.TRUE == lgrpInfo1 || Boolean.TRUE == lgrpInfo2 || Boolean.TRUE == lgrpInfo3
                || Boolean.TRUE == lgrpInfo4 || Boolean.TRUE == lgrpInfo5 || Boolean.TRUE == lgrpInfo6
                || Boolean.TRUE == lsumCuant1 || Boolean.TRUE == lsumCuant2 || Boolean.TRUE == lsumCuant3
                || Boolean.TRUE == lsumCuant4 || Boolean.TRUE == lsumCuant5 || Boolean.TRUE == lsumCuant6;
    }
}
