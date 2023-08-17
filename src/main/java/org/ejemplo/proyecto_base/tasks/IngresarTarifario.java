package org.ejemplo.proyecto_base.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.ejemplo.proyecto_base.userinterface.PaginaInicio;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarTarifario implements Task {
    public static IngresarTarifario seccionTarifas() {

        return Tasks.instrumented(IngresarTarifario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(PaginaInicio.BTN_COOKIES, isVisible()).forNoMoreThan(60).seconds());
        if (actor.asksFor(Presence.of(PaginaInicio.BTN_COOKIES))) {
            actor.attemptsTo(
                    Click.on(PaginaInicio.BTN_COOKIES).afterWaitingUntilEnabled());
        }
        actor.attemptsTo(
                WaitUntil.the(PaginaInicio.BTN_PERSONAS, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(PaginaInicio.BTN_TARIFARIO),
                Click.on(PaginaInicio.BTN_TARIFARIO).afterWaitingUntilPresent()
        );
    }
}
