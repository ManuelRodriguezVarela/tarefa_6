package gal.san.clemente.tarefa6_acceso_datos.view;

import gal.san.clemente.tarefa6_acceso_datos.controller.ControllerMensaxe;
import gal.san.clemente.tarefa6_acceso_datos.controller.utils.ModelTable;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Mensaxe;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.TableModel;

public class MensaxeView extends JFrame {

    /**
     * Creamos unha lista desplegable(JComboBox) de tipo enteiro para listar o número de filas que se visualizaran na JTable.
     */    
    public JComboBox<Integer> pageJComboBox;

    private final ControllerMensaxe controlador;
    
    /**
     * Creamos o constructor da clase, na que se incializa o controlador de mensaxes y 
     * asignamos un modelo de tabla de tipo ModeloDeTabla ao JTable.
     */
    public MensaxeView() throws ProjectException {
        initComponents();
        tablaMensaxe.setModel(crearModeloDeTabla());
        controlador = new ControllerMensaxe(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        barraDesplazamiento = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        panelConsulta = new javax.swing.JPanel();
        panelListadoBusqueda = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tableSroll = new javax.swing.JScrollPane();
        tablaMensaxe = new javax.swing.JTable();
        paginationPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelConsulta.setBackground(new java.awt.Color(255, 255, 255));
        panelConsulta.setLayout(new java.awt.GridBagLayout());

        panelListadoBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Resultados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        panelListadoBusqueda.setPreferredSize(new java.awt.Dimension(800, 470));
        panelListadoBusqueda.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Listado as mensaxes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        panelListadoBusqueda.add(jLabel7, gridBagConstraints);
        jLabel7.getAccessibleContext().setAccessibleName("Todas as mensaxes");

        tableSroll.setPreferredSize(new java.awt.Dimension(683, 280));

        tablaMensaxe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSroll.setViewportView(tablaMensaxe);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        panelListadoBusqueda.add(tableSroll, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 50);
        panelListadoBusqueda.add(paginationPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 30, 10);
        panelConsulta.add(panelListadoBusqueda, gridBagConstraints);

        panelPrincipal.add(panelConsulta, java.awt.BorderLayout.PAGE_START);

        barraDesplazamiento.setViewportView(panelPrincipal);

        getContentPane().add(barraDesplazamiento, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane barraDesplazamiento;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel paginationPanel;
    public javax.swing.JPanel panelConsulta;
    public javax.swing.JPanel panelListadoBusqueda;
    private javax.swing.JPanel panelPrincipal;
    public javax.swing.JTable tablaMensaxe;
    public javax.swing.JScrollPane tableSroll;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo no que devolvemos o noso Modelo De Tábaoa, creamos unha instancia da clase ModelTable.java
     * e sobrescribimos os métodos abstractos.
    */
    private TableModel crearModeloDeTabla() {
        
        return new ModelTable<Mensaxe>() {            
            @Override
            public Object getValueAt(Mensaxe mensaxe, int columnas) {
                switch (columnas){                   
                    case 0:
                        return mensaxe.getText();
                    case 1:
                        return mensaxe.getDate();
                    case 2:
                        //return mensaxe.getUsuario().getNome();
                    case 3:
                        return mensaxe.getHashtags();
                }
                return null;
            }

            @Override
            public String getColumnName(int columnas) {
                switch (columnas) {
                    case 0:
                        return "Texto";
                    case 1:
                        return "Data";
                    case 2:
                        return "Autor";
                    case 3:
                        return "Hashtags";
                }
                return null;                
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

        }; 
    
    }
}
