/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.controller;



import com.comedor.EJB.CataloProductosFacadeLocal;
import com.comedor.model.CataloProductos;
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
public class PlatoController implements Serializable {

    CataloProductos plato;
    
    @EJB
    CataloProductosFacadeLocal platoEJB;
    List<CataloProductos> lstPlatos;

    @PostConstruct
    public void init() {
        plato = new CataloProductos();
        lstPlatos = platoEJB.findAll();
    }

    public void registrarPlato() {
        platoEJB.create(plato);
    }
    
    public void ModificarMesa(){
        platoEJB.edit(plato);
    }
    
    public void EliminarMesa(){
        platoEJB.remove(plato);
    }

    
    
//    public void registrar() {
//        try {
//            mesaEJB.create(mesa);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Mesa registrada con éxito"));
//            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
//
//        }
//
//    }

    public CataloProductos getPlato() {
        return plato;
    }

    public void setPlato(CataloProductos plato) {
        this.plato = plato;
    }

    public List<CataloProductos> getLstPlatos() {
        return lstPlatos;
    }

    public void setLstPlatos(List<CataloProductos> lstPlatos) {
        this.lstPlatos = lstPlatos;
    }
    
    
    
    
}
