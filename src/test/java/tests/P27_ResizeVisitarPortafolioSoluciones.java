package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P27_ResizeVisitarPortafolioSoluciones {

	private By elementoIdentificador = By.id("portafolio");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By encabezadoPortafolioSoluciones = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[10]/div/div/div/div/div/div[1]/div/h2");
	private ControladorPagina pagina;
	
	@Before
	public void setUp() throws Exception {
		pagina = new ControladorPagina();
		pagina.chromeDriverConnection();
		pagina.setSize(200, 600);
		pagina.visit("https://www.choucairtesting.com/servicio/");
	}

	@After
	public void tearDown() throws Exception {
		pagina.cerrar();
	}

	@Test
	public void test() throws InterruptedException {
		pagina.visitarEnlace(enlacePortafolioSoluciones);
		assertTrue(pagina.esEnlaceValido(encabezadoPortafolioSoluciones, elementoIdentificador));
	}

}
