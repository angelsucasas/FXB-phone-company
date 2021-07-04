/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Dominio.Captura;
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

public class CapturaXml {
    /** variable que contiene la raiz del documento Xml*/
    private Element root;
    /** variable que contiene la localizacion del archivo xml*/
    private String fileLocation = "src//Archivos//Captura.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public CapturaXml() {
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
 
        private Element CapturatoXmlElement(Captura nCaptura) {
            Element CapturaP = new Element("Captura");
            Element nombre = new Element("nombre");
            nombre.setText(nCaptura.getNombre());
            Element lider = new Element("lider");
            lider.setText(nCaptura.getLider());
            Element EXT1 = new Element("EXT1");
            EXT1.setText(Integer.toString(nCaptura.getEXT1()));
            Element EXT2 = new Element("EXT2");
            EXT2.setText(Integer.toString(nCaptura.getEXT2()));
            Element EXT3 = new Element("EXT3");
            EXT3.setText(Integer.toString(nCaptura.getEXT3()));
            Element EXT4 = new Element("EXT4");
            EXT4.setText(Integer.toString(nCaptura.getEXT4()));
            
    
            CapturaP.addContent(nombre);
            CapturaP.addContent(lider);
            CapturaP.addContent(EXT1);
            CapturaP.addContent(EXT2);
            CapturaP.addContent(EXT3);
            CapturaP.addContent(EXT4);
     
            return CapturaP;
        }
    
    
    private Captura CapturaToObject(Element element) throws ParseException {
        Captura nCaptura = new Captura(element.getChildText("nombre"),element.getChildText("lider"),Integer.parseInt(element.getChildText("EXT1")),Integer.parseInt(element.getChildText("EXT2")),Integer.parseInt(element.getChildText("EXT3")),Integer.parseInt(element.getChildText("EXT4")));
        return nCaptura;
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
            if (dato.equals(e.getChild("EXT1").getText())) {
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
    public boolean agregarCap(Captura nCaptura) {
        boolean resultado = false;
        root.addContent(CapturatoXmlElement((Captura) nCaptura));
        resultado = updateDocument();
        return resultado;
    }

    public Captura buscarCap(int EXT1) {
        Element aux = new Element("Captura");
        List Captura = this.root.getChildren("Captura");
        while (aux != null) {
            aux = CapturaXml.buscar(Captura, Integer.toString(EXT1));
            if (aux != null) {
                try {
                    return CapturaToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public Captura buscarLibre(boolean b) {
        Element aux = new Element("Captura");
        List Captura = this.root.getChildren("Captura");
        while (aux != null) {
            aux = CapturaXml.buscarLibre(Captura, b);
            if (aux != null) {
                try {
                    return CapturaToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
    public boolean actualizarCaptura(Captura nCaptura) {
        boolean resultado = false;
        Element aux = new Element("Captura");
        List Captura = this.root.getChildren("Captura");
        while (aux != null) {
            aux = CapturaXml.buscar(Captura, Integer.toString(nCaptura.getEXT1()));
            if (aux != null) {
                Captura.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarCap(nCaptura);
        return resultado;
    }

    public boolean borrarCap(int EXT1) {
        boolean resultado = false;
        Element aux = new Element("Captura");
        List Captura = this.root.getChildren("Captura");
        while (aux != null) {
            aux = CapturaXml.buscar(Captura, Integer.toString(EXT1));
            if (aux != null) {
                Captura.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
  
    
    public ArrayList<Captura> todosLasCaptura() {
        ArrayList<Captura> resultado = new ArrayList<Captura>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                Captura item = CapturaToObject(xmlElem);
                if (item.getEXT1()!=0){
                resultado.add(CapturaToObject(xmlElem));
                }
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }





}