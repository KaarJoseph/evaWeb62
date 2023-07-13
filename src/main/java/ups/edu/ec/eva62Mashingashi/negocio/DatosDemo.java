package ups.edu.ec.eva62Mashingashi.negocio;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.eva62Mashingashi.datos.ComputadorDao;
import ups.edu.ec.eva62Mashingashi.modelo.Computador;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private ComputadorDao daoComputador;
	
	@PostConstruct
	public void init() {
	
	System.out.println("COMPUTADOR 1");

	Computador c = new Computador();
	c.setId(01);
	c.setMarca("Lenovo");
	c.setModelo("GS-12");
	c.setMemoriaRAM(8);
	daoComputador.insert(c);
	daoComputador.imprimirDatos();

	System.out.println("COMPUTADOR 2");

	Computador c1 = new Computador();
	c1.setId(02);
	c1.setMarca("HP");
	c1.setModelo("Notebook");
	c1.setMemoriaRAM(16);
	daoComputador.insert(c);
	daoComputador.imprimirDatos();

	}
}
