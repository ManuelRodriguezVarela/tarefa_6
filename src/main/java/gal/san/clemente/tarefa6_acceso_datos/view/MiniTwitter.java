package gal.san.clemente.tarefa6_acceso_datos.view;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiniTwitter {

    public static void main(String[] args) {   
        
        MensaxeView view;
        try {
            view = new MensaxeView();
            view.setVisible(true);
        } catch (ProjectException ex) {
            Logger.getLogger(MiniTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
