/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.archive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import javax.swing.JOptionPane;

/**
 *
 * @author Univalle_F
 */
public class Archivo {
    
    private File archive = null;
    private String texto = "";
    private String url_file = "";
    private int tipo = 0;
    
    
    public Archivo(File archive, String url_file) {
        this.archive = archive;
        this.url_file = url_file;
        abrirArchivo();
    }
    
    
    public Archivo(File archive,String url_file,int tipo){
        this.archive = archive;
        this.url_file = url_file;
        this.tipo = tipo;
        abrirArchivo();
    }
    
    private void abrirArchivo() {
        String aux = " ";
        try {

            if (getArchive() != null) {
                FileReader archivos = new FileReader(getArchive());
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    
                    aux = aux.toUpperCase();
                    setTexto(getTexto() + aux);
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void guardarArchivo(String archiveComprimido) {
        try {
            
            String nombreArchivo = "comprimido";
            
            if(tipo == 1){
                nombreArchivo = "descomprimido"; 
            }

            if (archiveComprimido != null) {
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(url_file + nombreArchivo + ".txt");
                save.write(archiveComprimido);
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se ha guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            
            
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * @return the archive
     */
    public File getArchive() {
        return archive;
    }

    /**
     * @param archive the archive to set
     */
    public void setArchive(File archive) {
        this.archive = archive;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
}
