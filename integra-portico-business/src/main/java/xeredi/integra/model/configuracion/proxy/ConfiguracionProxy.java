package xeredi.integra.model.configuracion.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.configuracion.bo.Clave;
import xeredi.integra.model.configuracion.bo.ClaveIdioma;
import xeredi.integra.model.configuracion.bo.Entorno;
import xeredi.integra.model.configuracion.bo.Idioma;
import xeredi.integra.model.configuracion.dao.ValorDAO;
import xeredi.integra.model.configuracion.dao.ValorIdiomaDAO;
import xeredi.integra.model.configuracion.vo.ClaveIdiomaVO;
import xeredi.integra.model.configuracion.vo.ClaveVO;
import xeredi.integra.model.configuracion.vo.EntornoVO;
import xeredi.integra.model.configuracion.vo.IdiomaVO;
import xeredi.integra.model.configuracion.vo.TipoValor;
import xeredi.integra.model.configuracion.vo.ValorIdiomaVO;
import xeredi.integra.model.configuracion.vo.ValorVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguracionProxy.
 */
public final class ConfiguracionProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ConfiguracionProxy.class);

    /** The Constant cnidMap. */
    private static final Map<String, IdiomaVO> cnidMap = new HashMap<>();

    /** The Constant cnenMap. */
    private static final Map<String, EntornoVO> cnenMap = new HashMap<>();

    /** The Constant cnclMap. */
    private static final Map<String, ClaveVO> cnclMap = new HashMap<>();

    /** The Constant cnvlMap indexado por entorno y clave. */
    private static final Map<Long, Map<Long, String>> cnvlMap = new HashMap<>();

    /** The Constant cnciMap. */
    private static final Map<String, ClaveIdiomaVO> cnciMap = new HashMap<>();

    /** The Constant cnviMap indexado por idioma y clave. */
    private static final Map<Long, Map<Long, String>> cnviMap = new HashMap<>();

    static {
        load();
    }

    /**
     * Gets the long.
     * 
     * @param key
     *            the key
     * @return the long
     * @throws ConfiguracionException
     *             the configuracion exception
     */
    public static Long getLong(final String key) throws ConfiguracionException {
        Preconditions.checkNotNull(key);

        final String valor = getString(key, TipoValor.NE);

        try {
            return valor == null ? null : Long.valueOf(valor);
        } catch (final NumberFormatException ex) {
            throw new ConfiguracionException(key, ex.getMessage(), ex);
        }
    }

    /**
     * Gets the double.
     * 
     * @param key
     *            the key
     * @return the double
     * @throws ConfiguracionException
     *             the configuracion exception
     */
    public static Double getDouble(final String key) throws ConfiguracionException {
        Preconditions.checkNotNull(key);

        final String valor = getString(key, TipoValor.ND);

        try {
            return valor == null ? null : Double.valueOf(valor);
        } catch (final NumberFormatException ex) {
            throw new ConfiguracionException(key, ex.getMessage(), ex);
        }
    }

    /**
     * Gets the boolean.
     * 
     * @param key
     *            the key
     * @return the boolean
     * @throws ConfiguracionException
     *             the configuracion exception
     */
    public static Boolean getBoolean(final String key) throws ConfiguracionException {
        Preconditions.checkNotNull(key);

        final String valor = getString(key, TipoValor.BO);

        return valor == null ? null : Boolean.valueOf(valor);
    }

    /**
     * Gets the string.
     * 
     * @param key
     *            the key
     * @return the string
     * @throws ConfiguracionException
     *             the configuracion exception
     */
    public static String getString(final String key) throws ConfiguracionException {
        Preconditions.checkNotNull(key);

        return getString(key, TipoValor.TX);
    }

    /**
     * Gets the string.
     * 
     * @param key
     *            the key
     * @param tipoValor
     *            the tipo valor
     * @return the string
     * @throws ConfiguracionException
     *             the configuracion exception
     */
    private static String getString(final String key, final TipoValor tipoValor) throws ConfiguracionException {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(tipoValor);

        final ClaveVO cnclVO = cnclMap.get(key);

        if (cnclVO == null) {
            throw new ConfiguracionException(key, "Parametro de configuracion no encontrado");
        }

        if (cnclVO.getTipoValor() != tipoValor) {
            throw new ConfiguracionException(key, "Tipo no valido, se esperaba '" + cnclVO.getTipoValor()
                    + "' y se ha recibido '" + tipoValor + "'");
        }

        return cnclVO.getValorDefecto();
    }

    /**
     * Gets the message.
     * 
     * @param key
     *            the key
     * @return the message
     * @throws ConfiguracionException
     *             the configuracion exception
     */
    public static String getMessage(final String key) throws ConfiguracionException {
        Preconditions.checkNotNull(key);

        final ClaveIdiomaVO cnciVO = cnciMap.get(key);

        return cnciVO == null ? "???" + key + "???" : cnciVO.getValorDefecto();
    }

    /**
     * Load.
     */
    private static void load() {
        LOG.info("Database configuration load start");

        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);
        final Entorno cnenBO = BOFactory.getInjector().getInstance(Entorno.class);
        final Clave cnclBO = BOFactory.getInjector().getInstance(Clave.class);
        final ClaveIdioma cnciBO = BOFactory.getInjector().getInstance(ClaveIdioma.class);

        cnidMap.putAll(cnidBO.selectAllMap());
        cnenMap.putAll(cnenBO.selectAllMap());
        cnclMap.putAll(cnclBO.selectAllMap());
        cnciMap.putAll(cnciBO.selectAllMap());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final ValorDAO cnvlDAO = session.getMapper(ValorDAO.class);
            final ValorIdiomaDAO cnviDAO = session.getMapper(ValorIdiomaDAO.class);

            final List<ValorVO> cnvlList = cnvlDAO.selectAllList();

            for (final ValorVO cnvlVO : cnvlList) {
                if (!cnvlMap.containsKey(cnvlVO.getCnenId())) {
                    cnvlMap.put(cnvlVO.getCnenId(), new HashMap<Long, String>());
                }

                cnvlMap.get(cnvlVO.getCnenId()).put(cnvlVO.getCnclId(), cnvlVO.getValor());
            }

            final List<ValorIdiomaVO> cnviList = cnviDAO.selectAllList();

            for (final ValorIdiomaVO cnviVO : cnviList) {
                if (!cnviMap.containsKey(cnviVO.getCnidId())) {
                    cnviMap.put(cnviVO.getCnidId(), new HashMap<Long, String>());
                }

                cnviMap.get(cnviVO.getCnidId()).put(cnviVO.getCnciId(), cnviVO.getValor());
            }

            if (LOG.isInfoEnabled()) {
                LOG.info("cnidMap: " + cnidMap);
                LOG.info("cnenMap: " + cnenMap);
                LOG.info("cnclMap: " + cnclMap);
                LOG.info("cnciMap: " + cnciMap);
                LOG.info("cnvlMap: " + cnvlMap);
                LOG.info("cnviMap: " + cnviMap);
            }
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);
        }

        LOG.info("Database configuration load end");
    }

}
