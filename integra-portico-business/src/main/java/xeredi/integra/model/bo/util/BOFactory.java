package xeredi.integra.model.bo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.guice.XMLMyBatisModule;

import xeredi.integra.model.bo.configuracion.Clave;
import xeredi.integra.model.bo.configuracion.ClaveBO;
import xeredi.integra.model.bo.configuracion.ClaveIdioma;
import xeredi.integra.model.bo.configuracion.ClaveIdiomaBO;
import xeredi.integra.model.bo.configuracion.Entorno;
import xeredi.integra.model.bo.configuracion.EntornoBO;
import xeredi.integra.model.bo.configuracion.Idioma;
import xeredi.integra.model.bo.configuracion.IdiomaBO;
import xeredi.integra.model.bo.estadistica.CuadroMes;
import xeredi.integra.model.bo.estadistica.CuadroMesBO;
import xeredi.integra.model.bo.estadistica.Estadistica;
import xeredi.integra.model.bo.estadistica.EstadisticaBO;
import xeredi.integra.model.bo.estadistica.PeriodoProceso;
import xeredi.integra.model.bo.estadistica.PeriodoProcesoBO;
import xeredi.integra.model.bo.facturacion.Facturador;
import xeredi.integra.model.bo.facturacion.FacturadorBO;
import xeredi.integra.model.bo.facturacion.Valoracion;
import xeredi.integra.model.bo.facturacion.ValoracionBO;
import xeredi.integra.model.bo.facturacion.Valorador;
import xeredi.integra.model.bo.facturacion.ValoradorBO;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.maestro.ParametroBO;
import xeredi.integra.model.bo.maestro.Subparametro;
import xeredi.integra.model.bo.maestro.SubparametroBO;
import xeredi.integra.model.bo.metamodelo.CodigoReferencia;
import xeredi.integra.model.bo.metamodelo.CodigoReferenciaBO;
import xeredi.integra.model.bo.metamodelo.Entidad;
import xeredi.integra.model.bo.metamodelo.EntidadBO;
import xeredi.integra.model.bo.metamodelo.EntidadEntidad;
import xeredi.integra.model.bo.metamodelo.EntidadEntidadBO;
import xeredi.integra.model.bo.metamodelo.EntidadGrupoDato;
import xeredi.integra.model.bo.metamodelo.EntidadGrupoDatoBO;
import xeredi.integra.model.bo.metamodelo.EntidadTipoDato;
import xeredi.integra.model.bo.metamodelo.EntidadTipoDatoBO;
import xeredi.integra.model.bo.metamodelo.TipoDato;
import xeredi.integra.model.bo.metamodelo.TipoDatoBO;
import xeredi.integra.model.bo.metamodelo.TipoEstadistica;
import xeredi.integra.model.bo.metamodelo.TipoEstadisticaBO;
import xeredi.integra.model.bo.metamodelo.TipoParametro;
import xeredi.integra.model.bo.metamodelo.TipoParametroBO;
import xeredi.integra.model.bo.metamodelo.TipoServicio;
import xeredi.integra.model.bo.metamodelo.TipoServicioBO;
import xeredi.integra.model.bo.metamodelo.TipoSubparametro;
import xeredi.integra.model.bo.metamodelo.TipoSubparametroBO;
import xeredi.integra.model.bo.metamodelo.TipoSubservicio;
import xeredi.integra.model.bo.metamodelo.TipoSubservicioBO;
import xeredi.integra.model.bo.proceso.Proceso;
import xeredi.integra.model.bo.proceso.ProcesoBO;
import xeredi.integra.model.bo.servicio.Servicio;
import xeredi.integra.model.bo.servicio.ServicioBO;
import xeredi.integra.model.bo.servicio.Subservicio;
import xeredi.integra.model.bo.servicio.SubservicioBO;
import xeredi.integra.model.bo.servicio.manifiesto.Bl;
import xeredi.integra.model.bo.servicio.manifiesto.BlBO;
import xeredi.integra.model.bo.servicio.manifiesto.Equipamiento;
import xeredi.integra.model.bo.servicio.manifiesto.EquipamientoBO;
import xeredi.integra.model.bo.servicio.manifiesto.Manifiesto;
import xeredi.integra.model.bo.servicio.manifiesto.ManifiestoBO;
import xeredi.integra.model.bo.servicio.manifiesto.Partida;
import xeredi.integra.model.bo.servicio.manifiesto.PartidaBO;

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

        final Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("local");
                setClassPathResource("mybatis-config.xml");

                bind(TipoDato.class).to(TipoDatoBO.class);
                bind(CodigoReferencia.class).to(CodigoReferenciaBO.class);
                bind(Entidad.class).to(EntidadBO.class);
                bind(EntidadEntidad.class).to(EntidadEntidadBO.class);
                bind(EntidadGrupoDato.class).to(EntidadGrupoDatoBO.class);
                bind(EntidadTipoDato.class).to(EntidadTipoDatoBO.class);

                bind(TipoParametro.class).to(TipoParametroBO.class);
                bind(TipoSubparametro.class).to(TipoSubparametroBO.class);
                bind(Parametro.class).to(ParametroBO.class);
                bind(Subparametro.class).to(SubparametroBO.class);

                bind(TipoServicio.class).to(TipoServicioBO.class);
                bind(TipoSubservicio.class).to(TipoSubservicioBO.class);
                bind(Servicio.class).to(ServicioBO.class);
                bind(Subservicio.class).to(SubservicioBO.class);
                bind(Bl.class).to(BlBO.class);
                bind(Equipamiento.class).to(EquipamientoBO.class);
                bind(Manifiesto.class).to(ManifiestoBO.class);
                bind(Partida.class).to(PartidaBO.class);

                bind(TipoEstadistica.class).to(TipoEstadisticaBO.class);
                bind(CuadroMes.class).to(CuadroMesBO.class);
                bind(Estadistica.class).to(EstadisticaBO.class);
                bind(PeriodoProceso.class).to(PeriodoProcesoBO.class);

                bind(Clave.class).to(ClaveBO.class);
                bind(ClaveIdioma.class).to(ClaveIdiomaBO.class);
                bind(Entorno.class).to(EntornoBO.class);
                bind(Idioma.class).to(IdiomaBO.class);

                bind(Proceso.class).to(ProcesoBO.class);

                bind(Facturador.class).to(FacturadorBO.class);
                bind(Valorador.class).to(ValoradorBO.class);
                bind(Valoracion.class).to(ValoracionBO.class);
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

}
