package polteq.webshop.target;

import net.serenitybdd.screenplay.targets.Target;

public class Product {
    public static Target FIRST_PRODUCT = Target.the("first product")
            .locatedBy("//a[contains(@class, 'product-thumbnail')]");
    public static Target TOTAL_PRODUCTS_TEXT = Target.the("'amount of products' text")
            .locatedBy("//div[contains(@class, 'total-products')]//p");
    public static Target PRODUCT_TITLES = Target.the("product titles")
            .locatedBy("//*[contains(@class, 'product-title')]");

    public static Target numberOnPage(int nrOnPage) {
        return Target.the(String.format("product %d on the page", nrOnPage))
            .locatedBy(String.format("(//a[contains(@class, 'product-thumbnail')])[%d]", nrOnPage));
    }
}