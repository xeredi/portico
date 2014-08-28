package xeredi.integra.model.servicio.edi.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoSigmaToIfcsum.
 */
public final class ManifiestoSigmaToIfcsum {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ManifiestoSigmaToIfcsum.class);

    /**
     * Convert.
     *
     * @param filepathSource
     *            the filepath source
     * @param folderpathDest
     *            the folderpath dest
     * @throws IOException
     *             the IO exception
     */
    public void convert(final String filepathSource, final String folderpathDest) throws IOException {
        final File sourceFile = new File(filepathSource);
        final File destFolder = new File(folderpathDest);
        final File destFile = new File(destFolder, sourceFile.getName());

        final List<String> sourceLines = IOUtils.readLines(new FileInputStream(sourceFile));
        final List<String> destLines = new ArrayList<>();

        for (final String sourceLine : sourceLines) {
            final StringBuffer destLine = new StringBuffer();
            final String segment = sourceLine.substring(0, 3);

            String tipoOperacion;
            String funcion;
            String numeroEdi;

            switch (segment) {
            case "UNB":
                numeroEdi = sourceLine.substring(102, 116).trim();
                tipoOperacion = sourceLine.substring(139, 142).trim();
                funcion = sourceLine.substring(142, 145).trim();

                break;

            default:
                break;
            }
        }

        IOUtils.writeLines(destLines, null, new FileOutputStream(destFile));
    }

}
