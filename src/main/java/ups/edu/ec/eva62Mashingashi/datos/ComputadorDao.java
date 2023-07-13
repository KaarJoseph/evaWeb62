package ups.edu.ec.eva62Mashingashi.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.eva62Mashingashi.modelo.Computador;

@Stateless
public class ComputadorDao implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Computador computador) {
		em.persist(computador);
	}
	
	public void update(Computador computador) {
		em.merge(computador);
	}
	
	public Computador read(int id) {
		Computador p = em.find(Computador.class, id);
		return p;
	}
	
	public void delete(int id) {
		Computador p = em.find(Computador.class, id);
		em.remove(p);
	}
	
	public List<Computador> getAll(){
		String jpql = "SELECT p FROM Computador p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	public void imprimirDatos() {
	    List<Computador> computadors = getAll();
	    
	    for (Computador computador : computadors) {
	        System.out.println("Id: " + computador.getId());
	        System.out.println("Marca: " + computador.getMarca());
	        System.out.println("Modelo: " + computador.getModelo());
	        System.out.println("Memoria Ram: " + computador.getMemoriaRAM());
	        System.out.println("-----------------------------");
	    }
	}
}
