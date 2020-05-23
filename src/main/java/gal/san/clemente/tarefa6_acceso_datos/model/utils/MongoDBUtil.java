package gal.san.clemente.tarefa6_acceso_datos.model.utils;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IConfigurationDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManagerJSON;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation.DAOManagerFactory;

public class MongoDBUtil {
    private MongoClient client;
    private static DB connection;
    private IConfigurationDAO daoConfiguration;
    private final String JSON = "json";
    private final String CONFIGURATION = "./configuration.json";
    private ConnectionConf conf;
    private IDAOManagerJSON manager_json;
    
    private MongoDBUtil() throws ProjectException {
        manager_json = (IDAOManagerJSON) DAOManagerFactory.getDAOManager(JSON);
        daoConfiguration = manager_json.getConfigurationDAO(CONFIGURATION);
        conf = daoConfiguration.obtener("");
        client = new MongoClient(getUri(conf));
        connection = client.getDB(conf.getDbname());
    }
    
    public static DB getConnection() throws ProjectException {
        if(connection == null) {
            new MongoDBUtil();
        }
        return connection;
    }
    
    private MongoClientURI getUri(ConnectionConf conf) {
        MongoClientURI uri;
        if(conf.getUsername().isEmpty() && conf.getPassword().isEmpty())
            uri = new MongoClientURI("mongodb://"+conf.getAddress()+":"+conf.getPort()+"/?"+"retryWrites=false");
        else
            uri = new MongoClientURI("mongodb://"+conf.getUsername()+":"+conf.getPassword()+"@"+conf.getAddress()+":"+conf.getPort()+"/"+conf.getDbname()+"?"+"retryWrites=false");
        
        return uri;
    }
    
    public void cerrarConexion() {
        client.close();
    }
}
