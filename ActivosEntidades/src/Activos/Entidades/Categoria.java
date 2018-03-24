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
public class Categoria {

    String id;
    String categoria;
    int vidaUtil;

    public Categoria() {
        this.id = "";
        this.categoria = "";
        this.vidaUtil = 0;
    }

    public Categoria(String id, String categoria, int vidaUtil) {
        this.id = id;
        this.categoria = categoria;
        this.vidaUtil = vidaUtil;
    }

    public String getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String toString() {
        return this.categoria;
    }
}
