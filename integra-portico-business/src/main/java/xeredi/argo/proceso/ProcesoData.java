package xeredi.argo.proceso;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new proceso data.
 */
@Data
public final class ProcesoData {

    /** The prbt. */
    private ProcesoVO prbt;

    /** The prmn list. */
    private final List<ProcesoMensajeVO> prmnList = new ArrayList<>();

    /** The prit entrada list. */
    private final List<ProcesoItemVO> pritEntradaList = new ArrayList<>();

    /** The prit salida list. */
    private final List<Long> itemSalidaList = new ArrayList<>();

    /** The arin entrada list. */
    private final List<ArchivoInfoVO> arinEntradaList = new ArrayList<>();

    /** The prpm map. */
    private final Map<String, ProcesoParametroVO> prpmMap = new HashMap<>();

    /** The codigo maestro map. */
    private final Map<Entidad, Set<String>> codigoMaestroMap = new HashMap<>();

    /** The nif set. */
    private final Set<String> nifSet = new HashSet<>();

    /** The maestro map. */
    private final Map<Entidad, Map<String, ParametroVO>> maestroMap = new HashMap<>();

    /** The maestro prto map. */
    private final Map<Entidad, Map<Long, Map<String, ParametroVO>>> maestroPrtoMap = new HashMap<>();

    /** The organizaciones map. */
    private final Map<String, ParametroVO> organizacionesMap = new HashMap<>();

    /** The arin salida list. */
    private File fileSalida;
}
