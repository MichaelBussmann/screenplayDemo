package polteq.webshop.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.Keys;
import polteq.webshop.targets.PolteqTestShop;
import polteq.webshop.targets.Product;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static polteq.webshop.targets.Product.FIRST_PRODUCT;
import static org.hamcrest.Matchers.*;
import static polteq.webshop.targets.Search.SEARCH_INPUT;

public class PolteqWebshopStepDefinitions {
    private WebDriver theBrowser;
    private PolteqTestShop polteqTestShop;

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new Cast());
    }

    @Given("{actor} has opened the Polteq webshop")
    public void actorHasOpenedThePolteqWebshop(Actor actor) {
        actor.can(BrowseTheWeb.with(theBrowser));
        actor.attemptsTo(Open.browserOn().the(polteqTestShop));
    }

    @And("{actor} opens the first product on the page")
    public void actorOpensTheFirstProductOnThePage(Actor actor) {
        actor.attemptsTo(Click.on(FIRST_PRODUCT).afterWaitingUntilPresent());
        //actor.attemptsTo(Click.on(Product.numberOnPage(1)).afterWaitingUntilPresent());
    }

    @When("{actor} searches for {string}")
    public void heSearchesForTShirt(Actor actor, String searchString) {
        actor.attemptsTo(Enter.theValue(searchString).into(SEARCH_INPUT));
        actor.attemptsTo(Hit.the(Keys.ENTER).into(SEARCH_INPUT));
        //actor.attemptsTo(SearchTheWebsite.withValue(searchString));
    }

    @Then("{actor} should see that one product is found")
    public void heShouldSeeThatOnlyOneProductIsFound(Actor actor) {
        actor.should(seeThat(Text.of(Product.TOTAL_PRODUCTS_TEXT), equalTo("There is 1 product.")));
        //actor.should(seeThat(TheProducts.displayed(), hasSize(1)));
    }

    @Then("{actor} should see that {int} product(s) is/are found")
    public void heShouldSeeThatNumberOfItemsAreFound(Actor actor, int expectedNrOfProducts) {
        //todo
    }
}