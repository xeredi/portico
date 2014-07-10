package xeredi.maven.schemaspy;

import net.sourceforge.schemaspy.Main;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

// TODO: Auto-generated Javadoc
/**
 * The Class SchemaspyMojo.
 */
@Mojo(name = "schemaspy")
public final class SchemaspyMojo extends AbstractMojo {
//    @Parameter(required = true, name = "${project.build.directory}")
//    private String outputDirectory;
//
    /** The database type. */
    @Parameter(required = true)
    private String databaseType;

    /** The database. */
    @Parameter(required = true)
    private String database;

    /** The schema. */
    @Parameter(required = true)
    private String schema;

    /** The host. */
    @Parameter(required = true)
    private String host;

    /** The user. */
    @Parameter(required = true)
    private String user;

    /** The password. */
    @Parameter(required = true)
    private String password;

    /** The port. */
    @Parameter(required = true)
    private String port;

    /**
     * {@inheritDoc}
     */
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Schemaspy start");

        getLog().info("Parameters");

        getLog().info("databaseType: " + databaseType);
        getLog().info("database: " + database);
        getLog().info("host: " + host);
        getLog().info("user: " + user);
        getLog().info("password: " + password);
        getLog().info("port: " + port);

        try {
            Main.main(new String[] { "-t", databaseType, "-host", host, "-db", database, "-s", schema, "-u", user,
                    "-p", password, "-o", "target/site/schemaspy", "-dp", "jdbc-pg.jar" });
        } catch (final Exception ex) {
            getLog().error("Error Generating Schemaspy");
            getLog().error(ex);
        }

        getLog().info("Schemaspy end");
    }
}
