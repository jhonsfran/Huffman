/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Univalle_F
 */
public class DialogArchive extends javax.swing.JDialog {
    
    private File file = null;
    private String url_file = "";
    private int tipo = 0; //esta variable me permite saber si el archivo que se carga es para comprimir o para descomprimir -> por defecto es 0 = comprimir

    /**
     * Creates new form DialogArchive
     */
    public DialogArchive(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        
        String command = evt.getActionCommand();
        
        if(command.equalsIgnoreCase(javax.swing.JFileChooser.APPROVE_SELECTION)){
            setFile(jFileChooser1.getSelectedFile());
            
            url_file = jFileChooser1.getSelectedFile().getAbsolutePath();
            String filename = jFileChooser1.getSelectedFile().getName();
            url_file = url_file.replace(filename, "");
            
            if(tipo == 1){
                JOptionPane.showMessageDialog(this, "Para descomprimir el archivo debe ingresar en el TextArea las etiquetas con el siguiente formato: Etiqueta-Codigo");
            }
            
            this.setVisible(false);
            
        }else if(command.equalsIgnoreCase(javax.swing.JFileChooser.CANCEL_SELECTION)){
            JOptionPane.showMessageDialog(this, "Selecciona un archivo");
        }else{
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
        }
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jFileChooser1
     */
    public javax.swing.JFileChooser getjFileChooser1() {
        return jFileChooser1;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
    
    public String getUrl() {
        return url_file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }
    
    public void setUrl(String url_file) {
        this.url_file = url_file;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
