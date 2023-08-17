package org.ejemplo.proyecto_base.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.ejemplo.proyecto_base.userinterface.PaginaInicio;

public class AbrirPagina implements Task {
    private PaginaInicio paginaInicio;
    public static AbrirPagina urlApp() {
        return Tasks.instrumented(AbrirPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(paginaInicio));
    }

}
