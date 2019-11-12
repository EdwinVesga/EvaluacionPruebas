package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class P20_VisitarCursosYCertificaciones {
	
	private By elementoIdentificador = By.id("cursos");
	private By enlacePortafolioSoluciones = By.linkText("Portafolio de Soluciones");
	private By enlaceCursos = By.linkText("Cursos y Certificaciones");
	private By encabezadoCursos = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[41]/div/div/div[1]/div/div/div[1]/div/div/p[1]/strong[2]");
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
		pagina.visitarEnlace(enlaceCursos);
		assertTrue(pagina.esEnlaceValido(encabezadoCursos, elementoIdentificador));
	}

}
