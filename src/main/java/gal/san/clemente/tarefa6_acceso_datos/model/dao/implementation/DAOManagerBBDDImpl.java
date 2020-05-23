package gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation;

import com.mongodb.DB;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManagerBD;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IMensaxeDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IUsuarioDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.utils.MongoDBUtil;

public class DAOManagerBBDDImpl implements IDAOManagerBD {
    
    private DB conexion;
    
    private IMensaxeDAO mensaxeDao = null;
    private IUsuarioDAO usuarioDao = null;
    
    public DAOManagerBBDDImpl() throws ProjectException {
        conexion = MongoDBUtil.getConnection();
    }

    @Override
    public IMensaxeDAO getMensaxeDAO() {
        if(mensaxeDao == null) {
            mensaxeDao = new DAOMensaxeImpl(conexion);
        }
        return mensaxeDao;
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        if(usuarioDao == null) {
            usuarioDao = new DAOUsuarioImpl(conexion);
        }
        return usuarioDao;
    }
    
}
