package xeredi.argo.model.util;

import java.util.Properties;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.seguridad.dao.GrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioPermisoDAO;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.service.UsuarioServiceImpl;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioPermisoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GuiceInjector.
 */
public final class GuiceInjector {

	private static final Injector injector = Guice.createInjector(new PrivateModule() {
		@Override
		protected void configure() {
			final Properties properties = new Properties();

			properties.setProperty("mybatis.environment.id", "local");
			properties.setProperty("DataSource", "DBCP");
			properties.setProperty("JDBC.driver", "oracle.jdbc.OracleDriver");
			properties.setProperty("JDBC.url", "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
			properties.setProperty("JDBC.username", "portico");
			properties.setProperty("JDBC.password", "portico");
			properties.setProperty("JDBC.autoCommit", "false");

			install(new MyBatisModule() {
				@Override
				protected void initialize() {
					bindDataSourceProviderType(PooledDataSourceProvider.class);
					bindTransactionFactoryType(JdbcTransactionFactory.class);

					addSimpleAlias(UsuarioVO.class);
					addSimpleAlias(UsuarioCriterioVO.class);
					addSimpleAlias(UsuarioGrupoVO.class);
					addSimpleAlias(UsuarioGrupoCriterioVO.class);
					addSimpleAlias(UsuarioPermisoCriterioVO.class);
					addSimpleAlias(GrupoVO.class);
					addSimpleAlias(GrupoCriterioVO.class);
					addSimpleAlias(SuperpuertoVO.class);
					addSimpleAlias(PuertoVO.class);
					addSimpleAlias(ParametroVO.class);

					addMapperClass(UsuarioDAO.class);
					addMapperClass(UsuarioGrupoDAO.class);
					addMapperClass(UsuarioPermisoDAO.class);
					addMapperClass(GrupoDAO.class);
				}
			});

			Names.bindProperties(binder(), properties);

			bind(UsuarioService.class).to(UsuarioServiceImpl.class);

			expose(UsuarioService.class);

			// install(new XMLMyBatisModule() {
			// @Override
			// protected void initialize() {
			// setEnvironmentId("local");
			// setClassPathResource("mybatis-config.xml");
			//
			// bindTransactionInterceptors();
			// }
			// });
			//
			// expose(UsuarioService.class);
		}

	});

	/**
	 * Gets the injector.
	 *
	 * @return the injector
	 */
	public static Injector getInjector() {
		return injector;
	}
}
