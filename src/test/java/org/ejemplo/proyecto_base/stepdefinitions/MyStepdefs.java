package org.ejemplo.proyecto_base.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.ejemplo.proyecto_base.questions.ValidarPDF;
import org.ejemplo.proyecto_base.tasks.AbrirPDF;
import org.ejemplo.proyecto_base.tasks.AbrirPagina;
import org.ejemplo.proyecto_base.tasks.IngresarTarifario;
import org.hamcrest.Matchers;

public class MyStepdefs {

    @Before
    public void IniciarEscenario() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario ingresa a la pagina")
    public void queElUsuarioIngresaALaPagina() {
        OnStage.theActorCalled("actor").wasAbleTo(AbrirPagina.urlApp());
    }

    @Cuando("ingresa a la seccion Tarifarios")
    public void ingresoTarifarios() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarTarifario.seccionTarifas());
    }

    @Y("selecciona ver el PDF de Tarifas de Cuentas de Deposito")
    public void seleccionarPDF() {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirPDF.abrirPDF());
    }

    @Entonces("ve la informacion y verifica que el PDF sea el correcto")
    public void validarPDF() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarPDF.validarPDF(), Matchers.containsString("Tarifas de Cuentas de Depósito")));
    }

}
