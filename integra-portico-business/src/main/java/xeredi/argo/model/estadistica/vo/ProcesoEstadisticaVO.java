package xeredi.argo.model.estadistica.vo;

import java.io.File;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new proceso estadistica vo.
 */
@Data
public final class ProcesoEstadisticaVO {
    /** The pepr. */
    private PeriodoProcesoVO pepr = new PeriodoProcesoVO();

    /** The sobreescribir. */
    private Boolean sobreescribir;

    /** The file. */
    private File file;
}
