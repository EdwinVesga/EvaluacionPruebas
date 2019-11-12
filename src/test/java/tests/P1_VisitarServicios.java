package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;


public class P1_VisitarServicios {
	
	private By enlaceServicios = By.linkText("Servicios");
	private By imagenPrincipalServicios = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2018/11/Banner-pag-interna.jpg.webp']");
	private ControladorPagina pagina;
	
	@Before
	public void setUp() throws Exception {
		pagina = new ControladorPagina();
		pagina.chromeDriverConnection();
		pagina.visit("https://www.choucairtesting.com");
	}
	
	@After
	public void tearDown() throws Exception{
		pagina.cerrar();
	}
	
	@Test
	public void test() throws InterruptedException {
		pagina.visitarEnlace(enlaceServicios);;
		assertTrue(pagina.esEnlaceValido(imagenPrincipalServicios));
	}
}
