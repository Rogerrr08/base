package org.ejemplo.proyecto_base.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.banistmo.com/wps/portal/banistmo/personas")
public class PaginaInicio extends PageObject {
    public static final Target BTN_PERSONAS = Target.the("Boton Inicio").located(By.xpath("//a[@href='/wps/portal/banistmo/personas']"));
    public static final Target BTN_TARIFARIO = Target.the("Pantalla Inicio").located(By.xpath("//a[@href='/wps/portal/banistmo/acerca-de/tarifario']"));
    public static final Target BTN_COOKIES = Target.the("Aceptar cookies").located(By.xpath("//button[@id='btn-aceptar-cookies']"));
}
