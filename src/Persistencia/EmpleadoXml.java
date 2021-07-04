/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Analogicas;
import Dominio.Empleado;
import Dominio.Numeracion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
/**
 *
 * @author Moisés
 */

public class EmpleadoXml {
    /** variable que contiene la raiz del documento Xml*/
    private Element root;
    /** variable que contiene la localizacion del archivo xml*/
    private String fileLocation = "src//Archivos//Empleado.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public EmpleadoXml() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }
 
        private Element EmpleadotoXmlElement(Empleado nEmpleado) {
            Element EmpleadoP = new Element("Empleado");
            Element EXT = new Element("EXT");
            EXT.setText(Integer.toString(nEmpleado.getEXT()));
            Element b = new Element("b");
            b.setText(Boolean.toString(nEmpleado.isB()));
            Element cedula = new Element("cedula");
            cedula.setText(Integer.toString(nEmpleado.getCedula()));
            Element nombre = new Element("nombre");
            nombre.setText(nEmpleado.getNombre());
            Element cargo = new Element("cargo");
            cargo.setText(nEmpleado.getCargo());
            Element dpto = new Element("dpto");
            dpto.setText(nEmpleado.getDpto());
            
            EmpleadoP.addContent(EXT);
            EmpleadoP.addContent(b);
            EmpleadoP.addContent(cedula);
            EmpleadoP.addContent(nombre);
            EmpleadoP.addContent(cargo);
            EmpleadoP.addContent(dpto);
            
           
            return EmpleadoP;
        }
    
    
    private Empleado EmpleadoToObject(Element element) throws ParseException {
        Empleado nEmpleado = new Empleado(Integer.parseInt(element.getChildText("EXT")),Boolean.parseBoolean(element.getChildText("b")),
        Integer.parseInt(element.getChildText("cedula")),element.getChildText("nombre"),element.getChildText("cargo"),element.getChildText("dpto")
        );
        return nEmpleado;
    }

    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }
/* Operacion que busca un elemento que cumpla con una condicion en el id del xml
     * @param raiz = raiz del documento xml
     * @param dato = elemento a buscar.
     * @return retorna el elemento si existe con la condicion, en caso contrario retorna null */
    public static Element buscar(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("cedula").getText())) {
                return e;
            }
        }
        return null;
    }

// @return valor boleano con la condicion de exito
    public boolean agregarEmp(Empleado nEmpleado) {
        boolean resultado = false;
        root.addContent(EmpleadotoXmlElement((Empleado) nEmpleado));
        resultado = updateDocument();
        return resultado;
    }

    public Empleado buscarEmp(Integer cedula) {
        Element aux = new Element("Empleado");
        List Empleado = this.root.getChildren("Empleado");
        while (aux != null) {
            aux = EmpleadoXml.buscar(Empleado, Integer.toString(cedula));
            if (aux != null) {
                try {
                    return EmpleadoToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
  

    
    public boolean actualizarEmp(Empleado nEmpleado) {
        boolean resultado = false;
        Element aux = new Element("Empleado");
        List Empleado = this.root.getChildren("Empleado");
        while (aux != null) {
            aux = EmpleadoXml.buscar(Empleado, Integer.toString(nEmpleado.getCedula()));
            if (aux != null) {
                Empleado.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarEmp(nEmpleado);
        return resultado;
    }

    public boolean borrarEmp(String cedula) {
        boolean resultado = false;
        Element aux = new Element("Empleado");
        List Empleado = this.root.getChildren("Empleado");
        while (aux != null) {
            aux = EmpleadoXml.buscar(Empleado, cedula);
            if (aux != null) {
                Empleado.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
    
    public ArrayList<Empleado> todosLosUsados() {
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                Empleado item = EmpleadoToObject(xmlElem);
                if (item.getEXT()!= 0){
                resultado.add(EmpleadoToObject(xmlElem));
                }
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
    
    /*public ArrayList<Analogicas> todosLosDeportistas() {
        ArrayList<Analogicas> resultado = new ArrayList<Analogicas>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(AnalogicaToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }*/





}