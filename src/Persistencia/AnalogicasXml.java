/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Analogicas;
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

public class AnalogicasXml {
    /** variable que contiene la raiz del documento Xml*/
    private Element root;
    /** variable que contiene la localizacion del archivo xml*/
    private String fileLocation = "src//Archivos//Analogicas.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public AnalogicasXml() {
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
 
        private Element AnalogicatoXmlElement(Analogicas nAnalogica) {
            Element AnalogicaP = new Element("Analogicas");
            Element EXT = new Element("EXT");
            EXT.setText(Integer.toString(nAnalogica.getEXT()));
            Element b = new Element("b");
            b.setText(Boolean.toString(nAnalogica.isB()));
            Element nombre = new Element("nombre");
            nombre.setText(nAnalogica.getNombre());
            Element categoria = new Element("categoria");
            categoria.setText(Integer.toString(nAnalogica.getCategoria()));
            Element desvio = new Element("desvio");
            desvio.setText(Integer.toString(nAnalogica.getDesvio()));
            Element date = new Element("date");
            date.setText(nAnalogica.getDate());
            
            
            
            AnalogicaP.addContent(EXT);
            AnalogicaP.addContent(b);
            AnalogicaP.addContent(nombre);
            AnalogicaP.addContent(categoria);
            AnalogicaP.addContent(desvio);
            AnalogicaP.addContent(date);
            
           
            return AnalogicaP;
        }
    
    
    private Analogicas AnalogicaToObject(Element element) throws ParseException {
        Analogicas nAnalogica = new Analogicas(Integer.parseInt(element.getChildText("EXT")),Boolean.parseBoolean(element.getChildText("b")),
        element.getChildText("nombre"),  Integer.parseInt(element.getChildText("categoria")),Integer.parseInt(element.getChildText("desvio")),
        element.getChildText("date")
        );
        return nAnalogica;
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
    public static Element buscar(List raiz, int dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato == Integer.parseInt(e.getChild("EXT").getText())) {
                return e;
            }
        }
        return null;
    }

// @return valor boleano con la condicion de exito
    public boolean agregarAna(Numeracion nAnalogica) {
        boolean resultado = false;
        root.addContent(AnalogicatoXmlElement((Analogicas) nAnalogica));
        resultado = updateDocument();
        return resultado;
    }

    public Analogicas buscarAna(Integer EXT) {
        Element aux = new Element("Analogicas");
        List Analogicas = this.root.getChildren("Analogicas");
        while (aux != null) {
            aux = AnalogicasXml.buscar(Analogicas, EXT);
            if (aux != null) {
                try {
                    return AnalogicaToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public boolean actualizarAna(Numeracion nAnalogica) {
        boolean resultado = false;
        Element aux = new Element("Analogicas");
        List Analogica = this.root.getChildren("Analogicas");
        while (aux != null) {
            aux = AnalogicasXml.buscar(Analogica, nAnalogica.getEXT());
            if (aux != null) {
                Analogica.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarAna(nAnalogica);
        return resultado;
    }

    public boolean borrarAna(int EXT) {
        boolean resultado = false;
        Element aux = new Element("Analogicas");
        List Analogica = this.root.getChildren("Analogicas");
        while (aux != null) {
            aux = AnalogicasXml.buscar(Analogica, EXT);
            if (aux != null) {
                Analogica.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
    
    public ArrayList<Analogicas> todosLosUsados() {
        ArrayList<Analogicas> resultado = new ArrayList<Analogicas>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                Numeracion item = AnalogicaToObject(xmlElem);
                if (item.isB()== true){
                resultado.add(AnalogicaToObject(xmlElem));
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