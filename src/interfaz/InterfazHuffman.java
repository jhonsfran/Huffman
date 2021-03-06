/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author Univalle_F
 */
public class InterfazHuffman extends javax.swing.JFrame {
    
    private File file = null;
    private String url_file = "";
    
    private File file_comprimido = null;
    private String url_file_comprimido = "";

    /**
     * Creates new form InterfazHuffman
     */
    public InterfazHuffman() {
        initComponents();
        
    }
    
    public File getFile() {
        return file;
    }
    
    public String getUrl() {
        return url_file;
    }
    
    public void setUrl(String url_file) {
        this.url_file = url_file;
    }
    
    
    
    public void asignarEscuchas(ActionListener escucha) {
        
        getBCompress().addActionListener(escucha);
        getBUncompress().addActionListener(escucha);
        getComprimir().addActionListener(escucha);
        getDescomprimir().addActionListener(escucha);
        getGuardar().addActionListener(escucha);
        getCguardar().addActionListener(escucha);

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BCompress = new javax.swing.JButton();
        comprimir = new javax.swing.JButton();
        descomprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BUncompress = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Result = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        Cguardar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("WinZip Huffman");

        jLabel2.setText("Archivo a Comprimir:");

        BCompress.setText("Archivo...");
        BCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCompressActionPerformed(evt);
            }
        });

        comprimir.setText("Comprimir");

        descomprimir.setText("Descomprimir");

        jLabel3.setText("Archivo a Descomprimir:");

        BUncompress.setText("Archivo...");
        BUncompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUncompressActionPerformed(evt);
            }
        });

        Result.setColumns(20);
        Result.setRows(5);
        jScrollPane1.setViewportView(Result);

        jLabel4.setText("Resultado:");

        guardar.setText("Guardar");

        Cguardar.setText("Guardar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comprimir)
                                .addGap(18, 18, 18)
                                .addComponent(guardar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BCompress)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BUncompress))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Cguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descomprimir))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(BUncompress)
                    .addComponent(jLabel2)
                    .addComponent(BCompress))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprimir)
                    .addComponent(descomprimir)
                    .addComponent(guardar)
                    .addComponent(Cguardar)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCompressActionPerformed
        // TODO add your handling code here:
        DialogArchive mi_dialog = new DialogArchive(this, true);
        mi_dialog.setVisible(true);
        setFile(mi_dialog.getFile());
        setUrl(mi_dialog.getUrl());
    }//GEN-LAST:event_BCompressActionPerformed

    private void BUncompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUncompressActionPerformed
        // TODO add your handling code here:
        DialogArchive mi_dialog_descomprimir = new DialogArchive(this, true);
        mi_dialog_descomprimir.setTipo(1);
        mi_dialog_descomprimir.setVisible(true);
        setFile_comprimido(mi_dialog_descomprimir.getFile());
        setUrl_file_comprimido(mi_dialog_descomprimir.getUrl());
    }//GEN-LAST:event_BUncompressActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCompress;
    private javax.swing.JButton BUncompress;
    private javax.swing.JButton Cguardar;
    private javax.swing.JTextArea Result;
    private javax.swing.JButton comprimir;
    private javax.swing.JButton descomprimir;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the BCompress
     */
    public javax.swing.JButton getBCompress() {
        return BCompress;
    }

    /**
     * @return the BUncompress
     */
    public javax.swing.JButton getBUncompress() {
        return BUncompress;
    }

    /**
     * @return the Result
     */
    public javax.swing.JTextArea getResult() {
        return Result;
    }

    /**
     * @param Result the Result to set
     */
    public void setResult(javax.swing.JTextArea Result) {
        this.Result = Result;
    }

    /**
     * @return the comprimir
     */
    public javax.swing.JButton getComprimir() {
        return comprimir;
    }

    /**
     * @return the descomprimir
     */
    public javax.swing.JButton getDescomprimir() {
        return descomprimir;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the guardar
     */
    public javax.swing.JButton getGuardar() {
        return guardar;
    }

    /**
     * @return the file_comprimido
     */
    public File getFile_comprimido() {
        return file_comprimido;
    }

    /**
     * @return the url_file_comprimido
     */
    public String getUrl_file_comprimido() {
        return url_file_comprimido;
    }

    /**
     * @param file_comprimido the file_comprimido to set
     */
    public void setFile_comprimido(File file_comprimido) {
        this.file_comprimido = file_comprimido;
    }

    /**
     * @param url_file_comprimido the url_file_comprimido to set
     */
    public void setUrl_file_comprimido(String url_file_comprimido) {
        this.url_file_comprimido = url_file_comprimido;
    }

    /**
     * @return the Cguardar
     */
    public javax.swing.JButton getCguardar() {
        return Cguardar;
    }

    /**
     * @param Cguardar the Cguardar to set
     */
    public void setCguardar(javax.swing.JButton Cguardar) {
        this.Cguardar = Cguardar;
    }
}
