package xeredi.integra.model.bo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.mybatis.guice.XMLMyBatisModule;

import xeredi.integra.model.bo.facturacion.Factura;
import xeredi.integra.model.bo.facturacion.FacturaBO;

import com.google.inject.Guice;
import com.google.inject.Injector;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating BO objects.
 */
public final class BOFactory {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(BOFactory.class);

    /** The Constant INJECTOR. */
    private static final Injector INJECTOR = createInjector();

    /**
     * Creates a new BO object.
     *
     * @return the injector
     */
    private static Injector createInjector() {
        LOG.info("Configuracion Guice");

//      bind(TipoDato.class).to(TipoDatoBO.class);
//      bind(CodigoReferencia.class).to(CodigoReferenciaBO.class);
//      bind(Entidad.class).to(EntidadBO.class);
//      bind(EntidadEntidad.class).to(EntidadEntidadBO.class);
//      bind(EntidadGrupoDato.class).to(EntidadGrupoDatoBO.class);
//      bind(EntidadTipoDato.class).to(EntidadTipoDatoBO.class);
//
//      bind(TipoParametro.class).to(TipoParametroBO.class);
//      bind(TipoSubparametro.class).to(TipoSubparametroBO.class);
//      bind(Parametro.class).to(ParametroBO.class);
//      bind(Subparametro.class).to(SubparametroBO.class);
//
//      bind(TipoServicio.class).to(TipoServicioBO.class);
//      bind(TipoSubservicio.class).to(TipoSubservicioBO.class);
//      bind(Servicio.class).to(ServicioBO.class);
//      bind(Subservicio.class).to(SubservicioBO.class);
//      bind(Bl.class).to(BlBO.class);
//      bind(Equipamiento.class).to(EquipamientoBO.class);
//      bind(Manifiesto.class).to(ManifiestoBO.class);
//      bind(Partida.class).to(PartidaBO.class);
//
//      bind(TipoEstadistica.class).to(TipoEstadisticaBO.class);
//      bind(CuadroMes.class).to(CuadroMesBO.class);
//      bind(Estadistica.class).to(EstadisticaBO.class);
//      bind(PeriodoProceso.class).to(PeriodoProcesoBO.class);
//
//      bind(Clave.class).to(ClaveBO.class);
//      bind(ClaveIdioma.class).to(ClaveIdiomaBO.class);
//      bind(Entorno.class).to(EntornoBO.class);
//      bind(Idioma.class).to(IdiomaBO.class);
//
//      bind(Proceso.class).to(ProcesoBO.class);
//
//      bind(Facturador.class).to(FacturadorBO.class);
//      bind(Valorador.class).to(ValoradorBO.class);
//      bind(Valoracion.class).to(ValoracionBO.class);
        final Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("local");
                setClassPathResource("mybatis-config.xml");

                //bind(Factura.class).to(FacturaBO.class);
            }

        });

        LOG.info("Configuracion Guice OK");

        return injector;
    }

    /**
     * Gets the injector.
     *
     * @return the injector
     */
    public static Injector getInjector() {
        return INJECTOR;
    }

    /**
     * Gets the bo.
     *
     * @param type
     *            the type
     * @return the bo
     */
    public static T getBO(final Class<? extends T> type) {
        return INJECTOR.getInstance(type);
    }

}
