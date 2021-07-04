/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.util.ArrayList;
/**
 *
 * @author Moisés
 */
public class Analogicas extends Numeracion {
    private String nombre;
    private int categoria;
    private int desvio;
    private String date;
    

    public Analogicas(int EXT, boolean b,String nombre,int categoria,int desvio,String date) {
        super(EXT, b);
        this.nombre = nombre;
        this.categoria = categoria;
        this.desvio = desvio;
        this.date = date;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the desvio
     */
    public int getDesvio() {
        return desvio;
    }

    /**
     * @param desvio the desvio to set
     */
    public void setDesvio(int desvio) {
        this.desvio = desvio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}