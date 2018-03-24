/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activos.Model;

import Activos.Entidades.Activos;
import Activos.Entidades.Categoria;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jas Pal
 */
public class ActivosModel extends Observable {

    Activos current;
    ComboBoxModel<Categoria> categorias;
    int edad = 0;
    float depreciacion = 0;
    float valorActual = 0;
    HashMap<String, String> errores;
    String mensaje;
    private static int anioActual = 2017;
    int modo;

    public ActivosModel() {
    }

    public int Edad() {
        edad = anioActual - current.getFabricacion();
        return edad;
    }

    public float Depreciacion() {
        float ayuda=current.getCategoria().getVidaUtil();
        float indice = edad*1/ayuda;
        //indice = indice * edad;
        depreciacion = indice*current.getValor();
        return depreciacion;
    }

    public float ValorActual() {
        valorActual = current.getValor() - depreciacion*edad;
        return valorActual;
    }

    public ActivosModel(Activos current, ComboBoxModel<Categoria> categorias, int modo) {
        this.current = current;
        this.categorias = categorias;
        this.modo = modo;
    }

    public void init(Categoria[] Categorias) {
        setCategorias(Categorias);
        setCurrent(new Activos());
        clearErrors();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public void clearErrors() {
        setErrores(new HashMap<String, String>());
        setMensaje("");

    }

    public void setCurrent(Activos current) {
        this.current = current;
        setChanged();
        notifyObservers();
    }

    public void setCategorias(Categoria[] Categorias) {
        this.categorias = new DefaultComboBoxModel(Categorias);
        setChanged();
        notifyObservers();
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Activos getCurrent() {
        return current;
    }

    public ComboBoxModel<Categoria> getCategorias() {
        return categorias;
    }

    public int getModo() {
        return modo;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

}
