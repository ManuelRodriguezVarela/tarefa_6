package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Mensaxe;
import gal.san.clemente.tarefa6_acceso_datos.model.Usuario;
import gal.san.clemente.tarefa6_acceso_datos.model.converter.IConverter;
import gal.san.clemente.tarefa6_acceso_datos.model.converter.MensaxeConverter;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IMensaxeDAO;
import java.util.ArrayList;
import java.util.List;

public class DAOMensaxeImpl extends DAOImpl<Mensaxe> implements IMensaxeDAO {
    
    private DB connection;
    private IConverter mensaxeConverter;
    private DBCollection collection;

    public DAOMensaxeImpl(DB connection) {
	this.connection = connection;
        this.mensaxeConverter = new MensaxeConverter();
        collection = connection.getCollection("mensaxe");
    }

    @Override
    public void insertar(Mensaxe entidad) throws ProjectException {
        BasicDBObject msmMongo = (BasicDBObject) mensaxeConverter.EntityToBaseData(entidad);
        collection.insert(msmMongo);
    }

    @Override
    public void modificar(Mensaxe entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Mensaxe entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mensaxe> obtenerTodos() throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaxe obtener(String entidadName) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Mensaxe> obtenerTodos(int skip, int limit) throws ProjectException {
        List<Mensaxe> mensaxes = new ArrayList<>();
        DBCursor usersMongo = collection.find().skip(skip).limit(limit);
        while (usersMongo.hasNext()) {
            DBObject userMongo = usersMongo.next();
            mensaxes.add((Mensaxe) mensaxeConverter.BaseDataToEntity(userMongo));
        }
        return mensaxes;
    }

    @Override
    public Long totalRegisteres() throws ProjectException {
        return collection.count();
    }
    
}
