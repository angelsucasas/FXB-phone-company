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
public class Captura {
    protected String nombre;
    protected String lider;
    protected int EXT1;
    protected int EXT2;
    protected int EXT3;
    protected int EXT4;

    public Captura(String nombre, String lider, int EXT1, int EXT2, int EXT3, int EXT4) {
        this.nombre = nombre;
        this.lider = lider;
        this.EXT1 = EXT1;
        this.EXT2 = EXT2;
        this.EXT3 = EXT3;
        this.EXT4 = EXT4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public int getEXT1() {
        return EXT1;
    }

    public void setEXT1(int EXT1) {
        this.EXT1 = EXT1;
    }

    public int getEXT2() {
        return EXT2;
    }

    public void setEXT2(int EXT2) {
        this.EXT2 = EXT2;
    }

    public int getEXT3() {
        return EXT3;
    }

    public void setEXT3(int EXT3) {
        this.EXT3 = EXT3;
    }

    public int getEXT4() {
        return EXT4;
    }

    public void setEXT4(int EXT4) {
        this.EXT4 = EXT4;
    }
    
}

