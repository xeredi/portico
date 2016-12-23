package xeredi.argo.model.util;

import java.util.Properties;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import com.google.inject.name.Names;

import xeredi.argo.model.comun.dao.ConfigurationDAO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.dao.PuertoDAO;
import xeredi.argo.model.comun.dao.SuperpuertoDAO;
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
import xeredi.argo.model.comun.vo.ConfigurationCriterioVO;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.comun.vo.I18nCriterioVO;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.dao.GrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioPermisoDAO;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.service.GrupoServiceImpl;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.service.UsuarioServiceImpl;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioPermisoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

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

		bindDataSourceProviderType(PooledDataSourceProvider.class);
		bindTransactionFactoryType(JdbcTransactionFactory.class);
		executorType(ExecutorType.REUSE);
		useCacheEnabled(false);

		addSimpleAlias(ConfigurationVO.class);
		addSimpleAlias(ConfigurationCriterioVO.class);
		addSimpleAlias(I18nVO.class);
		addSimpleAlias(I18nCriterioVO.class);
		addSimpleAlias(PuertoVO.class);
		addSimpleAlias(PuertoCriterioVO.class);
		addSimpleAlias(SuperpuertoVO.class);
		addSimpleAlias(SuperpuertoCriterioVO.class);
		addSimpleAlias(FuncionalidadGrupoCriterioVO.class);
		addSimpleAlias(FuncionalidadGrupoVO.class);
		addSimpleAlias(GrupoCriterioVO.class);
		addSimpleAlias(GrupoVO.class);
		addSimpleAlias(UsuarioCriterioVO.class);
		addSimpleAlias(UsuarioVO.class);
		addSimpleAlias(UsuarioGrupoCriterioVO.class);
		addSimpleAlias(UsuarioGrupoVO.class);
		addSimpleAlias(UsuarioPermisoCriterioVO.class);
		addSimpleAlias(ParametroVO.class);

		addMapperClass(ConfigurationDAO.class);
		addMapperClass(I18nDAO.class);
		addMapperClass(PuertoDAO.class);
		addMapperClass(SuperpuertoDAO.class);
		addMapperClass(FuncionalidadGrupoDAO.class);
		addMapperClass(FuncionalidadGrupoDAO.class);
		addMapperClass(GrupoDAO.class);
		addMapperClass(UsuarioDAO.class);
		addMapperClass(UsuarioGrupoDAO.class);
		addMapperClass(UsuarioPermisoDAO.class);

		Names.bindProperties(binder(), properties);

		bind(ConfigurationService.class).to(ConfigurationServiceImpl.class);
		bind(ConfigurationProxyService.class).to(ConfigurationProxyServiceImpl.class);
		bind(I18nService.class).to(I18nServiceImpl.class);
		bind(PuertoService.class).to(PuertoServiceImpl.class);
		bind(SuperpuertoService.class).to(SuperpuertoServiceImpl.class);
		bind(UsuarioService.class).to(UsuarioServiceImpl.class);
		bind(GrupoService.class).to(GrupoServiceImpl.class);

		// setEnvironmentId("local");
		// setClassPathResource("mybatis-config.xml");
	}

}
