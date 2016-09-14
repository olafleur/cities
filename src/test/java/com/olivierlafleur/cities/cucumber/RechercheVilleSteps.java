package com.olivierlafleur.cities.cucumber;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Étantdonné;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

public class RechercheVilleSteps {
    private WebDriver driver = new ChromeDriver();
    private Wait<WebDriver> wait = new WebDriverWait(driver, 3);

    @Étantdonné("^que j'entre sur la page de recherche de villes$")
    public void queJentreSurLaPageDeRechercheDeVilles() throws Throwable {
        driver.get("http://localhost:8080");
    }

    @Quand("^j'entre la chaine (.*)$")
    public void jEntreLaChaineLev(String recherche) throws Throwable {
        driver.findElement(By.name("city")).sendKeys(recherche);
    }

    @Alors("^je devrais trouver (.*) dans les résultats de ville$")
    public void jeDevraisTrouverDansLesRésultatsDeVille(String resultat) throws Throwable {
        wait.until((ExpectedCondition<Boolean>) webdriver -> webdriver.findElement(By.className("row")) != null);

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(resultat));

        driver.close();
    }

    @Alors("^je ne devrais avoir aucun résultat$")
    public void jeNeDevraisAvoirAucunRésultat() throws Throwable {
        assertCssClassNotPresent(driver, "villes");
    }

    public static void assertCssClassNotPresent(WebDriver driver, String cssClass) {
        try {
            driver.findElement(By.className(cssClass));
            fail(cssClass + " is present");
        } catch (NoSuchElementException ex) {
        /* do nothing, css class is not present, assert is passed */
        }
    }
}
