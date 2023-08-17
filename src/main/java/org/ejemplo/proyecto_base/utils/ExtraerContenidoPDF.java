package org.ejemplo.proyecto_base.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

//import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ExtraerContenidoPDF {
    private Actor actor;
    public ExtraerContenidoPDF(Actor actor) {

        this.actor = actor;
    }

    public String contenidoPDF() {
        //String rutaPDF = "C:/Users/rnavarrol/Downloads/Tarifas-de-cuentas-de-Depositos.pdf";
        actor.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        String currenttabURL = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();

        try {
            /*PDDocument pdfDocument = PDDocument.load(new File(rutaPDF));
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfContent = pdfTextStripper.getText(pdfDocument);*/
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(currenttabURL);
            CloseableHttpResponse response = httpClient.execute(httpGet);

            InputStream pdfInputStream = response.getEntity().getContent();

            PDDocument pdfDocument = PDDocument.load(pdfInputStream);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfContent = pdfTextStripper.getText(pdfDocument);
            pdfDocument.close();
            httpClient.close();
            return pdfContent;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
