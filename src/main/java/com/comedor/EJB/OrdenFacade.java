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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author davsa
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> implements OrdenFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_Comedor_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }

    @Override
    public List<Mesa> mesasDisponible() {
        List<Mesa> lista;
        Query q = em.createNativeQuery("select * from mesa where mesa.estado='disponible'",Mesa.class);
        lista= q.getResultList();
        return lista;
        }

    @Override
    public List<CataloProductos> menuDisponible() {
        List<CataloProductos> lista;
        Query q = em.createNativeQuery("select * from catalo_productos where estado='Disponible'",CataloProductos.class);
        lista= q.getResultList();
        return lista;
    }

    @Override
    public List<Detalleorden> obtenerDetallePorOrden(Orden orden) {
        List<Detalleorden> lista;
        Query q = em.createNativeQuery("Select * from detalleOrden where idorden= ?1",Detalleorden.class);
        q.setParameter(1, orden.getIdorden());
        lista= q.getResultList();
        return lista;
        
    }
    
}
