/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activos.Controller;

import Activos.Aplicacion.Aplicacion;
import Activos.Entidades.Activos;
import Activos.Entidades.Categoria;
import Activos.Logica.ModelLogic;
import Activos.Model.ActivosModel;
import Activos.View.ActivosView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jas Pal
 */
public class ActivosController {

    ModelLogic domainModel;
    ActivosView view;
    ActivosModel model;

    public ActivosController(ModelLogic domainModel, ActivosView view, ActivosModel model) {
        model.init(domainModel.getCategorias().toArray(new Categoria[0]));
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public void buscar() throws Exception {
        model.getCurrent().setCodigo(view.codeTxtField.getText());
        model.clearErrors();
        //List<Activos> resultado=domainModel.searchActivo(model.getCurrent());
        Activos buscado = domainModel.getActivo(view.codeTxtField.getText());
        model.setCurrent(buscado);
        view.codeTxtField.setText(model.getCurrent().getCodigo());
        view.activeTxtField.setText(model.getCurrent().getNombre());
        view.fabricationTxtField.setText(String.valueOf(model.getCurrent().getFabricacion()));
        view.originalValueTxtLabel.setText(String.valueOf(model.getCurrent().getValor()));
        view.ageTxtField.setText(String.valueOf(model.Edad()));
        view.currentValueTxtFiedl.setText(String.valueOf(model.ValorActual()));
        view.depreciationTxtField.setText(String.valueOf(model.Depreciacion()));
    }

    public void agregar() {
        ActivosModel activosModel = Aplicacion.ACTIVOS_VIEW.getModel();
        Activos nuevo = new Activos();
        model.clearErrors();

        nuevo.setCodigo(view.codeTxtField.getText());
        if (view.codeTxtField.getText().length() == 0) {
            model.getErrores().put("codigo", "Codigo requerido");
        }
        nuevo.setNombre(view.activeTxtField.getText());
        if (view.activeTxtField.getText().length() == 0) {
            model.getErrores().put("activo", "Activo requerido");
        }

        if (!isNumeric(view.fabricationTxtField.getText()) || Integer.parseInt(view.fabricationTxtField.getText()) < 0) {
            model.getErrores().put("fabricacion", "Fabricacion requerida");
        } else if (isNumeric(view.fabricationTxtField.getText())) {
            nuevo.setFabricacion(Integer.parseInt(view.fabricationTxtField.getText()));
        }

        if (!isNumeric(view.originalValueTxtLabel.getText()) || Integer.parseInt(view.originalValueTxtLabel.getText()) < 0) {
            model.getErrores().put("valor original", "Valor Original requerido");
        } else if (isNumeric(view.originalValueTxtLabel.getText())) {
            nuevo.setValor(Integer.parseInt(view.originalValueTxtLabel.getText()));
        }

        nuevo.setCategoria((Categoria) view.ComboCategorias.getSelectedItem());
       
        if (model.getErrores().isEmpty()) {
            try {
                domainModel.addActivo(nuevo);
                model.setMensaje("ACTIVO AGREGADA");
                model.setCurrent(new Activos());                
            } catch (Exception e) {
                model.getErrores().put("codigo", "Activo ya existe");
                model.setMensaje("ACTIVO YA EXISTE");
                model.setCurrent(nuevo);
            }
        } else {
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
        view.codeTxtField.setText("");
        view.activeTxtField.setText("");
        view.originalValueTxtLabel.setText("");
        view.fabricationTxtField.setText("");
        view.ageTxtField.setText("");
        view.depreciationTxtField.setText("");
        view.currentValueTxtFiedl.setText("");
    }
    
    public void clearPantalla(){
        view.codeTxtField.setText("");
        view.activeTxtField.setText("");
        view.originalValueTxtLabel.setText("");
        view.fabricationTxtField.setText("");
        view.ageTxtField.setText("");
        view.depreciationTxtField.setText("");
        view.currentValueTxtFiedl.setText("");
    }

    public void modificar() {
        ActivosModel activosModel = Aplicacion.ACTIVOS_VIEW.getModel();
        Activos nuevo = new Activos();
        model.clearErrors();

        nuevo.setCodigo(view.codeTxtField.getText());
        if (view.codeTxtField.getText().length() == 0) {
            model.getErrores().put("codigo", "Codigo requerido");
        }
        nuevo.setNombre(view.activeTxtField.getText());
        if (view.activeTxtField.getText().length() == 0) {
            model.getErrores().put("activo", "Activo requerido");
        }

        if (!isNumeric(view.fabricationTxtField.getText()) || Integer.parseInt(view.fabricationTxtField.getText()) < 0) {
            model.getErrores().put("fabricacion", "Fabricacion requerida");
        } else if (isNumeric(view.fabricationTxtField.getText())) {
            nuevo.setFabricacion(Integer.parseInt(view.fabricationTxtField.getText()));
        }

        if (!isNumeric(view.originalValueTxtLabel.getText()) || Integer.parseInt(view.originalValueTxtLabel.getText()) < 0) {
            model.getErrores().put("valor original", "Valor Original requerido");
        } else if (isNumeric(view.fabricationTxtField.getText())) {
            nuevo.setValor(Integer.parseInt(view.originalValueTxtLabel.getText()));
        }

        nuevo.setCategoria((Categoria) view.ComboCategorias.getSelectedItem());
        
        if (model.getErrores().isEmpty()) {
            try {
                domainModel.updateActivo(nuevo);
                model.setMensaje("ACTIVO AGREGADA");
                model.setCurrent(new Activos());
               
            } catch (Exception e) {
                model.getErrores().put("codigo", "Activo ya existe");
                model.setMensaje("ACTIVO YA EXISTE");
                model.setCurrent(nuevo);
            }
        } else {
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
        view.codeTxtField.setText("");
        view.activeTxtField.setText("");
        view.originalValueTxtLabel.setText("");
        view.fabricationTxtField.setText("");
        view.ageTxtField.setText("");
        view.depreciationTxtField.setText("");
        view.currentValueTxtFiedl.setText("");
    }

}
