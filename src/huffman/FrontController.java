/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import Utils.Arbol;
import Utils.NodoArbol;
import Utils.OrdenarPorFrecuencia;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import huffman.archive.Archivo;
import interfaz.InterfazHuffman;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Univalle_F
 */
public class FrontController implements ActionListener{
    
    InterfazHuffman interfaz;
    Archivo mi_archivo;
    Archivo mi_archivo_codificado;
    Arbol mi_arbolito;
        
    public FrontController (){
        interfaz = new InterfazHuffman();
        interfaz.asignarEscuchas(this);
        interfaz.setVisible(true);
    }  
    
    public TreeSet creaListaOrdenada(String mensaje){
        
        TreeSet NodosOrdenados = new TreeSet(new OrdenarPorFrecuencia());//implementamos OrdenarPorFrecuencia() que es una instancia de una clase que implementa a su vez la interface Comparator
        //Esto nos permite crear un criterio de comparación en la insersión

        int index = 0;
        
        while (mensaje.length() != 0) {

            index = mensaje.length() - 1;
            NodosOrdenados.add(new NodoArbol("" + mensaje.charAt(index), mensaje.length() - mensaje.replace("" + mensaje.charAt(index), "").length()));
            mensaje = mensaje.replace("" + mensaje.charAt(index), "");

        }
        
        return NodosOrdenados;
    }
    
    public void mostrarListaNodos(TreeSet NodosOrdenados){
    
        System.out.println(" Lista ordenada con " + NodosOrdenados.size() + " nodos");

        for (Iterator it = NodosOrdenados.iterator(); it.hasNext();) {
            NodoArbol mi_nodo = (NodoArbol) it.next();
            System.out.print(mi_nodo.getDato() + " -> ");
            System.out.println(mi_nodo.getFrecuencia());
        }
    }
    
    private String buscarCod(NodoArbol n, String dato) {
        
        String codigo = "";
        
        if (n != null) {
            if (n.getDato().contains(dato)) {
                
                //recorremos el arbol de forma recursiva en preorden
                return codigo = n.getValor_rama() + buscarCod((NodoArbol) n.getIzq(), dato) + buscarCod((NodoArbol) n.getDer(), dato);
                
            }
            return "";
        }
        
        return "";
    }
    
    private String mostrarTablaCod() {
        
        String tabla = "*********** Tabla de Huffman ******************\n";

        String raiz = mi_arbolito.getRaiz().getDato();//el valor de la raiz nos permite encontrar el caracter que estamos buscando facilmente
        String[] codigos = new String[raiz.length()];

        for (int i = 0; i < raiz.length(); i++) {
            codigos[i] = this.buscarCod(mi_arbolito.getRaiz(), "" + raiz.charAt(i));
            //System.out.println(raiz.charAt(i) + " " + codigos[i]);
            
            tabla += raiz.charAt(i) + "-" + codigos[i] + "\n";
        }
        
        tabla += "******************* fin *************************\n\n";
                
        return tabla;
    }
    
    
    private String comprimir(String mensaje) {
        
        String compress = "*********** Mensaje comprimido ******************\n";

        for (int i = 0; i < mensaje.length(); i++) {
            
            compress += buscarCod(mi_arbolito.getRaiz(), "" + mensaje.charAt(i)) + "\n";
            
        }
        
        compress += "******************* fin *************************\n\n";
                
        return compress;
    }
    
    //el algoritmo mas costoso del universo
    private String descomprimir(String mensaje, String[] codificacion) {
        
        String mensaje_decodificado = "";
       
        String tmp = "";
        String[] clave_tmp; 
        
        for(int i=0; i < mensaje.length(); i++){
            
            tmp += "" + mensaje.charAt(i);
            
            for(int j=0; j < codificacion.length; j++){
                
                clave_tmp = codificacion[j].split("-");

                if (tmp.equalsIgnoreCase(clave_tmp[1])) {
                    
                    mensaje_decodificado += clave_tmp[0];
                    mensaje = mensaje.substring(i, mensaje.length());
                    tmp = "";
                    i = 0;

                }

            }
            
        }
            
        return mensaje_decodificado;       
        
    }

    
    private String guardar(String mensaje) {
        
        String compress = "";

        for (int i = 0; i < mensaje.length(); i++) {
            
            compress += buscarCod(mi_arbolito.getRaiz(), "" + mensaje.charAt(i));
            
        }
  
        return compress;
    }
    
