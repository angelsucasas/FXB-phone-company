package Controles;

import Dominio.Analogicas;
import Dominio.Empleado;
import Dominio.Numeracion;
import Frame.Home;
import Persistencia.AnalogicasXml;
import Persistencia.EmpleadoXml;
import Persistencia.LoginXml;
import Persistencia.NumeracionXml;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB_A654
 */
public class Controlador {
    
    private Font fuenteBold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER, 10, Font.ITALIC);
    
    private NumeracionXml numeracionXml = new NumeracionXml();

    public Controlador() {
    
    }
    
    // AgregarA.java
    public Integer categoria(JComboBox txtCategoria){

        int num = txtCategoria.getSelectedIndex();
        int i=0;

        if (num == 0) {
          i = 0;
        }
        if (num == 1) {
          i = 1;
        }

        if (num == 2) {
          i = 2;
        }

        if (num == 3) {
          i = 3;
        } 
        if (num == 4) {
          i = 4;
        } 
        return i;
    }
    
    public void modificarDato(EmpleadoXml emp,int EXT,int ci){
        Empleado e = emp.buscarEmp(ci);
        e.setEXT(EXT);
        emp.actualizarEmp(e);
    }
   
   // Generador.java
   public Paragraph getHeader(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }
    
    public Paragraph getInfo(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }
    
    public Paragraph getFooter(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteItalic);
        p.add(c);
        return p;
    }
   
    // ListadoA.java
    public void llenarTabla(AnalogicasXml num, JTable tablaNumeracion) {

        String[] columna = { "EXT", "Disponibilidad","Nombre","Categoria","Desvio","Date"};
            DefaultTableModel dtm = new DefaultTableModel(null,columna);
            ArrayList<Analogicas> Lista= num.todosLosUsados();
            for (Analogicas n : Lista)
            {
                String[] row = {Integer.toString(n.getEXT()),"En Uso",n.getNombre(),Integer.toString(n.getCategoria()),Integer.toString(n.getDesvio()),n.getDate()
                
                };
                
                dtm.addRow(row);
            }
            tablaNumeracion.setModel(dtm);
            
    }
    
    // ListadoE.java
    public void llenarTabla(NumeracionXml num, JTable tablaNumeracion){

        String[] columna = { "Numeración", "Disponibilidad"};
            DefaultTableModel dtm = new DefaultTableModel(null,columna);
            ArrayList<Numeracion> Lista= num.todosLosNumeros();
            for (Numeracion n : Lista)
            {
                String[] row = {Integer.toString(n.getEXT()), "Disponible"
                
                };
                
                dtm.addRow(row);
            }
            tablaNumeracion.setModel(dtm);
            
    }
    
    // Login.java
    public boolean validarLogin(JFrame ventana, JTextField txtUsuario, JPasswordField txtPass) {
        LoginXml log = new LoginXml();
        String p = String.valueOf(txtPass.getPassword());
        boolean b = log.Validar(txtUsuario.getText(),p );
        //if (b == true){
            Home v1 = new Home();
            v1.setVisible(true);
            ventana.dispose();
        //}
        return b;
    }
    
    // Validaciones.
    
    public boolean campoEsValido(String textoValidar, String caso, String nombreCampo) throws Exception {
        
        if(textoValidar.isEmpty()) {
            throw new NullPointerException("Texto está vacío. ");
        }
        
        String REG_EXP = null;
        
        switch(caso) {
            case "EXT":
                REG_EXP = "[0-9]{4}";
                break;
            case "TEXTO":
                REG_EXP = "[a-zA-Z]+";
                textoValidar = textoValidar.replaceAll(" ", "");
                break;
            case "CEDULA":
                REG_EXP = "[0-9]{7,8}";
                break;
            default:
                int dialog = JOptionPane.DEFAULT_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Caso no válido.", "Error",dialog);
                throw new IllegalArgumentException("Caso " + caso + " no válido. ");
        }
        
        if(!Pattern.matches(REG_EXP, textoValidar)) {
            int dialog = JOptionPane.DEFAULT_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Campo Inválido.", "Error", dialog);
            throw new Exception("Campo " + nombreCampo + " Inválido. ");
        }
        
        return true;
        
    }
    
    public boolean numeracionExtValida(String extCampo) {
        
        if(extCampo.isEmpty()) {
            throw new IllegalArgumentException("extCampo es nulo. ");
        }
                
        return (numeracionXml.buscarNum(Integer.parseInt(extCampo)) != null);
        
    }
    
}
