import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    public static List<String> searchProducts(List<String> products, String keyword) {
        List<String> result = new ArrayList<>();
        for (String product : products) {
            if (product.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}
