package ups.edu.ec.eva62Mashingashi.negocio;

import jakarta.inject.Inject;
import ups.edu.ec.eva62Mashingashi.datos.ComputadorDao;
import ups.edu.ec.eva62Mashingashi.modelo.Computador;

public class GestionComputadores {

	@Inject
	private ComputadorDao daoComputador;
	
	public void guardarComputadores(Computador computador) throws Exception{
		if(!this.isIdValida(computador.getId())) 
			throw new Exception("ID INCORRECTA");
		
		if (daoComputador.read(computador.getId())==null) {
			try {
				daoComputador.insert(computador);
			} catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoComputador.update(computador);

			} catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}

	private boolean isIdValida(int id) {
	    String idString = String.valueOf(id);
	    return idString.length() == 2;
	}

	
	public void guardarClientes(String cedula, String nombre, String direccion) {
		
	}

}
