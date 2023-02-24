package hcmute.edu.haovu.demo_template.model;

import hcmute.edu.haovu.demo_template.entities.ProductEntity;
import lombok.Data;

@Data
public class LineItem {
    ProductEntity product;
    long quantity;

    public LineItem(ProductEntity product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
