import java.util.Arrays;
import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        List<String> products = Arrays.asList(
                "Red T-Shirt", "Blue Jeans", "Black Shoes", "White Hat", "Green Socks");

        String keyword = "sh";

        List<String> result = ProductSearch.searchProducts(products, keyword);

        for (String product : result) {
            System.out.println(product);
        }
    }
}
