package xeredi.argo.model.proceso.vo;

import java.util.Date;

import xeredi.argo.model.seguridad.vo.UsuarioVO;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoVO.
 */
@Data
public final class ProcesoVO {

    /** The id. */
    private Long id;

    /** The usro. */
    private UsuarioVO usro;

    /** The modulo. */
    private ProcesoModulo modulo;

    /** The tipo. */
    private ProcesoTipo tipo;

    /** The estado. */
    private ProcesoEstado estado;

    /** The falta. */
    private Date falta;

    /** The finicio. */
    private Date finicio;

    /** The ffin. */
    private Date ffin;

    /** The errores cnt. */
    private Integer erroresCnt;

    /** The alertas cnt. */
    private Integer alertasCnt;

    /** The mensajes cnt. */
    private Integer mensajesCnt;

    /**
     * Gets the duracion.
     *
     * @return the duracion
     */
    public Long getDuracion() {
        if (finicio != null && ffin != null) {
            return ffin.getTime() - finicio.getTime();
        }

        return null;
    }
}
