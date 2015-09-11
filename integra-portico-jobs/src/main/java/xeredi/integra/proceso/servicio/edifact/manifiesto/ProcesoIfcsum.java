package xeredi.integra.proceso.servicio.edifact.manifiesto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.edifact.manifiesto.IfcsumMaestroReader;
import xeredi.integra.model.servicio.edifact.manifiesto.IfcsumServicioReader;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bLexer;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoIfcsum.
 */
public final class ProcesoIfcsum {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoIfcsum.class);

    /**
     * Parses the.
     *
     * @param filename
     *            the filename
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void parse(final String filename) throws IOException, InstanceNotFoundException, DuplicateInstanceException {
        LOG.info(filename);

        try (final InputStream is = new FileInputStream(filename)) {
            final ANTLRInputStream input = new ANTLRInputStream(is);
            final IfcsumD14bLexer lexer = new IfcsumD14bLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final IfcsumD14bParser parser = new IfcsumD14bParser(tokens);
            final ParseTree tree = parser.ifcsum();

            final IfcsumMaestroReader maestroReader = new IfcsumMaestroReader();

            LOG.info("Lectura de dependencias");

            maestroReader.visit(tree);

            LOG.info("Busqueda de dependencias");

            maestroReader.buscarDependencias();

            LOG.info("Lectura de servicio");

            final IfcsumServicioReader servicioReader = new IfcsumServicioReader(maestroReader.getPrto(),
                    maestroReader.getEscala(), maestroReader.getPrmtMap(), maestroReader.getNifMap());

            servicioReader.visit(tree);

            LOG.info("Alta de servicio");

            final ServicioBO srvcBO = ServicioBOFactory.newInstance(Entidad.MANIFIESTO.getId());

            srvcBO.insert(servicioReader.getSrvc(), servicioReader.getSsrvList(), servicioReader.getSsssList(), null);

            LOG.info("Proceso OK");
        }
    }
}