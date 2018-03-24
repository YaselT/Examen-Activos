/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activos.Logica;

import Activos.Datos.Dao;
import Activos.Entidades.Activos;
import Activos.Entidades.Categoria;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jas Pal
 */
public class ModelLogic {
    private Dao dao;
     
    private static ModelLogic uniqueInstance;
    
    public static ModelLogic instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ModelLogic();
        }
        return uniqueInstance;
    }
    private ModelLogic(){
        dao = new Dao();
    }
            
    public Collection<Categoria> getCategorias(){
        return dao.CategoriaGetAll();
    }
    
    public  Categoria getCategoria(String codigo) throws Exception{
        return dao.CategoriaGet(codigo);
    }

    public Activos getActivo(String id) throws Exception{
        return dao.ActivoGet(id);
    }

    public void addActivo(Activos activo) throws Exception{
        dao.ActivoAdd(activo);
    }

    public void updateActivo(Activos activo) throws Exception{
        dao.ActivoUpdate(activo);
    }

    public void close(){
        dao.close();
    }
}
