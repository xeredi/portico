package xeredi.argo.model.util;

import java.util.Properties;

import org.apache.ibatis.executor.loader.javassist.JavassistProxyFactory;
import org.apache.ibatis.logging.nologging.NoLoggingImpl;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.bonecp.BoneCPProvider;

import com.google.inject.Singleton;
import com.google.inject.name.Names;

import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.service.ArchivoServiceImpl;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.service.ConfigurationProxyServiceImpl;
import xeredi.argo.model.comun.service.ConfigurationService;
import xeredi.argo.model.comun.service.ConfigurationServiceImpl;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.I18nServiceImpl;
import xeredi.argo.model.comun.service.MessageI18nService;
import xeredi.argo.model.comun.service.MessageI18nServiceImpl;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.service.PuertoServiceImpl;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.service.SuperpuertoServiceImpl;
import xeredi.argo.model.estadistica.service.CuadroMesService;
import xeredi.argo.model.estadistica.service.CuadroMesServiceImpl;
import xeredi.argo.model.estadistica.service.EstadisticaService;
import xeredi.argo.model.estadistica.service.EstadisticaServiceImpl;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.service.PeriodoProcesoServiceImpl;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.service.AspectoCargoServiceImpl;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.AspectoServiceImpl;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.service.CargoServiceImpl;
import xeredi.argo.model.facturacion.service.FacturaSerieService;
import xeredi.argo.model.facturacion.service.FacturaSerieServiceImpl;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleService;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleServiceImpl;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.service.ReglaServiceImpl;
import xeredi.argo.model.facturacion.service.ValoracionCargoService;
import xeredi.argo.model.facturacion.service.ValoracionCargoServiceImpl;
import xeredi.argo.model.facturacion.service.ValoracionDetalleService;
import xeredi.argo.model.facturacion.service.ValoracionDetalleServiceImpl;
import xeredi.argo.model.facturacion.service.ValoracionImpuestoService;
import xeredi.argo.model.facturacion.service.ValoracionImpuestoServiceImpl;
import xeredi.argo.model.facturacion.service.ValoracionLineaService;
import xeredi.argo.model.facturacion.service.ValoracionLineaServiceImpl;
import xeredi.argo.model.facturacion.service.ValoracionService;
import xeredi.argo.model.facturacion.service.ValoracionServiceImpl;
import xeredi.argo.model.facturacion.service.ValoradorService;
import xeredi.argo.model.facturacion.service.ValoradorServiceImpl;
import xeredi.argo.model.item.service.ItemTramiteService;
import xeredi.argo.model.item.service.ItemTramiteServiceImpl;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.service.ParametroServiceImpl;
import xeredi.argo.model.maestro.service.SubparametroService;
import xeredi.argo.model.maestro.service.SubparametroServiceImpl;
import xeredi.argo.model.maestro.service.embdeportivas.AmarreDeportivoService;
import xeredi.argo.model.maestro.service.embdeportivas.AmarreDeportivoServiceImpl;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.service.AccionBaseServiceImpl;
import xeredi.argo.model.metamodelo.service.AccionEntidadBaseService;
import xeredi.argo.model.metamodelo.service.AccionEntidadBaseServiceImpl;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.service.AccionEntidadServiceImpl;
import xeredi.argo.model.metamodelo.service.AccionEspecialService;
import xeredi.argo.model.metamodelo.service.AccionEspecialServiceImpl;
import xeredi.argo.model.metamodelo.service.CampoAgregacionService;
import xeredi.argo.model.metamodelo.service.CampoAgregacionServiceImpl;
import xeredi.argo.model.metamodelo.service.CodigoReferenciaService;
import xeredi.argo.model.metamodelo.service.CodigoReferenciaServiceImpl;
import xeredi.argo.model.metamodelo.service.EntidadEntidadService;
import xeredi.argo.model.metamodelo.service.EntidadEntidadServiceImpl;
import xeredi.argo.model.metamodelo.service.EntidadGrupoDatoService;
import xeredi.argo.model.metamodelo.service.EntidadGrupoDatoServiceImpl;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.service.EntidadProxyServiceImpl;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.EntidadServiceImpl;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoServiceImpl;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.service.ModuloServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyService;
import xeredi.argo.model.metamodelo.service.TipoDatoProxyServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoDatoServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.service.TipoParametroServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.service.TipoServicioServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoSubparametroService;
import xeredi.argo.model.metamodelo.service.TipoSubparametroServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.service.TipoSubservicioServiceImpl;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyServiceImpl;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.service.TramiteServiceImpl;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoService;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoServiceImpl;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.service.ProcesoServiceImpl;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.service.GrupoServiceImpl;
import xeredi.argo.model.seguridad.service.UsuarioPermisoService;
import xeredi.argo.model.seguridad.service.UsuarioPermisoServiceImpl;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.service.UsuarioServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ArgoGuiceModule.
 */
