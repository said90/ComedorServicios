/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.controller;

import com.comedor.EJB.DetalleordenFacadeLocal;
import com.comedor.EJB.MesaFacadeLocal;
import com.comedor.EJB.OrdenFacadeLocal;
import com.comedor.model.CataloProductos;
import com.comedor.model.Detalleorden;
import com.comedor.model.Mesa;
import com.comedor.model.Orden;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bsf_o
 */
@Named
@ViewScoped
public class OrdenController implements Serializable {

    private Mesa mesa;
    private Orden orden;
    private Detalleorden detalle;

    @EJB
    private OrdenFacadeLocal ordenEJB;
    @EJB
    private MesaFacadeLocal mesaEJB;
    @EJB
    private DetalleordenFacadeLocal detalleEJB;

    private List<Orden> lstOrdenes;
    private List<Mesa> lstMesas;
    private List<Mesa> lstMesaDisponible;
    private List<CataloProductos> lstMenuDisponibles;
    private List<Detalleorden> lstDetalleOrden;

    @PostConstruct
    private void init() {
        mesa = new Mesa();
        orden = new Orden();
        detalle= new Detalleorden();
        lstOrdenes = ordenEJB.findAll();
        lstMesas= mesaEJB.findAll();
        lstMesaDisponible= ordenEJB.mesasDisponible();
        lstMenuDisponibles= ordenEJB.menuDisponible();
    }

    public void crearOrden() {
        ordenEJB.create(orden);
    }
    
    public void crearDetalle(){
    detalleEJB.create(detalle);
    lstDetalleOrden=ordenEJB.obtenerDetallePorOrden(orden);
    }
    
    //Getter and Setters

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public List<Orden> getLstOrdenes() {
        return lstOrdenes;
    }

    public void setLstOrdenes(List<Orden> lstOrdenes) {
        this.lstOrdenes = lstOrdenes;
    }

    public List<Mesa> getLstMesas() {
        return lstMesas;
    }

    public void setLstMesas(List<Mesa> lstMesas) {
        this.lstMesas = lstMesas;
    }

    public List<Mesa> getLstMesaDisponible() {
        return lstMesaDisponible;
    }

    public void setLstMesaDisponible(List<Mesa> lstMesaDisponible) {
        this.lstMesaDisponible = lstMesaDisponible;
    }

    public List<CataloProductos> getLstMenuDisponibles() {
        return lstMenuDisponibles;
    }

    public void setLstMenuDisponibles(List<CataloProductos> lstMenuDisponibles) {
        this.lstMenuDisponibles = lstMenuDisponibles;
    }

    public Detalleorden getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalleorden detalle) {
        this.detalle = detalle;
    }

    public List<Detalleorden> getLstDetalleOrden() {
        return lstDetalleOrden;
    }

    public void setLstDetalleOrden(List<Detalleorden> lstDetalleOrden) {
        this.lstDetalleOrden = lstDetalleOrden;
    }
    
    

    
    
}
