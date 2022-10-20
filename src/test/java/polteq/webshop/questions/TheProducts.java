package polteq.webshop.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import polteq.webshop.target.Product;

import java.util.List;

public class TheProducts implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
        return (Product.PRODUCT_TITLES).resolveAllFor(actor).texts();
    }

    public static Question<List<String>> displayed() {
        return new TheProducts();
    }
}
