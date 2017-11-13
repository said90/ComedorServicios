/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.controller;
import com.comedor.EJB.CataloProductosFacadeLocal;
import com.comedor.EJB.MenuFacadeLocal;
import com.comedor.model.CataloProductos;
import com.comedor.model.Menu;
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
public class MenuController implements Serializable {

    private Menu menu;
    private CataloProductos plato;

    @EJB
    MenuFacadeLocal menuEJB;
    @EJB
    CataloProductosFacadeLocal platoEJB;
    
    List<Menu> lstMenus;
    List<CataloProductos> lstPlatos;
    
    

    @PostConstruct
    public void init() {
        menu = new Menu();
        plato = new CataloProductos();
        lstMenus = menuEJB.findAll();
        lstPlatos = platoEJB.findAll();
    }

    public void registrarMenu() {
        this.menu.setIdPlatillo(plato);
        menuEJB.create(menu);
        
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public CataloProductos getPlato() {
        return plato;
    }

    public void setPlato(CataloProductos plato) {
        this.plato = plato;
    }

    public List<Menu> getLstMenus() {
        return lstMenus;
    }

    public void setLstMenus(List<Menu> lstMenus) {
        this.lstMenus = lstMenus;
    }

    public List<CataloProductos> getLstPlatos() {
        return lstPlatos;
    }

    public void setLstPlatos(List<CataloProductos> lstPlatos) {
        this.lstPlatos = lstPlatos;
    }
    
    
    
    
    
    
}
