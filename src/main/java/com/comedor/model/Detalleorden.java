/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author davsa
 */
@Entity
@Table(name = "detalleorden")

@XmlRootElement
public class Detalleorden implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalleOrden")
    private Integer iddetalleOrden;
    @Column(name = "precio")
    private Long precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idorden", referencedColumnName = "idorden")
    @ManyToOne(optional = false)
    private Orden idorden;
    @JoinColumn(name = "idplatillo", referencedColumnName = "idplatillo")
    @ManyToOne(optional = false)
    private CataloProductos idplatillo;

    public Detalleorden() {
    }

    public Detalleorden(Integer iddetalleOrden) {
        this.iddetalleOrden = iddetalleOrden;
    }

    public Integer getIddetalleOrden() {
        return iddetalleOrden;
    }

    public void setIddetalleOrden(Integer iddetalleOrden) {
        this.iddetalleOrden = iddetalleOrden;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Orden getIdorden() {
        return idorden;
    }

    public void setIdorden(Orden idorden) {
        this.idorden = idorden;
    }

    public CataloProductos getIdplatillo() {
        return idplatillo;
    }

    public void setIdplatillo(CataloProductos idplatillo) {
        this.idplatillo = idplatillo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleOrden != null ? iddetalleOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleorden)) {
            return false;
        }
        Detalleorden other = (Detalleorden) object;
        if ((this.iddetalleOrden == null && other.iddetalleOrden != null) || (this.iddetalleOrden != null && !this.iddetalleOrden.equals(other.iddetalleOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comedor.model.Detalleorden[ iddetalleOrden=" + iddetalleOrden + " ]";
    }
    
}