    public TreeSet aplicaHuffman(TreeSet NodosOrdenados){
    
        while (NodosOrdenados.size() != 1) {//paramos cuando sólo quede un nodo en la colección

            NodoArbol nodo_tmp1 = (NodoArbol) NodosOrdenados.first();// lo casteamos porque estamos implementando comparator
            NodosOrdenados.pollFirst();//borramos el primer elemento de la lista
            NodoArbol nodo_tmp2 = (NodoArbol) NodosOrdenados.first();//sacamos el segundo elemento de la lista
            NodosOrdenados.pollFirst();//borramos el segundo elemento de la lista

            nodo_tmp1.setValor_rama("0");//al primer nodo le asignamos el valor de rama 0
            nodo_tmp2.setValor_rama("1");//al segundo nodo le asignamos el valor de rama 1

            NodoArbol nodo_tmp3 = new NodoArbol(nodo_tmp1.getDato() + nodo_tmp2.getDato(), nodo_tmp1.getFrecuencia() + nodo_tmp2.getFrecuencia());// se crea un nuevo nodo y se suman los
            //datos de frecuencia y el dato se pasa como la unión de los 
            nodo_tmp3.setIzq(nodo_tmp1);//hijo del nuevo nodo
            nodo_tmp3.setDer(nodo_tmp2);//hijo derecho

            NodosOrdenados.add(nodo_tmp3);//la lista nos compara la nueva frecuencia y ordena los elementos

        }
        
        
        return NodosOrdenados;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                
        if (e.getSource() == interfaz.getComprimir()) {
            
            //se trae el archivo y lo primero es convertirlo en un String
            mi_archivo = new Archivo(interfaz.getFile(), interfaz.getUrl());
            
            if(mi_archivo.getArchive() != null){

                //creamos una colección ordenada de nodos por frecuencia
                TreeSet NodosOrdenados = creaListaOrdenada(mi_archivo.getTexto());

            //se muestra la lista
                //mostrarListaNodos(NodosOrdenados);
                NodosOrdenados = aplicaHuffman(NodosOrdenados);//se aplica el algoritmo de huffman -> al final tenemos un nodo enlazado con los demas nodos
                NodoArbol nodo_raiz = (NodoArbol) aplicaHuffman(NodosOrdenados).first();//creamos el arbol con el nodo raiz
                mi_arbolito = new Arbol(nodo_raiz);
                mi_arbolito.AgregarHojas(nodo_raiz.getIzq(), nodo_raiz.getDer());

            //System.out.print(comprimir(mi_archivo.getTexto()));
                //interfaz.getResult().setText(mostrarTablaCod() + comprimir(mi_archivo.getTexto()));//seteamos el text area para ver el resultado
                interfaz.getResult().setText(mostrarTablaCod());//seteamos el text area para ver el resultado
                
            }else{
            
                JOptionPane.showMessageDialog(null, "Acción no válida, debe cargar un archivo");
                
            }

        }
        
        
        //guardamos el archivo
        if (e.getSource() == interfaz.getGuardar()) {
            
            if (mi_arbolito != null) {

                mi_archivo.guardarArchivo(guardar(mi_archivo.getTexto()));
                
            } else {

                JOptionPane.showMessageDialog(null, "Acción no válida, debe crear el árbol");

            }
            
        }
        
        
        if (e.getSource() == interfaz.getDescomprimir()) {
            
                //se trae el archivo y lo primero es convertirlo en un String
                mi_archivo_codificado = new Archivo(interfaz.getFile_comprimido(), interfaz.getUrl_file_comprimido(),1);// la url me sirve para saber donde guardar el archivo

                if (mi_archivo_codificado.getArchive() != null) {
                    
                    if(!interfaz.getResult().getText().equals("")){
                        
                        String tabla_codificacion = interfaz.getResult().getText();
                        String[] lineas = tabla_codificacion.split("\n");
                        
                        //System.out.print(descomprimir(mi_archivo_codificado.getTexto(), lineas));
                        String texto = descomprimir(mi_archivo_codificado.getTexto(), lineas);

                        mi_archivo_codificado.guardarArchivo(texto);//guardamos el texto

                    }else{
                        JOptionPane.showMessageDialog(null, "Acción no válida, debe ingresar los datos de las etiquetas en el JtextArea: Etiqueta-Codigo"); 
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Acción no válida, debe cargar el archivo a descodificar");

                }

        }
        
        
        
        
    }
    
}
