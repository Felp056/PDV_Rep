package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.objetos.ItensVenda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class ItensVendaRepository {
    @PersistenceContext(unitName = "HibernateJava")
    private EntityManager em;

    public ItensVenda findById(Integer id)
    {
        return em.find(ItensVenda.class, id);
    }
    public List<ItensVenda> getAll(){
        return em.createQuery("select i from ItensVenda i").getResultList();
    }
    public void insert(ItensVenda venda){
        try {
            em.persist(venda);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update(ItensVenda venda){
        try{
            em.merge(venda);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void remove(ItensVenda venda)
    {
        try{
            em.remove(venda);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
