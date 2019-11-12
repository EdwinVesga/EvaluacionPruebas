package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P6_VisitarPruebasMoviles {
	
	private By elementoIdentificador = By.id("moviles");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlacePruebasMoviles = By.linkText("Pruebas Móviles");
	private By encabezadoPruebasMoviles= By.xpath("//*[@id=\"main\"]/div/div/div/div/section[21]/div/div/div[1]/div/div/div/div/div/p[1]/strong");
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
		pagina.visitarEnlace(enlacePruebasMoviles);
		assertTrue(pagina.esEnlaceValido(encabezadoPruebasMoviles, elementoIdentificador));
	}

}
