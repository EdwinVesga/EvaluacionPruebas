package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P24_GoTopDesdePortafolioSoluciones {

	private By botonGoTop = By.xpath("//*[@id=\"page\"]/a[2]");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
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
		pagina.visitarEnlace(botonGoTop);
		assertTrue(pagina.esInicioDePagina());
	}

}
