package xeredi.util.mongodb;

import java.util.List;
import java.util.Set;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xeredi.util.configuration.ConfigurationUtil;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

// TODO: Auto-generated Javadoc
/**
 * The Class DbManager.
 */
public final class DbManager {
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(DbManager.class);

    /** The Constant DBHOST_PARAM. */
    private static final String DBHOST_PARAM = "db.host";

    /** The Constant DBPORT_PARAM. */
    private static final String DBPORT_PARAM = "db.port";

    /** The Constant DBNAME_PARAM. */
    private static final String DBNAME_PARAM = "db.name";

    /** The db. */
    private static DB db;

    /**
     * Instancia un nuevo db manager.
     */
    private DbManager() {
        super();
    }

    static {
        try {
            LOG.info("Connect to Mongo database");

            final Configuration configuration = ConfigurationUtil.getConfiguration();

            final String host = configuration.getString(DBHOST_PARAM);
            final int port = configuration.getInt(DBPORT_PARAM);
            final String name = configuration.getString(DBNAME_PARAM);

            LOG.info("Connect to Mongo server on {}:{}", host, port);
            final Mongo mongo = new Mongo(host, port);

            LOG.info("Connect to Mongo database {}", name);
            db = mongo.getDB(name);

            LOG.info("Connect to Mongo database OK");
        } catch (final Exception ex) {
            LOG.error("Error connecting to Mongo database", ex);
        }
    }

    /**
     * Gets the dB.
     * 
     * @return the dB
     */
    public static DB getDB() {
        return db;
    }

    /**
     * Index info.
     * 
     * @param collection
     *            the collection
     */
    private static void indexInfo(final DBCollection collection) {
        if (LOG.isDebugEnabled()) {
            LOG.info("Collection {} indexes", collection.getName());

            final List<DBObject> list = collection.getIndexInfo();

            for (final DBObject o : list) {
                LOG.info("Index Field", o);
            }
        }
    }

    /**
     * Db info.
     */
    public static void dbInfo() {
        if (LOG.isDebugEnabled()) {
            LOG.info("DB Info");

            final Set<String> collectionNames = db.getCollectionNames();

            for (final String collectionName : collectionNames) {
                final DBCollection collection = db.getCollection(collectionName);

                LOG.info("Collection {} : {} rows", collectionName, collection.count());

                indexInfo(collection);
            }
        }
    }
}
