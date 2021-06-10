package seller;

import java.util.List;

public interface SellerObserver {
    void updateProducts(List<Product> products);
}
