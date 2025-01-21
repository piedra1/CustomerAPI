package com.edureka.CustomerAPI.dto;


import java.util.List;


public class InventoryResponse {

    List<ProductInventory> productInventories;

    /**/

    public List<ProductInventory> getProductInventories() {
        return productInventories;
    }

    public void setProductInventories(List<ProductInventory> productInventories) {
        this.productInventories = productInventories;
    }
}
