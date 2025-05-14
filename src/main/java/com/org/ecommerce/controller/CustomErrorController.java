package com.org.ecommerce.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest webRequest) {
        Throwable error = errorAttributes.getError(webRequest);
        Map<String, Object> response = Map.of(
                "status", 500,
                "message", error != null ? error.getMessage() : "Unknown error"
        );
        return ResponseEntity.status(500).body(response);
    }
}
