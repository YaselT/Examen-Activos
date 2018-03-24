/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activos.Entidades;

/**
 *
 * @author Jas Pal
 */
public class Activos {
    String codigo;
    String nombre;
    int fabricacion;
    int valor;
    Categoria categoria;

    public Activos() {
        this.codigo = "";
        this.nombre = "";
        this.fabricacion = 0;
        this.valor = 0;
        this.categoria = new Categoria();
    }

    public Activos(String codigo, String nombre, int fabricacion, int valor, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fabricacion = fabricacion;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFabricacion() {
        return fabricacion;
    }

    public int getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFabricacion(int fabricacion) {
        this.fabricacion = fabricacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
