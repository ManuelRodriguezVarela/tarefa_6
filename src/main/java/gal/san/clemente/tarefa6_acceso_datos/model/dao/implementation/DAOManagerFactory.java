package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManager;

public class DAOManagerFactory {
    public static IDAOManager getDAOManager(String type) throws ProjectException {
        if ( type.equals("json") )
            return new DAOManagerJSONImpl();
        else if ( type.equals("bbdd") )
            return new DAOManagerBBDDImpl();
        return null;
    }
}
