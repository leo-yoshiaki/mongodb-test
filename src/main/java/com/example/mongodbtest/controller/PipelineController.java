package com.example.mongodbtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pipeline")
public class PipelineController {

    @GetMapping
    public String helloPipeline() {
        return "Oi pipeline CI!";
    }
}
