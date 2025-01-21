package com.edureka.CustomerAPI.service;

import com.edureka.CustomerAPI.client.InventoryAPIClient;
import com.edureka.CustomerAPI.client.OrderProcessingAPIClient;
import com.edureka.CustomerAPI.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    private InventoryAPIClient inventoryAPIClient;

    @Autowired
    private  OrderProcessingAPIClient orderProcessingAPIClient;
    @Autowired
    public CustomerService(InventoryAPIClient inventoryAPIClient) {
        this.inventoryAPIClient = inventoryAPIClient;
    }

    public String placeOrder(OrderRequest orderRequest) {
        // Check if items present in inventory

        InventoryResponse inventoryResponses = inventoryAPIClient.isInStock(orderRequest.getProducts().stream().map(Product::getItemID).collect(Collectors.toList()));

        List<ProductInventory> productInventories = inventoryResponses.getProductInventories().stream().filter(ProductInventory::isAvailable).collect(Collectors.toList());

        List<Product> productList = orderRequest.getProducts().stream().filter(product -> productInventories.contains(product.getItemID())).collect(Collectors.toList());

        // If present call Order API
        OrderResponse orderResponse = orderProcessingAPIClient.orderProducts(orderRequest);

        return orderResponse.getResponse();

    }
}
