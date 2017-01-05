package xeredi.argo.model.util;

import java.util.Properties;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import com.google.inject.name.Names;

import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.service.ArchivoServiceImpl;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.service.ConfigurationProxyServiceImpl;
import xeredi.argo.model.comun.service.ConfigurationService;
import xeredi.argo.model.comun.service.ConfigurationServiceImpl;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.I18nServiceImpl;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.service.PuertoServiceImpl;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.service.SuperpuertoServiceImpl;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.service.AspectoCargoServiceImpl;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.service.AspectoServiceImpl;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.service.CargoServiceImpl;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleService;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleServiceImpl;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.service.ReglaServiceImpl;
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
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.EntidadServiceImpl;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoServiceImpl;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.service.ModuloServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoDatoServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaService;
import xeredi.argo.model.metamodelo.service.TipoEstadisticaServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.service.TipoParametroServiceImpl;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.service.TipoServicioServiceImpl;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyServiceImpl;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.service.TramiteServiceImpl;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoService;
import xeredi.argo.model.metamodelo.service.TramiteTipoDatoServiceImpl;
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

		properties.setProperty("mybatis.environment.id", "local");
		properties.setProperty("DataSource", "DBCP");
		properties.setProperty("JDBC.driver", "oracle.jdbc.OracleDriver");
		properties.setProperty("JDBC.url", "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		properties.setProperty("JDBC.username", "portico");
		properties.setProperty("JDBC.password", "portico");
		properties.setProperty("JDBC.autoCommit", "false");

		properties.setProperty("jdbcTypeForNull", "NULL");

		bindDataSourceProviderType(PooledDataSourceProvider.class);
		bindTransactionFactoryType(JdbcTransactionFactory.class);
		executorType(ExecutorType.REUSE);
		useCacheEnabled(false);

		addSimpleAliases("xeredi.argo.model.comun.vo");
		addSimpleAliases("xeredi.argo.model.facturacion.vo");
		addSimpleAliases("xeredi.argo.model.item.vo");
		addSimpleAliases("xeredi.argo.model.maestro.vo");
		addSimpleAliases("xeredi.argo.model.metamodelo.vo");
		addSimpleAliases("xeredi.argo.model.seguridad.vo");
		addSimpleAliases("xeredi.argo.model.servicio.vo");

		addMapperClasses("xeredi.argo.model.comun.dao");
		addMapperClasses("xeredi.argo.model.facturacion.dao");
		addMapperClasses("xeredi.argo.model.maestro.dao");
		addMapperClasses("xeredi.argo.model.maestro.dao.embdeportivas");
		addMapperClasses("xeredi.argo.model.metamodelo.dao");
		addMapperClasses("xeredi.argo.model.seguridad.dao");
		addMapperClasses("xeredi.argo.model.servicio.dao");

		Names.bindProperties(binder(), properties);

		// setEnvironmentId("local");
		// setClassPathResource("mybatis-config.xml");

		bind(ArchivoService.class).to(ArchivoServiceImpl.class);
		bind(ConfigurationService.class).to(ConfigurationServiceImpl.class);
		bind(ConfigurationProxyService.class).to(ConfigurationProxyServiceImpl.class);
		bind(I18nService.class).to(I18nServiceImpl.class);
		bind(PuertoService.class).to(PuertoServiceImpl.class);
		bind(SuperpuertoService.class).to(SuperpuertoServiceImpl.class);
		bind(CodigoReferenciaService.class).to(CodigoReferenciaServiceImpl.class);
		bind(TipoDatoService.class).to(TipoDatoServiceImpl.class);
		bind(TramiteService.class).to(TramiteServiceImpl.class);
		bind(TramiteProxyService.class).to(TramiteProxyServiceImpl.class);
		bind(TramiteTipoDatoService.class).to(TramiteTipoDatoServiceImpl.class);
		bind(ModuloService.class).to(ModuloServiceImpl.class);
		bind(EntidadService.class).to(EntidadServiceImpl.class);
		bind(EntidadEntidadService.class).to(EntidadEntidadServiceImpl.class);
		bind(EntidadGrupoDatoService.class).to(EntidadGrupoDatoServiceImpl.class);
		bind(EntidadTipoDatoService.class).to(EntidadTipoDatoServiceImpl.class);
		bind(TipoEstadisticaService.class).to(TipoEstadisticaServiceImpl.class);
		bind(TipoParametroService.class).to(TipoParametroServiceImpl.class);
		bind(TipoServicioService.class).to(TipoServicioServiceImpl.class);
		bind(AccionBaseService.class).to(AccionBaseServiceImpl.class);
		bind(AccionEntidadService.class).to(AccionEntidadServiceImpl.class);
		bind(AccionEntidadBaseService.class).to(AccionEntidadBaseServiceImpl.class);
		bind(AccionEspecialService.class).to(AccionEspecialServiceImpl.class);
		bind(CampoAgregacionService.class).to(CampoAgregacionServiceImpl.class);
		bind(UsuarioService.class).to(UsuarioServiceImpl.class);
		bind(UsuarioPermisoService.class).to(UsuarioPermisoServiceImpl.class);
		bind(GrupoService.class).to(GrupoServiceImpl.class);
		bind(ParametroService.class).to(ParametroServiceImpl.class);
		bind(SubparametroService.class).to(SubparametroServiceImpl.class);
		bind(AmarreDeportivoService.class).to(AmarreDeportivoServiceImpl.class);
		bind(AspectoService.class).to(AspectoServiceImpl.class);
		bind(AspectoCargoService.class).to(AspectoCargoServiceImpl.class);
		bind(CargoService.class).to(CargoServiceImpl.class);
		bind(ReglaService.class).to(ReglaServiceImpl.class);
		bind(ReglaIncompatibleService.class).to(ReglaIncompatibleServiceImpl.class);
	}

}
