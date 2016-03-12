package xeredi.argo.model.facturacion.vo;

import java.util.List;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * Agrupación de valoraciones que componen una factura.
 */
@Data
public final class ValoracionGrupoVO {

    /** The grupo id. */
    private Long vgrpId;

    /** The es suj pasivo. */
    private Boolean esSujPasivo;

    /** The pagador. */
    private ParametroVO pagador;

    /** The aspc. */
    private AspectoVO aspc;

    /** The vlrc list. */
    private List<ValoracionVO> vlrcList;
}
