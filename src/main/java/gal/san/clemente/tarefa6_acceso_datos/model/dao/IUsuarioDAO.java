package gal.san.clemente.tarefa6_acceso_datos.model.dao;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Usuario;
import java.util.List;

public interface IUsuarioDAO extends IDAO<Usuario>{
    Usuario obtenerNameAndUserName(String nome, String username) throws ProjectException;
    Usuario obtenerNameAndPassword(String nome, String password) throws ProjectException;
}
