/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.san.clemente.tarefa6_acceso_datos.view;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Mensaxe;
import gal.san.clemente.tarefa6_acceso_datos.model.Usuario;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IConfigurationDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManagerBD;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManagerJSON;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IMensaxeDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IUsuarioDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation.DAOManagerBBDDImpl;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation.DAOManagerFactory;
import gal.san.clemente.tarefa6_acceso_datos.model.utils.ConnectionConf;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manu
 */
public class NewClass {
    public static IConfigurationDAO daoConfiguration;
    public static final String JSON = "json";
    public static final String CONFIGURATION = "configuration.json";
    public static ConnectionConf dddd;
    public static IDAOManagerJSON manager_json;
    public static IMensaxeDAO model;
    public static IDAOManagerBD managerBbdd;
    private static final String BBDD = "bbdd";
    
    public static void main(String[] args) {
        
         
        try {
            
            manager_json = (IDAOManagerJSON) DAOManagerFactory.getDAOManager(JSON);
             
            daoConfiguration = manager_json.getConfigurationDAO(CONFIGURATION);
            dddd = daoConfiguration.obtener("");
            
            Usuario u = new Usuario("Nombre", "Username", "Password");
            Mensaxe m = new Mensaxe("Texto do mensaxe 0", u);
            m.addHashtag("Hastag 0");
            
            Mensaxe m1 = new Mensaxe("Texto do mensaxe 1", u);
            m1.addHashtag("Hastag 1");
            
            Mensaxe m2 = new Mensaxe("Texto do mensaxe", u);
            m2.addHashtag("Hastag 2");
            
            Mensaxe m3 = new Mensaxe("Texto do mensaxe 3", u);
            m3.addHashtag("Hastag 3");
            
            Mensaxe m4 = new Mensaxe("Texto do mensaxe 4", u);
            m4.addHashtag("Hastag 4");
            
            Mensaxe m5 = new Mensaxe("Texto do mensaxe 5", u);
            m5.addHashtag("Hastag 5");
            
            Mensaxe m6 = new Mensaxe("Texto do mensaxe 6", u);
            m6.addHashtag("Hastag 6");
            
            Mensaxe m7 = new Mensaxe("Texto do mensaxe 7 ", u);
            m7.addHashtag("Hastag 7");
            
            Mensaxe m8 = new Mensaxe("Texto do mensaxe 8", u);
            m8.addHashtag("Hastag 9");
            
            Mensaxe m9 = new Mensaxe("Texto do mensaxen 9", u);
            m9.addHashtag("Hastag 9");
            
            Mensaxe m10 = new Mensaxe("Texto do mensaxe 10", u);
            m10.addHashtag("Hastag 10");
            
            managerBbdd = (IDAOManagerBD) DAOManagerFactory.getDAOManager(BBDD);
            model = managerBbdd.getMensaxeDAO();
            model.insertar(m);
            model.insertar(m1);
            model.insertar(m2);
            model.insertar(m3);
            model.insertar(m4);
            model.insertar(m5);
            model.insertar(m6);
            model.insertar(m7);
            model.insertar(m8);
            model.insertar(m9);
            model.insertar(m10);
            System.out.println(dddd.getAddress());
            

         } catch (ProjectException ex) {
            System.err.println(ex);
         }

    }
}
