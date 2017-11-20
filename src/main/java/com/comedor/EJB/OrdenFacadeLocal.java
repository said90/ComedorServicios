/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.EJB;

import com.comedor.model.CataloProductos;
import com.comedor.model.Detalleorden;
import com.comedor.model.Mesa;
import com.comedor.model.Orden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davsa
 */
@Local
public interface OrdenFacadeLocal {

    void create(Orden orden);

    void edit(Orden orden);

    void remove(Orden orden);

    Orden find(Object id);

    List<Orden> findAll();

    List<Orden> findRange(int[] range);

    int count();
    
    List<Mesa> mesasDisponible();
    
    List<CataloProductos> menuDisponible();
    
    List<Detalleorden> obtenerDetallePorOrden(Orden orden);
}
