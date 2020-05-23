package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAO;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class DAOImplJson <T> implements IDAO<T> {
    
    protected File file;

    private Class<T> persistentClass;

    public DAOImplJson(Class<T> persistentClass, File file) {
	this.persistentClass = persistentClass;
        this.file = file;
    }

    public DAOImplJson() {
    } 

    @Override
    public void insertar(T entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(T entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(T entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> obtenerTodos() throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T obtener(String entidadName) throws ProjectException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        T object =  null;
        try {
            object = gson.fromJson(new FileReader(file), persistentClass);
        } catch(Exception e) {
            throw new ProjectException(e.getMessage(), e);
        }
        return object;
    }
    
    @Override
    public Long totalRegisteres() throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> obtenerTodos(int skip, int limit) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }       
    
}
