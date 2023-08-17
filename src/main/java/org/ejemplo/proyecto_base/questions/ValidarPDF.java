package org.ejemplo.proyecto_base.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.ejemplo.proyecto_base.utils.ExtraerContenidoPDF;

public class ValidarPDF implements Question {
    public static ValidarPDF validarPDF() {
        return new ValidarPDF();
    }

    @Override
    public Object answeredBy(Actor actor) {
        ExtraerContenidoPDF extraerContenidoPDF = new ExtraerContenidoPDF(actor);
        return extraerContenidoPDF.contenidoPDF();
    }
}
