package pom;

import org.openqa.selenium.By;

public class ControladorPagina extends Base {
	
	
	public void visitarEnlace(By locator) throws InterruptedException {
		click(locator);
		Thread.sleep(1500);
	}
	
	public boolean esEnlaceValido(By elementoVerificador, By elementoIdentificador) {
		int distanciaVertical = distanciaVerticalEntreElementos(elementoIdentificador, elementoVerificador);
		long posicionScroll = getScrollPosition();
		if(isDisplayed(elementoVerificador) && (posicionScroll>=(getPosition(elementoVerificador).getY()-200)) && (posicionScroll<= (getPosition(elementoVerificador).getY()+200)) && (distanciaVertical >= 0) && (distanciaVertical <= 200)) {
			return true;
		}
		return false;
	}
	
	public boolean esEnlaceValido(By elementoVerificador) {
		if(isDisplayed(elementoVerificador)) {
			return true;
		}
		return false;
	}
	
	public boolean esInicioDePagina() throws InterruptedException {
		if(getScrollPosition() == 0) {
			Thread.sleep(1500);
			return true;
		}
		return false;
	}
	
	private int distanciaVerticalEntreElementos(By elementoInicial, By elementoFinal) {
		return getPosition(elementoFinal).getY() - getPosition(elementoInicial).getY(); 
	}
	
	}
