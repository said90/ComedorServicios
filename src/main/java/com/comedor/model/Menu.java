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
 * @author bgarcia95
 */
@Entity
@Table(name="menu")
@XmlRootElement
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idmenu;
    
    @JoinColumn(name = "idplatillo", referencedColumnName = "idplatillo")
    @ManyToOne
    private CataloProductos idPlatillo;
    
    @Column(name="precio")
    private float precio;

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public CataloProductos getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(CataloProductos idPlatillo) {
        this.idPlatillo = idPlatillo;
    }


    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
