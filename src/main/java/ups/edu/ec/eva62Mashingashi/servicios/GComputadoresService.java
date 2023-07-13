package ups.edu.ec.eva62Mashingashi.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.eva62Mashingashi.modelo.Computador;
import ups.edu.ec.eva62Mashingashi.negocio.GestionComputadores;

@Path("computadores")
public class GComputadoresService {

	@Inject
	private GestionComputadores GComputadores;
	
	@PersistenceContext
	private EntityManager entityManager;

    @GET
    @Path("computadoras")
    public String obtenerComputadors() {
        StringBuilder sb = new StringBuilder();

        List<Computador> computadors = entityManager.createQuery("SELECT p FROM Computador p", Computador.class).getResultList();

        for (Computador computador : computadors) {
            int id = computador.getId();
            String marca = computador.getMarca();
            String modelo = computador.getModelo();
            int memoriaRAM = computador.getMemoriaRAM();

            sb.append("Id: ").append(id).append("\nMarca: ").append(marca).append("\nModelo: ").append(modelo).append("\nMemoriaRam: ").append(memoriaRAM).append("\n\n");
        }

        return sb.toString();
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response guardarCliente(Computador computador) {
    	
    	try {
    		GComputadores.guardarComputadores(computador);
			return Response.status(Response.Status.OK).entity(computador).build();
		} catch (Exception e) {
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: "+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
    }


}

