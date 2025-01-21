package com.edureka.CustomerAPI.client;

import com.edureka.CustomerAPI.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "InventoryAPI", url = "http://localhost:8081")
public interface InventoryAPIClient {
        @GetMapping("/api/inventory")
        InventoryResponse isInStock(@RequestParam List<Integer> itemIds);
}
