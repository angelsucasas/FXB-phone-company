/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Login;
import Dominio.Numeracion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
/**
 *
 * @author Moisés
 */

public class LoginXml {
    /** variable que contiene la raiz del documento Xml*/
    private Element root;
    /** variable que contiene la localizacion del archivo xml*/
    private String fileLocation = "src//Archivos//Login.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public LoginXml() {
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
 
        private Element LogintoXmlElement(Login nLogin) {
            Element LoginP = new Element("Login");
            Element usuario = new Element("usuario");
            usuario.setText(nLogin.getUsuario());
            Element pass = new Element("pass");
            pass.setText(nLogin.getPass());
            
    
            LoginP.addContent(usuario);
            LoginP.addContent(pass);
     
            return LoginP;
        }
    
    
    private Login LoginToObject(Element element) throws ParseException {
        Login nLogin = new Login(element.getChildText("usuario"),element.getChildText("pass"));
        return nLogin;
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
            if (dato.equals(e.getChild("usuario").getText())) {
                return e;
            }
        }
        return null;
    }
    
    public static Element buscarLog(List raiz, String usuario, String pass) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (usuario.equals(e.getChild("usuario").getText())) {
                if (pass.equals(e.getChild("pass").getText())){
                return e;
                }
                else JOptionPane.showMessageDialog(null, "Error: Contraseña Invalida", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
            }
            else 
                JOptionPane.showMessageDialog(null, "Error: Usuario invalido", "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }    

// @return valor boleano con la condicion de exito
    public boolean agregarLogin(Login nLogin) {
        boolean resultado = false;
        root.addContent(LogintoXmlElement((Login) nLogin));
        resultado = updateDocument();
        return resultado;
    }
    public Boolean Validar(String usuario,String pass) {
        Element aux = new Element("Login");
        List Login = this.root.getChildren("Login");
        while (aux != null) {
            aux = LoginXml.buscarLog(Login, usuario,pass);
            if (aux != null) {
                return true;
            }
            else 
                return false;
        }
        return null;
    }
    public Login buscarLogin(String usuario) {
        Element aux = new Element("Login");
        List Login = this.root.getChildren("Login");
        while (aux != null) {
            aux = LoginXml.buscar(Login, usuario);
            if (aux != null) {
                try {
                    return LoginToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    
    public boolean actualizarLogin(Login nLogin) {
        boolean resultado = false;
        Element aux = new Element("Login");
        List Login = this.root.getChildren("Login");
        while (aux != null) {
            aux = LoginXml.buscar(Login, nLogin.getUsuario());
            if (aux != null) {
                Login.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarLogin(nLogin);
        return resultado;
    }

    public boolean borrarLogin(String usuario) {
        boolean resultado = false;
        Element aux = new Element("Login");
        List Login = this.root.getChildren("Login");
        while (aux != null) {
            aux = LoginXml.buscar(Login, usuario);
            if (aux != null) {
                Login.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
  
    
    /*public ArrayList<Numeracion> todosLosNumeros() {
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
*/




}