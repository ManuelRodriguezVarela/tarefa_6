package gal.san.clemente.tarefa6_acceso_datos.model.dao;

public interface IDAOManagerJSON extends IDAOManager {
    
    IConfigurationDAO getConfigurationDAO(String url);
    
}
