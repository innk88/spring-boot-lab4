package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/getModifiedData")
    public Map<String, String> getModifiedData() {
        String apiUrl = "http://www.mocky.io/v2/5c7db5e13100005a00375fda";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> response = restTemplate.getForObject(apiUrl, HashMap.class);
        for (Map.Entry<String, String> entry : response.entrySet()) {
            entry.setValue(entry.getValue().replace(" ", "_"));
        }
        return response;
    }
}

