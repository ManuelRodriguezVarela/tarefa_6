package gal.san.clemente.tarefa6_acceso_datos.controller;

import gal.san.clemente.tarefa6_acceso_datos.controller.utils.IPagination;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Mensaxe;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IDAOManagerBD;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.IMensaxeDAO;
import gal.san.clemente.tarefa6_acceso_datos.model.dao.implementation.DAOManagerFactory;
import gal.san.clemente.tarefa6_acceso_datos.view.MensaxeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ControllerMensaxe implements ActionListener, TableModelListener {
    private final MensaxeView view;
    private final IMensaxeDAO model;
    private final IDAOManagerBD managerBbdd;
    private static final String BBDD = "bbdd";
    
    private final TablePaginator<Mensaxe> paginadorDeTabla;    
    
    /**
     * Creamos un método para asignar eventos que serán de tipo ActionListener e TableModelListener.
     */
    public final void events(){
        view.pageJComboBox.addActionListener(this);
        view.tablaMensaxe.getModel().addTableModelListener(this);
    }
    
    public ControllerMensaxe(MensaxeView view) throws ProjectException{
        
        this.view = view;
                
        managerBbdd = (IDAOManagerBD) DAOManagerFactory.getDAOManager(BBDD);
        model = managerBbdd.getMensaxeDAO();
        
        //Proveedor de datos de Paxinación, permite paxinar registros agregados ao JTable
        IPagination<Mensaxe> proveedorDeDatos = crearProveedorDeDatos();                  
        
        //Obxeto da clase TablePaginator, decora e automatiza o proceso de paxinación.
        paginadorDeTabla = new TablePaginator(this.view.tablaMensaxe, proveedorDeDatos, new int[]{5, 10, 20, 50, 75, 100}, 5);
        
        //Incializamos el proceso de decoración creando un JCombobox el cual mostrara el numero de filas permitidas
        // a mostrar en el JTable
        paginadorDeTabla.createListPermitRows(view.paginationPanel);
        
        //asignamos la información que tiene dicho JComboBox Generado a nuestro JComboBox ya existente en nuestra ventana pricipal.
        view.pageJComboBox = paginadorDeTabla.getComboboxPermitFiles();
       
        events();
        
        //Seleccionamos un item de la lista desplegable.
        view.pageJComboBox.setSelectedItem(Integer.parseInt("5"));
        
    }
        
    /**
     * Metodo en el cual sobreescribiremos los metodos abstractos de la clase ProveedorDeDatosDePaginacion,
     * con el fin de crear un sublista la cual sera visualizada al JTable dependiendo los parametros que nosotros le indiquemos.
     */
    private IPagination<Mensaxe> crearProveedorDeDatos() throws ProjectException {
        //Retornamos un interfaz de tipo ProveedorDeDatosDePaginacion en la cual sobreescribimos sus metodos abtractos
        //1 metodo: obtenemos el numero total de registros agregados al JTable.
        //2 metodo: obtenemos una subLista la cual será mostrada en el JTable, seria nuestra pagina actual.
        return new IPagination<Mensaxe>() {
            @Override
            public Long getTotalRowCount() {
                Long totalRegisteres = null;
                try {
                    totalRegisteres = model.totalRegisteres();
                } catch (ProjectException ex) {
                    Logger.getLogger(ControllerMensaxe.class.getName()).log(Level.SEVERE, null, ex);
                }
                return totalRegisteres;
            }

            @Override
            public List<Mensaxe> getRows(int skip, int limit) {
                List<Mensaxe> mensaxes = new ArrayList<>();
                try {
                    //por consulta a bbdd
                    mensaxes = model.obtenerTodos(skip, limit);
                } catch (ProjectException ex) {
                    Logger.getLogger(ControllerMensaxe.class.getName()).log(Level.SEVERE, null, ex);
                }
                return mensaxes;
            }
        };
    }

    //Agregamos los metodos de tipo ActionListener y TableModelListener
    @Override
    public void actionPerformed(ActionEvent ae) {

        Object evt = ae.getSource();
           
        paginadorDeTabla.eventCombobox(view.pageJComboBox);
        
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        paginadorDeTabla.updatePageButtons();
    }
}
