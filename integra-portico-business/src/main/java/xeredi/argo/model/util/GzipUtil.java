package xeredi.argo.model.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import lombok.NonNull;

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
	public static byte[] compress(final @NonNull File file) throws IOException {
		try (final FileInputStream fis = new FileInputStream(file)) {
			final byte[] buffer = new byte[(int) file.length()];

			fis.read(buffer);

			return buffer;
		}
	}

	/**
	 * Compress.
	 *
	 * @param buffer
	 *            the buffer
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] compress(final @NonNull byte[] buffer) throws IOException {
		return buffer;
	}

	/**
	 * Decompress.
	 *
	 * @param buffer
	 *            the buffer
	 * @return the input stream
	 */
	public static InputStream decompress(final @NonNull byte[] buffer) {
		return new ByteArrayInputStream(buffer);
	}
}
