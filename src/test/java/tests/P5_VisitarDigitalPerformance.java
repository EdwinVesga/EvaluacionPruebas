package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P5_VisitarDigitalPerformance {
	
	private By elementoIdentificador = By.id("digital");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlaceDigitalPerformance = By.linkText("Digital Performance Management");
	private By encabezadoDigitalPerformance = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[29]/div/div/div[1]/div/div/div/div/div/p[1]/strong");
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
		pagina.visitarEnlace(enlaceDigitalPerformance);
		assertTrue(pagina.esEnlaceValido(encabezadoDigitalPerformance, elementoIdentificador));
	}

}
