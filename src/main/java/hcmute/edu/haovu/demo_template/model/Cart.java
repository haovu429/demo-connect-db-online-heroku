package hcmute.edu.haovu.demo_template.model;

import hcmute.edu.haovu.demo_template.entities.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  List<LineItem> lineItemList = new ArrayList<>();
  long totalPrice = 0;

  public void addLineItem(ProductEntity product, long quantity) {
    boolean exists = false;
    for (LineItem lineItem : lineItemList) {
      if (lineItem.getProduct().getId() == product.getId()) {
        lineItem.setQuantity(lineItem.getQuantity() + quantity);
          exists = true;
      }
    }
    if (!exists) {
        LineItem newLineItem = new LineItem(product, quantity);
      lineItemList.add(newLineItem);
    }
  }
}
