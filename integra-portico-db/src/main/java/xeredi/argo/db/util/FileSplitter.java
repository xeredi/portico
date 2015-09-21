package xeredi.argo.db.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FileSplitter.
 */
public final class FileSplitter {

    /**
     * Split.
     *
     * @param folder
     *            the folder
     * @param filename
     *            the filename
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void split(final File folder, final String filename) throws IOException {
        try (final BufferedReader reader = new BufferedReader(new FileReader(new File(folder, filename + ".sql")))) {
            String line = null;
            int i = 0;
            int sqlCount = 0;
            int iteration = 10000;

            final List<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                i++;

                lines.add(line);

                if (line.trim().endsWith(";")) {
                    sqlCount++;
                }

                if (sqlCount >= 20000) {
                    System.out.println(iteration);

                    saveIteration(folder, filename, iteration, lines);

                    lines.clear();
                    sqlCount = 0;
                    iteration++;
                }

            }

            if (!lines.isEmpty()) {
                saveIteration(folder, filename, iteration, lines);
            }

            System.out.println("Fin. sql: " + sqlCount + " lines: " + i + " iterations:" + iteration);
        }
    }

    /**
     * Save iteration.
     *
     * @param folder
     *            the folder
     * @param filename
     *            the filename
     * @param iteration
     *            the iteration
     * @param lines
     *            the lines
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void saveIteration(final File folder, final String filename, final int iteration, final List<String> lines)
            throws IOException {

        try (final PrintWriter writer = new PrintWriter(
                new FileOutputStream(new File(folder, filename + "_" + iteration + ".sql")))) {
            for (final String line : lines) {
                writer.println(line);
            }

            writer.flush();
        }
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final File folder = new File("/home/xeredi/proyectos/team/git/integra/db/migrations/scripts");
        final String filename = "20140704005964_export_load";

        final FileSplitter splitter = new FileSplitter();

        try {
            splitter.split(folder, filename);
        } catch (final IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
