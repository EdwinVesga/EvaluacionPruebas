package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class BotonLeerMasCursos {

	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlaceCursos = By.linkText("Cursos y Certificaciones");
	private By enlaceCursosLeerMas = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[41]/div/div/div[1]/div/div/div[2]/div/div/a");
	private By imagenPrincipalFormacion = By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[1]/div/div/div/div/div/div/div/div/img");
	private ControladorPagina pagina;
	
	@Before
	public void setUp() throws Exception {
		pagina = new ControladorPagina();
		pagina.chromeDriverConnection();
		pagina.visit("https://www.choucairtesting.com/servicio/");
		pagina.visitarEnlace(enlacePortafolioSoluciones);
		pagina.visitarEnlace(enlaceCursos);
	}

	@After
	public void tearDown() throws Exception {
		pagina.cerrar();
	}

	@Test
	public void test() throws InterruptedException {
		pagina.visitarEnlace(enlaceCursosLeerMas);
		assertTrue(pagina.esEnlaceValido(imagenPrincipalFormacion));
	}

}
