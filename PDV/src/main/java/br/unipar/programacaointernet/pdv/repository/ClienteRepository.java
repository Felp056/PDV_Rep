package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.objetos.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteRepository {
    @PersistenceContext(unitName = "HibernateJava")
    private EntityManager em;

    public Cliente getById(int id) {
        try {
            return em.find(Cliente.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
     public List<Cliente> getAll(){
         String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public void update(Cliente cliente){
        try{
            em.merge(cliente);
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void remove(Cliente cliente)
    {
        try {
            em.remove(cliente);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void insert (Cliente cliente){
        try {
            em.persist(cliente);
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
