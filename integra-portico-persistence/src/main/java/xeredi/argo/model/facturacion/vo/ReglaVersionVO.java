package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaVersionVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ReglaVersionVO extends VersionVO {
    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.rglv;

    /** The orden. */
    private Integer orden;

    /** The importe base. */
    private String valorBase;

    /** The valor base sql. */
    private String valorBaseSql;

    /** The condicion. */
    private String condicion;

    /** The condicion sql. */
    private String condicionSql;

    /** The formula. */
    private String formula;

    /** The formula sql. */
    private String formulaSql;

    /** The path impuesto. */
    private String pathImpuesto;

    /** The path impuesto sql. */
    private String pathImpuestoSql;

    /** The path pagador. */
    private String pathPagador;

    /** The path pagador sql. */
    private String pathPagadorSql;

    /** The path es suj pasivo. */
    private String pathEsSujPasivo;

    /** The path es suj pasivo sql. */
    private String pathEsSujPasivoSql;

    /** The path cod exen. */
    private String pathCodExen;

    /** The path cod exen sql. */
    private String pathCodExenSql;

    /** The etiq info1. */
    private String etiqInfo1;

    /** The path info1. */
    private String pathInfo1;

    /** The path info1 sql. */
    private String pathInfo1Sql;

    /** The etiq info2. */
    private String etiqInfo2;

    /** The path info2. */
    private String pathInfo2;

    /** The path info2 sql. */
    private String pathInfo2Sql;

    /** The etiq info3. */
    private String etiqInfo3;

    /** The path info3. */
    private String pathInfo3;

    /** The path info3 sql. */
    private String pathInfo3Sql;

    /** The etiq info4. */
    private String etiqInfo4;

    /** The path info4. */
    private String pathInfo4;

    /** The path info4 sql. */
    private String pathInfo4Sql;

    /** The etiq info5. */
    private String etiqInfo5;

    /** The path info5. */
    private String pathInfo5;

    /** The path info5 sql. */
    private String pathInfo5Sql;

    /** The etiq info6. */
    private String etiqInfo6;

    /** The path info6. */
    private String pathInfo6;

    /** The path info6 sql. */
    private String pathInfo6Sql;

    /** The etiq cuant1. */
    private String etiqCuant1;

    /** The path cuant1. */
    private String pathCuant1;

    /** The path cuant1 sql. */
    private String pathCuant1Sql;

    /** The etiq cuant2. */
    private String etiqCuant2;

    /** The path cuant2. */
    private String pathCuant2;

    /** The path cuant2 sql. */
    private String pathCuant2Sql;

    /** The etiq cuant3. */
    private String etiqCuant3;

    /** The path cuant3. */
    private String pathCuant3;

    /** The path cuant3 sql. */
    private String pathCuant3Sql;

    /** The etiq cuant4. */
    private String etiqCuant4;

    /** The path cuant4. */
    private String pathCuant4;

    /** The path cuant4 sql. */
    private String pathCuant4Sql;

    /** The etiq cuant5. */
    private String etiqCuant5;

    /** The path cuant5. */
    private String pathCuant5;

    /** The path cuant5 sql. */
    private String pathCuant5Sql;

    /** The etiq cuant6. */
    private String etiqCuant6;

    /** The path cuant6. */
    private String pathCuant6;

    /** The path cuant6 sql. */
    private String pathCuant6Sql;
}
