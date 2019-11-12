package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P17_VisitarPruebasNomina {
	
	private By elementoIdentificador = By.id("Nomina");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlacePruebasNomina = By.linkText("Pruebas de Nómina");
	private By encabezadoPruebasNomina = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[43]/div/div/div[2]/div/div/div/div/div/p[1]/b[2]");
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
		pagina.visitarEnlace(enlacePruebasNomina);
		assertTrue(pagina.esEnlaceValido(encabezadoPruebasNomina, elementoIdentificador));
	}

}
