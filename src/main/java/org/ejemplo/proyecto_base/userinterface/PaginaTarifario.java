package org.ejemplo.proyecto_base.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaTarifario extends PageObject {
    public static final Target LBL_TARIFARIO = Target.the("Menu Tarifario").located(By.xpath("//h1[text()='Tarifario']"));
    public static final Target BTN_VER_PDF_TARIFASCUENTASDEPOSITO = Target.the("Tarifas de cuentas de deposito").located(By.xpath("//*[@id='layoutContainers']/div/div[1]/section/div[2]/div[2]/div/div/table/tbody/tr[3]/td[2]/span/a"));
}
