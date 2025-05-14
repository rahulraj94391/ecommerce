package com.org.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PingController {
    @GetMapping(value = {"/", "/ping", "/health"})
    public Map<String, String> ping() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "rahul-18968");
        map.put("status", "alive");
        return map;
    }
}
