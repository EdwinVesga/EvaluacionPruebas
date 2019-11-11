package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class VisitarAmbientesPrueba {
	
	private By elementoIdentificador = By.id("ambientes");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlaceAmbientesPrueba = By.linkText("Ambientes de Prueba");
	private By encabezadoAmbientesPrueba = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[35]/div/div/div[2]/div/div/div/div/div/p[1]/strong");
	private ControladorPagina pagina;
	
	@Before
	public void setUp() throws Exception {
		pagina = new ControladorPagina();
		pagina.chromeDriverConnection();
		pagina.visit("https://www.choucairtesting.com/servicio/");
		pagina.visitarEnlace(enlacePortafolioSoluciones);
	}

	@After
	public void tearDown() throws Exception {
		pagina.cerrar();
	}

	@Test
	public void test() throws InterruptedException {
		pagina.visitarEnlace(enlaceAmbientesPrueba);
		assertTrue(pagina.esEnlaceValido(encabezadoAmbientesPrueba, elementoIdentificador));
	}

}
