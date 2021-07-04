/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Moisés
 */
public class Numeracion {
    private int EXT;
    private boolean b = false;

    public Numeracion(int EXT, boolean b) {
        this.EXT = EXT;
        this.b = b;
    }

    /**
     * @return the EXT
     */
    public int getEXT() {
        return EXT;
    }

    /**
     * @param EXT the EXT to set
     */
    public void setEXT(int EXT) {
        this.EXT = EXT;
    }

    /**
     * @return the b
     */
    public boolean isB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(boolean b) {
        this.b = b;
    }
}

