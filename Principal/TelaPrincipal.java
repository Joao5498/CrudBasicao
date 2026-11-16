package Principal;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());
    
    private final JDesktopPane desktop = new JDesktopPane(); 
    
    public TelaPrincipal() {
        initComponents();
        this.setContentPane(desktop);               
    }
    
    private void createFrame(JInternalFrame frame){
        frame.setVisible(true);
        desktop.add(frame);
        try{
            frame.setSelected(true);            
        }catch(PropertyVetoException e){
            
        }
    }        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jm_menu = new javax.swing.JMenuBar();
        jm_produtos = new javax.swing.JMenu();
        jmi_produtos = new javax.swing.JMenuItem();
        jmi_banco = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmi_tabela = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jm_produtos.setText("Podutos");

        jmi_produtos.setText("Produtos");
        jmi_produtos.addActionListener(this::jmi_produtosActionPerformed);
        jm_produtos.add(jmi_produtos);

        jm_menu.add(jm_produtos);

        jmi_banco.setText("Banco");

        jMenuItem1.setText("Criar DB");
        jmi_banco.add(jMenuItem1);

        jmi_tabela.setText("Criar Tabela");
        jmi_banco.add(jmi_tabela);

        jm_menu.add(jmi_banco);

        setJMenuBar(jm_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_produtosActionPerformed
        createFrame(new TelaProdutos());
    }//GEN-LAST:event_jmi_produtosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuBar jm_menu;
    private javax.swing.JMenu jm_produtos;
    private javax.swing.JMenu jmi_banco;
    private javax.swing.JMenuItem jmi_produtos;
    private javax.swing.JMenuItem jmi_tabela;
    // End of variables declaration//GEN-END:variables
}
