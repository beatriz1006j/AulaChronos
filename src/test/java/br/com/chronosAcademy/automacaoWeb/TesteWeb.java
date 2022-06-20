package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.pages.CursoPage;
import br.com.chronosAcademy.pages.PrincipalPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class TesteWeb {
    WebDriver driver;
    Driver  driverWeb;
    PrincipalPage principalPage;
    CursoPage cursoPage;

    @Before
    public void inicializaTeste(){

        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }

/**/
    @Test // @Ignore
    public void primeiro(){
        assertEquals("Porque Tempo � Conhecimento",principalPage.getTitulo());

    }

    @Test
    public void segundoTeste(){
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();

        assertEquals("Conhe�a todos os nossos cursos",cursoPage.getTitulo2());
    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }
}
