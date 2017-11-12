/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comedor.EJB;

import com.comedor.model.CataloProductos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bgarcia95
 */
@Stateless
public class CataloProductosFacade extends AbstractFacade<CataloProductos> implements CataloProductosFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_Comedor_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CataloProductosFacade() {
        super(CataloProductos.class);
    }
    
}