public final class ArgoGuiceModule extends MyBatisModule {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		final Properties properties = new Properties();

		properties.setProperty("JDBC.driver", "oracle.jdbc.OracleDriver");
		properties.setProperty("JDBC.url", "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		properties.setProperty("JDBC.username", "portico");
		properties.setProperty("JDBC.password", "portico");
		properties.setProperty("JDBC.autoCommit", "false");

		bindDataSourceProviderType(BoneCPProvider.class);
		bindTransactionFactoryType(JdbcTransactionFactory.class);
		useCacheEnabled(false);
		executorType(ExecutorType.REUSE);
		environmentId("local");

		bindConfigurationSetting(configuration -> {
			configuration.setDefaultExecutorType(ExecutorType.REUSE);
			configuration.setLogImpl(NoLoggingImpl.class);
			// configuration.setLogImpl(Log4jImpl.class);
			configuration.setJdbcTypeForNull(JdbcType.NULL);
			configuration.setProxyFactory(new JavassistProxyFactory());
			// configuration.setProxyFactory(new CglibProxyFactory());
		});

		Names.bindProperties(binder(), properties);

		addSimpleAliases("xeredi.argo.model.comun.vo");
		addSimpleAliases("xeredi.argo.model.estadistica.vo");
		addSimpleAliases("xeredi.argo.model.facturacion.vo");
		addSimpleAliases("xeredi.argo.model.item.vo");
		addSimpleAliases("xeredi.argo.model.maestro.vo");
		addSimpleAliases("xeredi.argo.model.metamodelo.vo");
		addSimpleAliases("xeredi.argo.model.proceso.vo");
		addSimpleAliases("xeredi.argo.model.seguridad.vo");
		addSimpleAliases("xeredi.argo.model.servicio.vo");

		addMapperClasses("xeredi.argo.model.comun.dao");
		addMapperClasses("xeredi.argo.model.estadistica.dao");
		addMapperClasses("xeredi.argo.model.facturacion.dao");
		addMapperClasses("xeredi.argo.model.item.dao");
		addMapperClasses("xeredi.argo.model.maestro.dao");
		addMapperClasses("xeredi.argo.model.maestro.dao.embdeportivas");
		addMapperClasses("xeredi.argo.model.metamodelo.dao");
		addMapperClasses("xeredi.argo.model.proceso.dao");
		addMapperClasses("xeredi.argo.model.seguridad.dao");
		addMapperClasses("xeredi.argo.model.servicio.dao");

		// setEnvironmentId("local");
		// setClassPathResource("mybatis-config.xml");

		bind(ArchivoService.class).to(ArchivoServiceImpl.class).in(Singleton.class);
		bind(ConfigurationService.class).to(ConfigurationServiceImpl.class).in(Singleton.class);
		bind(ConfigurationProxyService.class).to(ConfigurationProxyServiceImpl.class).in(Singleton.class);
		bind(I18nService.class).to(I18nServiceImpl.class).in(Singleton.class);
		bind(MessageI18nService.class).to(MessageI18nServiceImpl.class).in(Singleton.class);
		bind(PuertoService.class).to(PuertoServiceImpl.class).in(Singleton.class);
		bind(SuperpuertoService.class).to(SuperpuertoServiceImpl.class).in(Singleton.class);
		bind(CodigoReferenciaService.class).to(CodigoReferenciaServiceImpl.class).in(Singleton.class);
		bind(TipoDatoService.class).to(TipoDatoServiceImpl.class).in(Singleton.class);
		bind(TipoDatoProxyService.class).to(TipoDatoProxyServiceImpl.class).in(Singleton.class);
		bind(TramiteService.class).to(TramiteServiceImpl.class).in(Singleton.class);
		bind(TramiteProxyService.class).to(TramiteProxyServiceImpl.class).in(Singleton.class);
		bind(TramiteTipoDatoService.class).to(TramiteTipoDatoServiceImpl.class).in(Singleton.class);
		bind(ModuloService.class).to(ModuloServiceImpl.class).in(Singleton.class);
		bind(EntidadService.class).to(EntidadServiceImpl.class).in(Singleton.class);
		bind(EntidadProxyService.class).to(EntidadProxyServiceImpl.class).in(Singleton.class);
		bind(EntidadEntidadService.class).to(EntidadEntidadServiceImpl.class).in(Singleton.class);
		bind(EntidadGrupoDatoService.class).to(EntidadGrupoDatoServiceImpl.class).in(Singleton.class);
		bind(EntidadTipoDatoService.class).to(EntidadTipoDatoServiceImpl.class).in(Singleton.class);
		bind(TipoEstadisticaService.class).to(TipoEstadisticaServiceImpl.class).in(Singleton.class);
		bind(TipoParametroService.class).to(TipoParametroServiceImpl.class).in(Singleton.class);
		bind(TipoSubparametroService.class).to(TipoSubparametroServiceImpl.class).in(Singleton.class);
		bind(TipoServicioService.class).to(TipoServicioServiceImpl.class).in(Singleton.class);
		bind(TipoSubservicioService.class).to(TipoSubservicioServiceImpl.class).in(Singleton.class);
		bind(AccionBaseService.class).to(AccionBaseServiceImpl.class).in(Singleton.class);
		bind(AccionEntidadService.class).to(AccionEntidadServiceImpl.class).in(Singleton.class);
		bind(AccionEntidadBaseService.class).to(AccionEntidadBaseServiceImpl.class).in(Singleton.class);
		bind(AccionEspecialService.class).to(AccionEspecialServiceImpl.class).in(Singleton.class);
		bind(CampoAgregacionService.class).to(CampoAgregacionServiceImpl.class).in(Singleton.class);
		bind(UsuarioService.class).to(UsuarioServiceImpl.class).in(Singleton.class);
		bind(UsuarioPermisoService.class).to(UsuarioPermisoServiceImpl.class).in(Singleton.class);
		bind(GrupoService.class).to(GrupoServiceImpl.class).in(Singleton.class);
		bind(ItemTramiteService.class).to(ItemTramiteServiceImpl.class).in(Singleton.class);
		bind(ParametroService.class).to(ParametroServiceImpl.class).in(Singleton.class);
		bind(SubparametroService.class).to(SubparametroServiceImpl.class).in(Singleton.class);
		bind(AmarreDeportivoService.class).to(AmarreDeportivoServiceImpl.class).in(Singleton.class);
		bind(FacturaSerieService.class).to(FacturaSerieServiceImpl.class).in(Singleton.class);
		bind(AspectoService.class).to(AspectoServiceImpl.class).in(Singleton.class);
		bind(AspectoCargoService.class).to(AspectoCargoServiceImpl.class).in(Singleton.class);
		bind(CargoService.class).to(CargoServiceImpl.class).in(Singleton.class);
		bind(ReglaService.class).to(ReglaServiceImpl.class).in(Singleton.class);
		bind(ReglaIncompatibleService.class).to(ReglaIncompatibleServiceImpl.class).in(Singleton.class);
		bind(ValoracionService.class).to(ValoracionServiceImpl.class).in(Singleton.class);
		bind(ValoracionCargoService.class).to(ValoracionCargoServiceImpl.class).in(Singleton.class);
		bind(ValoracionImpuestoService.class).to(ValoracionImpuestoServiceImpl.class).in(Singleton.class);
		bind(ValoracionLineaService.class).to(ValoracionLineaServiceImpl.class).in(Singleton.class);
		bind(ValoracionDetalleService.class).to(ValoracionDetalleServiceImpl.class).in(Singleton.class);
		bind(ValoradorService.class).to(ValoradorServiceImpl.class).in(Singleton.class);
		bind(PeriodoProcesoService.class).to(PeriodoProcesoServiceImpl.class).in(Singleton.class);
		bind(CuadroMesService.class).to(CuadroMesServiceImpl.class).in(Singleton.class);
		bind(EstadisticaService.class).to(EstadisticaServiceImpl.class).in(Singleton.class);
		bind(ProcesoService.class).to(ProcesoServiceImpl.class).in(Singleton.class);
	}

}
