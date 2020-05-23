package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import gal.san.clemente.tarefa6_acceso_datos.model.dao.IConfigurationDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.utils.ConnectionConf;
import java.io.File;

public class ConfigurationJSONDAOImpl extends DAOImplJson<ConnectionConf> implements IConfigurationDAO {
    
    public ConfigurationJSONDAOImpl(File file) {
        super(ConnectionConf.class, file);
    }
    
}
