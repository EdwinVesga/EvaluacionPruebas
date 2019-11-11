package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pom.ControladorPagina;

public class Resize_VisitarComoLoHacemos {

	private By elementoIdentificador = By.id("hacemos");
	private By enlaceComoLoHacemos = By.linkText("Cómo lo hacemos");
	private By encabezadoComoLoHacemos = By.xpath("//*[@id=\"main\"]/div/div/div/div/section[7]/div/div/div/div/div/div[1]/div/h2");
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
		pagina.visitarEnlace(enlaceComoLoHacemos);
		assertTrue(pagina.esEnlaceValido(encabezadoComoLoHacemos, elementoIdentificador));
	}

}
