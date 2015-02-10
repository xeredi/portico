package xeredi.integra.model.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class GzipUtil.
 */
public final class GzipUtil {

    /**
     * Instantiates a new gzip util.
     */
    private GzipUtil() {
        super();
    }

    /**
     * Compress.
     *
     * @param file
     *            the file
     * @return the byte[]
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static byte[] compress(final File file) throws IOException {
        if (file == null) {
            return null;
        }

        try (final FileInputStream fis = new FileInputStream(file)) {
            final byte[] buffer = new byte[(int) file.length()];

            fis.read(buffer);

            return buffer;
        }
    }

    /**
     * Decompress.
     *
     * @param buffer
     *            the buffer
     * @return the input stream
     */
    public static InputStream decompress(final byte[] buffer) {
        if (buffer == null) {
            return null;
        }

        return new ByteArrayInputStream(buffer);
    }
}
