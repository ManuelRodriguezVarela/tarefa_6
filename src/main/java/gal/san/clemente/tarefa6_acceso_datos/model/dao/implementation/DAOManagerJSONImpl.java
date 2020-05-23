package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import gal.san.clemente.tarefa6_acceso_datos.model.dao.IConfigurationDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManagerJSON;
import java.io.File;



public class DAOManagerJSONImpl extends DAOManagerFactory implements IDAOManagerJSON {
    
    private IConfigurationDAO configurationDAO = null;
    
    public DAOManagerJSONImpl() {
        
    }
    
    @Override
    public IConfigurationDAO getConfigurationDAO(String url) {
        File file = new File(url);
        if(configurationDAO == null) {
           configurationDAO = new ConfigurationJSONDAOImpl(file);
        }
        return configurationDAO;
    }

}
