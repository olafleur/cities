package com.olivierlafleur.cities.cucumber;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Étantdonné;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
    private WebDriver driver = new ChromeDriver();
    private Wait<WebDriver> wait = new WebDriverWait(driver, 3);

    @Étantdonné("^que je vais à l'adresse (.*)$")
    public void queJeVaisÀLAdresse(String url) throws Throwable {
        driver.get(url);
    }

    @Quand("^j'entre le terme de recherche (.*)$")
    public void jEntreLeTermeDeRecherche(String terme) throws Throwable {
        driver.findElement(By.name("q")).sendKeys(terme);
    }

    @Alors("^je devrais trouver (.*) dans les résultats de recherche$")
    public void jeDevraisTrouverDansLesRésultatsDeRecherche(String resultat) throws Throwable {
        wait.until((ExpectedCondition<Boolean>) webdriver -> {
            System.out.println("Je cherche...");
            return webdriver.findElement(By.id("resultStats")) != null;
        });

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(resultat));

        driver.close();
    }

    @Et("^que je clique sur le bouton de recherche$")
    public void queJeCliqueSurLeBoutonDeRecherche() throws Throwable {
        driver.findElement(By.name("btnG")).click();
    }

    @Alors("^je ne devrais pas trouver (.*) dans les résultats de recherche$")
    public void jeNeDevraisPasTrouverBonjourDansLesRésultatsDeRecherche(String resultat) throws Throwable {
        wait.until((ExpectedCondition<Boolean>) webdriver -> {
            System.out.println("Je cherche...");
            return webdriver.findElement(By.id("resultStats")) != null;
        });

        Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains(resultat));

        driver.close();
    }
}