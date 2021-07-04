/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

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

public class NumeracionXml {
    /** variable que contiene la raiz del documento Xml*/
    private Element root;
    /** variable que contiene la localizacion del archivo xml*/
    private String fileLocation = "src//Archivos//Numeracion.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public NumeracionXml() {
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
 
        private Element NumeraciontoXmlElement(Numeracion nNumero) {
            Element NumeroP = new Element("Numeracion");
            Element EXT = new Element("EXT");
            EXT.setText(Integer.toString(nNumero.getEXT()));
            Element b = new Element("b");
            b.setText(Boolean.toString(nNumero.isB()));
            
    
            NumeroP.addContent(EXT);
            NumeroP.addContent(b);
     
            return NumeroP;
        }
    
    
    private Numeracion NumeracionToObject(Element element) throws ParseException {
        Numeracion nNumero = new Numeracion(Integer.parseInt(element.getChildText("EXT")),Boolean.parseBoolean(element.getChildText("b")));
        return nNumero;
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
            if (dato.equals(e.getChild("EXT").getText())) {
                return e;
            }
        }
        return null;
    }
    
    public static Element buscarLibre(List raiz, boolean dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato == false) {
                return e;
            }
        }
        return null;
    }

// @return valor boleano con la condicion de exito
    public boolean agregarNum(Numeracion nNumero) {
        boolean resultado = false;
        root.addContent(NumeraciontoXmlElement((Numeracion) nNumero));
        resultado = updateDocument();
        return resultado;
    }

    public Numeracion buscarNum(int EXT) {
        Element aux = new Element("Numeracion");
        List Numeracion = this.root.getChildren("Numeracion");
        while (aux != null) {
            aux = NumeracionXml.buscar(Numeracion, Integer.toString(EXT));
            if (aux != null) {
                try {
                    return NumeracionToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public Numeracion buscarLibre(boolean b) {
        Element aux = new Element("Numeracion");
        List Numeracion = this.root.getChildren("Numeracion");
        while (aux != null) {
            aux = NumeracionXml.buscarLibre(Numeracion, b);
            if (aux != null) {
                try {
                    return NumeracionToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
    public boolean actualizarPersona(Numeracion nNumero) {
        boolean resultado = false;
        Element aux = new Element("Numeracion");
        List Numeracion = this.root.getChildren("Numeracion");
        while (aux != null) {
            aux = NumeracionXml.buscar(Numeracion, Integer.toString(nNumero.getEXT()));
            if (aux != null) {
                Numeracion.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarNum(nNumero);
        return resultado;
    }

    public boolean borrarNum(int EXT) {
        boolean resultado = false;
        Element aux = new Element("Numeracion");
        List Numeracion = this.root.getChildren("Numeracion");
        while (aux != null) {
            aux = NumeracionXml.buscar(Numeracion, Integer.toString(EXT));
            if (aux != null) {
                Numeracion.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
  
    
    public ArrayList<Numeracion> todosLosNumeros() {
        ArrayList<Numeracion> resultado = new ArrayList<Numeracion>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                Numeracion item = NumeracionToObject(xmlElem);
                if (item.isB()== false){
                resultado.add(NumeracionToObject(xmlElem));
                }
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }





}