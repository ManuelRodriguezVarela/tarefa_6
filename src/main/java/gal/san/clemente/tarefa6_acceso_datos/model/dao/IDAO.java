package gal.san.clemente.tarefa6_acceso_datos.model.dao;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Mensaxe;
import java.util.List;

public interface IDAO<T> {
    void insertar(T entidad) throws ProjectException;
    
    void modificar(T entidad) throws ProjectException;
    
    void eliminar(T entidad) throws ProjectException;
    
    List<T> obtenerTodos() throws ProjectException;
    
    T obtener(String entidadName) throws ProjectException;
    
    Long totalRegisteres() throws ProjectException;
    
    List<T> obtenerTodos(int skip, int limit) throws ProjectException;
}
