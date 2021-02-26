package com.challenge.orderIssuingApi.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value="/")
public class HomeResource {

    @ApiOperation("Página inicial")
    @GetMapping
    public String getHello() {
        return "We are issuing orders!";
    }
}