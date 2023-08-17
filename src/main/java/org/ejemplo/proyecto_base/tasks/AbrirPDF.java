package org.ejemplo.proyecto_base.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.ejemplo.proyecto_base.userinterface.PaginaTarifario;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirPDF implements Task {
    public static AbrirPDF abrirPDF() {
        return Tasks.instrumented(AbrirPDF.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaTarifario.LBL_TARIFARIO, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(PaginaTarifario.BTN_VER_PDF_TARIFASCUENTASDEPOSITO),
                Click.on(PaginaTarifario.BTN_VER_PDF_TARIFASCUENTASDEPOSITO).afterWaitingUntilPresent(),
                Switch.toNewWindow()
        );
    }
}
