package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Usuario;
import gal.san.clemente.tarefa6_acceso_datos.model.converter.IConverter;
import gal.san.clemente.tarefa6_acceso_datos.model.converter.UsuarioConverter;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

public class DAOUsuarioImpl extends DAOImpl<Usuario> implements IUsuarioDAO {
    
    private DB connection;
    private IConverter usuarioConverter;
    private DBCollection collection;

    public DAOUsuarioImpl(DB connection) {
	this.connection = connection;
        this.usuarioConverter = new UsuarioConverter();
        collection = connection.getCollection("usuario");
    }

    @Override
    public void insertar(Usuario entidad) throws ProjectException {
        BasicDBObject userMongo = (BasicDBObject) usuarioConverter.EntityToBaseData(entidad);
        collection.insert(userMongo);
    }

    @Override
    public void modificar(Usuario entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuario entidad) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> obtenerTodos() throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtener(String entidadName) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Usuario obtenerNameAndPassword(String nome, String password) throws ProjectException {
        Bson filter = Filters.and(Filters.eq("nome", nome), Filters.eq("password", password));
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBObject userMongo = collection.findOne(query);
        return (Usuario) usuarioConverter.BaseDataToEntity(userMongo);
    }
    
    @Override
    public Usuario obtenerNameAndUserName(String nome, String username) throws ProjectException {
        Bson filter = Filters.and(Filters.eq("nome", nome), Filters.eq("username", username));
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBObject userMongo = collection.findOne(query);
        return (Usuario) usuarioConverter.BaseDataToEntity(userMongo);
    }
    
    @Override
    public List<Usuario> obtenerTodos(int limit, int skip) throws ProjectException {
        List<Usuario> usuarios = new ArrayList<>();
        DBCursor usersMongo = collection.find().limit(limit).skip(skip);
        while (usersMongo.hasNext()) {
            DBObject userMongo = usersMongo.next();
            usuarios.add((Usuario) usuarioConverter.BaseDataToEntity(userMongo));
        }
        return usuarios;
    }

    @Override
    public Long totalRegisteres() throws ProjectException {
        return collection.count();
    }
    
}
