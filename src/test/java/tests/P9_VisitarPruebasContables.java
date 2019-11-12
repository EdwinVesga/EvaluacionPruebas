package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P9_VisitarPruebasContables {
	
	private By elementoIdentificador = By.id("contables");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlacePruebasContables = By.linkText("Pruebas Contables y Financieras");
	private By encabezadoPruebasContables = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[19]/div/div/div[2]/div/div/div/div/div/p[1]/strong[2]");
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
		pagina.visitarEnlace(enlacePruebasContables);
		assertTrue(pagina.esEnlaceValido(encabezadoPruebasContables, elementoIdentificador));
	}

}
