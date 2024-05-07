package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.dto.VendaDto;
import br.unipar.programacaointernet.pdv.mapper.*;
import br.unipar.programacaointernet.pdv.objetos.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class VendaRepository {
    @PersistenceContext(unitName = "HibernateJava")
    private EntityManager em;
    private vendaMapper mapper = new vendaMapper();

    public List<Venda> getAll(){
        String jpql = "SELECT c FROM Venda c";
        return em.createQuery(jpql, Venda.class).getResultList();
    }

    public Venda getById(int id)
    {
        return em.find(Venda.class, id);
    }

    public void insert(Venda venda){
        try{
            em.persist(venda);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void update(Venda venda)
    {
        try {
            em.merge(venda);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void remove(Venda venda){
       try{
           em.remove(venda);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public String GerarRelatorioVendas()
    {
        List<VendaDto> vv = mapper.toDto(getAll());
        String Lista = "";
        for(VendaDto v : vv){
            int Tot = 0;
            for(int i = 0; i < vv.size(); i++){
                if(vv.get(i).getNomeCliente().equals(v.getNomeCliente())){
                    Tot++;
                }
            }
            Lista += v.getNomeCliente() + " Qtd Compras :"+Tot+"/n";
        }
        return Lista;
    }

}
