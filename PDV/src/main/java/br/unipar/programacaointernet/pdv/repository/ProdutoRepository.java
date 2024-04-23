package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.objetos.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class ProdutoRepository {
    @PersistenceContext(unitName = "HibernateJava")
    private EntityManager em;

    public List<Produto> getAll(){
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public Produto getById(int id)
    {
        return em.find(Produto.class, id);
    }

    public void insert(Produto produto)
    {
        try{
            em.persist(produto);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update(Produto produto)
    {
        try{
            em.merge(produto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(Produto produto)
    {
        try{
            em.remove(produto);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
