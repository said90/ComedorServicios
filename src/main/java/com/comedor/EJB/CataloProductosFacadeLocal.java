/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.EJB;

import com.comedor.model.CataloProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bgarcia95
 */
@Local
public interface CataloProductosFacadeLocal {

    void create(CataloProductos cataloProductos);

    void edit(CataloProductos cataloProductos);

    void remove(CataloProductos cataloProductos);

    CataloProductos find(Object id);

    List<CataloProductos> findAll();

    List<CataloProductos> findRange(int[] range);

    int count();
    
}
