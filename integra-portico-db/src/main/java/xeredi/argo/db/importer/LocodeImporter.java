package xeredi.argo.db.importer;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class LocodeImporter.
 */
public final class LocodeImporter {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(LocodeImporter.class);

    /** The Constant LOCODE_FILE. */
    private static final String LOCODE_FILE = "/home/xeredi/proyectos/files/portico/locodes_t.csv";

    private static final String DEFAULT_LANGUAGE = "es";

    /**
     * Import file.
     *
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void importFile() throws InternalErrorException {
        final ParametroBO paisBO = ParametroBOFactory.newInstance(Entidad.PAIS.getId());
        final ParametroBO argeBO = ParametroBOFactory.newInstance(Entidad.AREA_GEOGRAFICA.getId());
        final ParametroBO armuBO = ParametroBOFactory.newInstance(Entidad.AREA_MUNDIAL.getId());
        final ParametroBO zceeBO = ParametroBOFactory.newInstance(Entidad.ZONA_COSTERA_EEE.getId());
        final ParametroBO unloBO = ParametroBOFactory.newInstance(Entidad.UNLOCODE.getId());

        final Map<String, ParametroVO> paisMap = paisBO.selectMapByCodigo(new ParametroCriterioVO());
        final Map<String, ParametroVO> argeMap = argeBO.selectMapByCodigo(new ParametroCriterioVO());
        final Map<String, ParametroVO> armuMap = armuBO.selectMapByCodigo(new ParametroCriterioVO());
        final Map<String, ParametroVO> zceeMap = zceeBO.selectMapByCodigo(new ParametroCriterioVO());
        final Map<String, Long> unloMap = unloBO.selectMapCodigoId(new ParametroCriterioVO());

        final Calendar fini = Calendar.getInstance();

        fini.set(Calendar.YEAR, 2009);
        fini.set(Calendar.MONTH, 1);
        fini.set(Calendar.DAY_OF_MONTH, 1);
        fini.set(Calendar.HOUR_OF_DAY, 0);
        fini.set(Calendar.MINUTE, 0);
        fini.set(Calendar.SECOND, 0);
        fini.set(Calendar.MILLISECOND, 0);

        final TipoParametroDetailVO unloEnti = TipoParametroProxy.select(Entidad.UNLOCODE.getId());

        final ParametroVO armu = armuMap.get("**");

        if (armu == null) {
            throw new Error("Default Area mundial not found!!!");
        }

        final File file = new File(LOCODE_FILE);

        try {
            for (final String line : FileUtils.readLines(file)) {
                final StringTokenizer tokenizer = new StringTokenizer(line, ";");

                tokenizer.nextToken();

                final String countryCode = cleanToken(tokenizer.nextToken());
                final String cityCode = cleanToken(tokenizer.nextToken());
                final String cityName = cleanToken(tokenizer.nextToken());

                final String zceeCode = countryCode + "00";
                final String unlocode = countryCode + cityCode;

                if (!paisMap.containsKey(countryCode)) {
                    LOG.debug("New country: " + countryCode);
                } else {
                    if (!zceeMap.containsKey(zceeCode)) {
                        LOG.debug("New zcee: " + zceeCode);
                    } else {
                        if (!unloMap.containsKey(unlocode)) {
                            LOG.debug("New unlocode: " + unlocode);

                            final ParametroVO unlo = new ParametroVO();

                            unlo.setEntiId(unloEnti.getEnti().getId());
                            unlo.setParametro(unlocode);
                            unlo.getVersion().setFini(fini.getTime());

                            unlo.addItdt(TipoDato.PAIS.getId(), paisMap.get(countryCode));
                            unlo.addItdt(TipoDato.AREA_MUNDIAL.getId(), armu);
                            unlo.addItdt(TipoDato.ZONA_COST_EEE.getId(), zceeMap.get(zceeCode));
                            unlo.addItdt(TipoDato.DECIMAL_01.getId(), (Double) null);
                            unlo.addItdt(TipoDato.DECIMAL_02.getId(), (Double) null);
                            unlo.addItdt(TipoDato.BOOLEANO_01.getId(), 0L);
                            unlo.addItdt(TipoDato.BOOLEANO_02.getId(), 0L);

                            final Map<String, I18nVO> unloI18nMap = new HashMap<>();
                            final I18nVO i18nVO = new I18nVO();

                            i18nVO.setLanguage(DEFAULT_LANGUAGE);
                            i18nVO.setText(cityName);

                            unloI18nMap.put(DEFAULT_LANGUAGE, i18nVO);

                            try {
                                unloBO.insert(unlo, unloEnti, unloI18nMap);

                                unloMap.put(unlocode, unlo.getId());
                            } catch (final ModelException ex) {
                                LOG.error(ex, ex);

                                throw new Error(ex);
                            }
                        }
                    }

                }

                if (!unloMap.containsKey(unlocode)) {
                    // LOG.debug("New locode: " + unlocode);
                }
            }
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * Clean token.
     *
     * @param token
     *            the token
     * @return the string
     */
    private String cleanToken(final String token) {
        if (token == null) {
            return null;
        }

        if (token.length() < 2) {
            throw new Error("Invalid token: " + token);
        }

        if (!token.startsWith("\"")) {
            throw new Error("Invalid token: " + token);
        }

        if (!token.endsWith("\"")) {
            throw new Error("Invalid token: " + token);
        }

        return token.substring(1, token.length() - 1).trim().toUpperCase();
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        LOG.info("Start import");

        try {
            final LocodeImporter importer = new LocodeImporter();

            importer.importFile();
        } catch (final InternalErrorException ex) {
            LOG.fatal(ex, ex);
        }

        LOG.info("End import");
    }
}
