package polteq.webshop.target;

import net.serenitybdd.screenplay.targets.Target;

public class Search {
    public static Target SEARCH_INPUT = Target.the("Search input")
            .locatedBy("//input[@name='s']");
}
