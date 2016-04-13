package xeredi.argo.model.estadistica.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.estadistica.vo.EurostatVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EurostatFileExport.
 */
public final class EurostatFileExport {

    /** The Constant FIELD_SEPARATOR. */
    public static final String FIELD_SEPARATOR = ";";

    /** The Constant ROW_SEPARATOR. */
    public static final String ROW_SEPARATOR = "\n";

    /** The Constant EMPTY_FIELD. */
    public static final String EMPTY_FIELD = "";

    /** The Constant FIELD_COUNT. */
    public static final int FIELD_COUNT = 18;

    /** The Constant FIELD_PREFIX. */
    public static final String FIELD_PREFIX = "c";

    /**
     * Generate file.
     *
     * @param stream
     *            the stream
     * @param list
     *            the list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generateFile(final @NonNull OutputStream stream, final @NonNull List<EurostatVO> list)
            throws IOException {
        for (final EurostatVO erst : list) {
            final StringBuffer buffer = new StringBuffer();

            buffer.append(erst.getReport().name()).append(FIELD_SEPARATOR);
            buffer.append(erst.getYear()).append(FIELD_SEPARATOR);
            buffer.append(erst.getQuarter()).append(FIELD_SEPARATOR);
            buffer.append(erst.getPort()).append(FIELD_SEPARATOR);

            for (int i = 0; i < FIELD_COUNT; i++) {
                final String fieldName = FIELD_PREFIX + i;
                final Object fieldValue = erst.getMap().get(fieldName);

                buffer.append(fieldValue == null ? EMPTY_FIELD : fieldValue.toString());

                if (i < (FIELD_COUNT - 1)) {
                    buffer.append(FIELD_SEPARATOR);
                }
            }

            buffer.append(ROW_SEPARATOR);

            stream.write(buffer.toString().getBytes());
        }
    }
}
