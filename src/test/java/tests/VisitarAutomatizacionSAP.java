package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class VisitarAutomatizacionSAP {

	private By elementoIdentificador = By.id("sap");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlacePruebasSAP = By.linkText("Automatización de Pruebas SAP");
	private By encabezadoPruebasSAP = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[31]/div/div/div[2]/div/div/div/div/div/p[1]/strong");
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
		pagina.visitarEnlace(enlacePruebasSAP);
		assertTrue(pagina.esEnlaceValido(encabezadoPruebasSAP, elementoIdentificador));
	}

}
