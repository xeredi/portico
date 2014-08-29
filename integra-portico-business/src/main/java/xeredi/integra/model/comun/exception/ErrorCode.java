package xeredi.integra.model.comun.exception;

// TODO: Auto-generated Javadoc
/**
 * The Enum ErrorCode.
 */
public enum ErrorCode {
    /** Error no controlado. Se pasa como argumento el mensaje de la excepcion. */
    E00000,

    /** Campo obligatorio. Se pasa como argumento la etiqueta del campo. */
    E00001,

    /** Titulo obligatorio un maestro con i18n. Se pasa como argumento el idioma. */
    E00002,

    /** Fecha de inicio de vigencia de un maestro obligatoria. Sin argumentos. */
    E00003,

    /** Codigo Obligatorio para un maestro. Sin argumentos. */
    E00004,

    /** Código Duplicado para un maestro. Se pasa como argumento la etiqueta de la entidad. */
    E00005,

    /** Error de rango de vigencia de un parametro, Fecha fin debe ser posterior a fecha inicio. sin argumentos. */
    E00006,

    /** Parametro no encontrado. Se pasa como argumento el identificador no encontrado. */
    E00007,

    ;
}
