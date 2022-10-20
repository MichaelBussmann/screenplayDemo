package polteq.webshop.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import polteq.webshop.target.Search;

public class SearchTheWebsite  implements Task {
    String searchString;

    @Step("{0} is search #searchString on the website")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(searchString).into(Search.SEARCH_INPUT));
        actor.attemptsTo(Hit.the(Keys.ENTER).into(Search.SEARCH_INPUT));
    }

    public SearchTheWebsite(String searchString) { this.searchString = searchString; }

    public static Task withValue(String searchString) {
        return Instrumented.instanceOf(SearchTheWebsite.class).withProperties(searchString);
    }
}
