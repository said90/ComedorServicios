/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.EJB;

import com.comedor.model.Detalleorden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davsa
 */
@Local
public interface DetalleordenFacadeLocal {

    void create(Detalleorden detalleorden);

    void edit(Detalleorden detalleorden);

    void remove(Detalleorden detalleorden);

    Detalleorden find(Object id);

    List<Detalleorden> findAll();

    List<Detalleorden> findRange(int[] range);

    int count();
    
}
