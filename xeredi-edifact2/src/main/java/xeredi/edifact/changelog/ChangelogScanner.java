package xeredi.edifact.changelog;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipException;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;

import com.ibm.icu.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangelogScanner.
 */
public final class ChangelogScanner {

	/**
	 * Scan folder.
	 *
	 * @param folder
	 *            the folder
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void scanFolder(final File folder) throws IOException {
		if (!folder.isDirectory()) {
			throw new Error("folder '" + folder.getAbsolutePath() + "' should be a directory!!");
		}

		for (final File file : folder.listFiles()) {
			System.out.println("Scan: " + file.getName());

			try (final ZipFile zipFile = new ZipFile(file)) {
				scanZipFile(zipFile);
			}
		}
	}

	/**
	 * Scan zip file.
	 *
	 * @param zipFile
	 *            the zip file
	 */
	private void scanZipFile(final ZipFile zipFile) throws ZipException, IOException {
		final Enumeration<ZipArchiveEntry> enumeration = zipFile.getEntries();

		while (enumeration.hasMoreElements()) {
			final ZipArchiveEntry entry = enumeration.nextElement();

			if (!entry.isDirectory()) {
				// System.out.println("entry: " + entry.getName());

				scanZipEntry(entry, zipFile.getInputStream(entry));
			}
		}
	}

	private void scanZipEntry(final ZipArchiveEntry entry, final InputStream stream) throws IOException {
		int lineNo = 0;

		for (final String line : IOUtils.readLines(stream, Charset.defaultCharset())) {
			lineNo++;

			if (line.indexOf(" * ") >= 0) {
				System.out.println(" * : " + entry.getName() + ", line " + lineNo + ": " + line);
			}
			if (line.indexOf(" + ") >= 0) {
				System.out.println(" + : " + entry.getName() + ", line " + lineNo + ": " + line);
			}
			// if (line.indexOf(" - ") >= 0) {
			// System.out.println(" - : " + entry.getName() + ", line " + lineNo
			// + ": " + line);
			// }
			if (line.indexOf(" | ") >= 0) {
				System.out.println(" | : " + entry.getName() + ", line " + lineNo + ": " + line);
			}
			if (line.indexOf(" # ") >= 0) {
				System.out.println(" # : " + entry.getName() + ", line " + lineNo + ": " + line);
			}
			if (line.indexOf(" X  ") >= 0) {
				System.out.println(" X : " + entry.getName() + ", line " + lineNo + ": " + line);
			}
		}
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String args[]) {
		final long start = Calendar.getInstance().getTimeInMillis();

		try {
			final ChangelogScanner scanner = new ChangelogScanner();

			scanner.scanFolder(new File("/home/xeredi/MEGA/proyectos/edifact/guides"));
		} catch (final Exception ex) {
			ex.printStackTrace(System.err);
		}

		final long timeMs = Calendar.getInstance().getTimeInMillis() - start;

		System.out.println("Time ms: " + timeMs);
	}
}
