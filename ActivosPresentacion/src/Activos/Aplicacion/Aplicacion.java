/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activos.Aplicacion;

import Activos.Controller.ActivosController;
import Activos.Logica.ModelLogic;
import Activos.Model.ActivosModel;
import Activos.View.ActivosView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Jas Pal
 */
public class Aplicacion {

    public static void main(String[] args) {
        ModelLogic domainModel = ModelLogic.instance();

        ActivosModel modelActivo = new ActivosModel();

        ActivosView activosView = new ActivosView();
        ACTIVOS_VIEW = activosView;

        ActivosController activosController = new ActivosController(domainModel, activosView, modelActivo);
        activosView.setVisible(true);
    }
    public static ActivosView ACTIVOS_VIEW;

    public static final int MODO_AGREGAR = 0;
    public static final int MODO_EDITAR = 1;

    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
}
