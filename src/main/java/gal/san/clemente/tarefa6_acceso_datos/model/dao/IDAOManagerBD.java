package gal.san.clemente.tarefa6_acceso_datos.model.dao;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;

public interface IDAOManagerBD extends IDAOManager {
    IMensaxeDAO getMensaxeDAO() throws ProjectException;
    
    IUsuarioDAO getUsuarioDAO() throws ProjectException;
}
