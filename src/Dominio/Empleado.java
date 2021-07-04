/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Usuario
 */
public class Empleado extends Numeracion {

    protected int cedula;
    protected String nombre;
    protected String cargo;
    protected String dpto;
    

    public Empleado(int EXT,boolean b,int cedula, String nombre, String cargo,String dpto) {
        super (EXT,b);
        this.cedula = cedula;
        this.nombre = nombre;
        this.cargo = cargo;
        this.dpto = dpto;
    }
   

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

}
