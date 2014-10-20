package xeredi.integra.model.util;

import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class GlobalNames.
 */
public class GlobalNames {

    // Acciones Web
    /**
     * The Enum ACCION_EDICION.
     */
    public static enum ACCION_EDICION {
        /** The alta. */
        create,
        /** The modificar. */
        edit,
        /** The duplicar. */
        duplicate

        ;
    }

    // Formatos de Fechas
    /** The Constant DATETIME_FORMAT_KEY. */
    public static final String DATETIME_FORMAT_KEY = "format.datetime";

    /** The Constant DATE_FORMAT_KEY. */
    public static final String DATE_FORMAT_KEY = "format.date";

    // i18n
    /** The Constant DEFAULT_LOCALE. */
    public final static Locale DEFAULT_LOCALE = new Locale("es", "ES");

    /** The Constant ROWS_PER_PAGE_DEFAULT. */
    public static final int ROWS_PER_PAGE_DEFAULT = 20;

    /** The Constant VALID_ROWS_PER_PAGE. */
    public static final int[] VALID_ROWS_PER_PAGE = new int[] { 10, 20, 50, 100, 200, 500 };

    /** The Constant MESSAGES. */
    public static final String MESSAGES = "messages";

    /** The Constant SQ_INTEGRA. */
    public static final String SQ_INTEGRA = "sq_integra";
}
