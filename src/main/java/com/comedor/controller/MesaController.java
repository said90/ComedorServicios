/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.controller;

import com.comedor.EJB.MesaFacadeLocal;
import com.comedor.model.Mesa;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author davsa
 */
@Named
@ViewScoped
public class MesaController implements Serializable {

    Mesa mesa;

    @EJB
    MesaFacadeLocal mesaEJB;
    List<Mesa> lstMesas;

    @PostConstruct
    public void init() {
        mesa = new Mesa();
        lstMesas = mesaEJB.findAll();
    }

    public void registrarMesa() {
        mesaEJB.create(mesa);
    }
    
    public void ModificarMesa(){
        mesaEJB.edit(mesa);
    }
    
    public void EliminarMesa(){
        mesaEJB.remove(mesa);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Mesa> getLstMesas() {
        return lstMesas;
    }

    public void setLstMesas(List<Mesa> lstMesas) {
        this.lstMesas = lstMesas;
    }
    
    public void registrar() {
        try {
            mesaEJB.create(mesa);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Mesa registrada con éxito"));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));

        }

    }
    
    
    
    
}
