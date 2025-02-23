package com.edureka.CustomerAPI.client;

import com.edureka.CustomerAPI.dto.InventoryResponse;
import com.edureka.CustomerAPI.dto.OrderRequest;
import com.edureka.CustomerAPI.dto.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "OrderProcessingAPi", url = "http://localhost:8082")
public interface OrderProcessingAPIClient {



    @PostMapping("/api/order")
    OrderResponse orderProducts(@RequestBody OrderRequest orderRequest);
}
