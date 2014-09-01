package xeredi.util.mybatis;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating C3P0DataSource objects.
 */
public final class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

    /**
     * Instantiates a new c3 p0 data source factory.
     */
    public C3P0DataSourceFactory() {
        dataSource = new ComboPooledDataSource();
    }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public void setProperties(final Properties properties) {
    // final Properties newProperties = new Properties();
    //
    // properties.setProperty("driverClass", properties.getProperty("driver"));
    // properties.setProperty("jdbcUrl", properties.getProperty("url"));
    // properties.setProperty("user", properties.getProperty("username"));
    // properties.setProperty("password", properties.getProperty("password"));
    //
    // if ("true".equals(properties.get("poolPingEnabled"))) {
    // properties.setProperty("preferredTestQuery", properties.getProperty("poolPingQuery"));
    // }
    //
    // properties.setProperty("maxPoolSize", properties.getProperty("poolMaximumActiveConnections"));
    //
    // super.setProperties(newProperties);
    // }
}
