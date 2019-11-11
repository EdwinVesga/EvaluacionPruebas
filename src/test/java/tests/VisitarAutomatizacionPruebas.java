package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class VisitarAutomatizacionPruebas {
	
	private By elementoIdentificador = By.id("automatizacion");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlaceAutomatizacionPruebas = By.linkText("Automatización de Pruebas");
	private By encabezadoAutomatizacionPruebas = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[33]/div/div/div[1]/div/div/div/div/div/p[1]/strong[2]");
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
		pagina.visitarEnlace(enlaceAutomatizacionPruebas);
		assertTrue(pagina.esEnlaceValido(encabezadoAutomatizacionPruebas, elementoIdentificador));
	}

}
