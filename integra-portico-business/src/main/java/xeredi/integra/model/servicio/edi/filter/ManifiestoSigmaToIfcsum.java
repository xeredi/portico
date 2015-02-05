package xeredi.integra.model.servicio.edi.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InternalErrorException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoSigmaToIfcsum.
 */
public final class ManifiestoSigmaToIfcsum {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ManifiestoSigmaToIfcsum.class);

    /** The Constant FIELD_SEPARATOR. */
    private static final String FIELD_SEPARATOR = "+";

    /** The Constant SEGMENT_SEPARATOR. */
    private static final String SEGMENT_SEPARATOR = "'";

    /**
     * Convert.
     *
     * @param source
     *            the source
     * @param dest
     *            the dest
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void convert(final InputStream source, final OutputStream dest) throws InternalErrorException {
        Preconditions.checkNotNull(source);
        Preconditions.checkNotNull(dest);

        try {
            final List<String> sourceLines = IOUtils.readLines(source);
            final List<String> destLines = new ArrayList<>();

            for (final String sourceLine : sourceLines) {
                final StringBuffer destLine = new StringBuffer();
                final String segment = sourceLine.substring(0, 3);

                String tipoOperacion;
                String funcion;
                String numeroEdi;

                destLine.append(segment).append(FIELD_SEPARATOR);

                switch (segment) {
                case "SND":
                    break;
                case "REC":
                    break;
                case "MSG":
                    break;
                case "APL":
                    break;
                case "PRI":
                    break;
                case "TES":
                    break;
                case "UNB":
                    numeroEdi = sourceLine.substring(102, 116).trim();
                    tipoOperacion = sourceLine.substring(139, 142).trim();
                    funcion = sourceLine.substring(142, 145).trim();

                    break;
                case "IFC":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "NAD":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "CNI":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "GID":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "PCI":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "GOR":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "DOC":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "SGP":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "DGS":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "EQD":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "SEL":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;
                case "FTX":
                    destLines.add(destLine.append(SEGMENT_SEPARATOR).toString());

                    break;

                default:
                    throw new Error("Segmento desconocido: " + segment);
                }
            }

            IOUtils.writeLines(destLines, null, dest);
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

}
