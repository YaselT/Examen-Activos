/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activos.Datos;

import Activos.Entidades.Activos;
import Activos.Entidades.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jas Pal
 */
public class Dao {

    RelDataBase db;

    public Dao() {
        db = new RelDataBase();
    }

    public Categoria CategoriaGet(String codigo) throws Exception {
        String sql = "select * from Categoria where Id='%s'";
        sql = String.format(sql, codigo);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return categoria(rs);
        } else {
            throw new Exception("Categoria no Existe");
        }
    }

    private Categoria categoria(ResultSet rs) {
        try {
            Categoria c = new Categoria();
            c.setId(rs.getString("Id"));
            c.setCategoria(rs.getString("Categoria"));
            c.setVidaUtil(rs.getInt("VidaUtil"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Collection<Categoria> CategoriaGetAll() {
        Vector<Categoria> categorias = new Vector<Categoria>();
        try {
            String sql = "select * from Categoria";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                categorias.add(categoria(rs));
            }
        } catch (SQLException ex) {
        }
        return categorias;
    }

    public Activos ActivoGet(String id) throws Exception {
        /*String sql = "select * "
                + "from Activo inner join Categoria "
                + "where Codigo='%s'";*/
        /*String sql = "select * "
                + "from activo a inner join categoria c on a.categoria=c.id "
                + "where a.codigo='"+id+"'";*/
        String sql = "select * from activo inner join categoria c";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return activo(rs);
        } else {
            throw new Exception("Activo no Existe");
        }
    }

    public void ActivoAdd(Activos p) throws Exception {
        String sql = "insert into Activo (Codigo, Activo, ValorOriginal, Fabricacion, IdCategoria) "
                + "values('%s','%s', %d, %d,'%s')";
        sql = String.format(sql, p.getCodigo(), p.getNombre(), p.getValor(), p.getFabricacion(), p.getCategoria().getId());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Activo ya existe");
        }
    }

    public void ActivoUpdate(Activos p) throws Exception {
        String ayuda = p.getCodigo();
        String sql = "update Activo set Codigo='%s',Activo='%s',ValorOriginal=%d,"
                + "Fabricacion=%d,IdCategoria='%s' "
                + "where Codigo='" + ayuda + "'";
        sql = String.format(sql, p.getCodigo(), p.getNombre(), p.getValor(), p.getFabricacion(), p.getCategoria().getId());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Activo no existe");
        }
    }

    private Activos activo(ResultSet rs) {
        try {
            Activos a = new Activos();
            a.setCodigo(rs.getString("Codigo"));
            a.setNombre(rs.getString("Activo"));
            a.setValor(rs.getInt("ValorOriginal"));
            a.setFabricacion(rs.getInt("Fabricacion"));
            a.setCategoria(categoria(rs));
            return a;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
