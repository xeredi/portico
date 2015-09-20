package xeredi.integra.proceso.servicio.edifact.escala;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.edifact.grammar.BermanD14bLexer;
import xeredi.edifact.grammar.BermanD14bParser;
import xeredi.integra.model.item.vo.ItemDatoCriterioVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.servicio.edifact.escala.BermanMaestroReader;
import xeredi.integra.model.servicio.edifact.escala.BermanServicioReader;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoBerman.
 */
public final class ProcesoBerman {

    /**
     * Parses the.
     *
     * @param filename
     *            the filename
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void parse(final String filename) throws IOException {
        System.out.println(filename);

        try (final InputStream is = new FileInputStream(filename)) {
            final ANTLRInputStream input = new ANTLRInputStream(is);
            final BermanD14bLexer lexer = new BermanD14bLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final BermanD14bParser parser = new BermanD14bParser(tokens);
            final ParseTree tree = parser.berman();

            final BermanMaestroReader maestroReader = new BermanMaestroReader();

            maestroReader.visit(tree);

            System.out.println(maestroReader.getMaestroCodesMap());
            System.out.println(maestroReader.getNifSet());

            final Map<Entidad, Map<String, ParametroVO>> prmtMap = new HashMap<>();
            final Map<String, ParametroVO> nifMap = new HashMap<>();

            for (final Entidad entidad : maestroReader.getMaestroCodesMap().keySet()) {
                prmtMap.put(entidad, new HashMap<String, ParametroVO>());

                final ParametroBO prmtBO = ParametroBOFactory.newInstance(entidad.getId());
                final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

                prmtCriterio.setEntiId(entidad.getId());
                prmtCriterio.setParametros(maestroReader.getMaestroCodesMap().get(entidad));

                for (final ParametroVO prmt : prmtBO.selectList(prmtCriterio)) {
                    prmtMap.get(entidad).put(prmt.getParametro(), prmt);
                }
            }

            final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
            final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

            prmtCriterio.setEntiId(Entidad.ORGANIZACION.getId());
            prmtCriterio.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());

            final ItemDatoCriterioVO itdtCriterio = new ItemDatoCriterioVO();

            itdtCriterio.setTpdtId(TipoDato.CADENA_02.getId());
            itdtCriterio.setCadenas(maestroReader.getNifSet());

            prmtCriterio.getItdtMap().put(TipoDato.CADENA_02.getId(), itdtCriterio);

            for (final ParametroVO prmt : prmtBO.selectList(prmtCriterio)) {
                nifMap.put(prmt.getItdt(TipoDato.CADENA_02.getId()).getCadena(), prmt);
            }

            System.out.println("prmtMap: " + prmtMap);
            System.out.println("nifMap: " + nifMap);

            final BermanServicioReader servicioReader = new BermanServicioReader(prmtMap, nifMap);

            servicioReader.visit(tree);

            System.out.println("srvc: " + servicioReader.getSrvc());
            System.out.println("buque: " + servicioReader.getBuque());
            System.out.println("ssrvMap: " + servicioReader.getSsrvMap());
        }
    }
}
