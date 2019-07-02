package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/auth/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

//    @GetMapping("date")
//    public ResponseDto getProductsByDate(@RequestParam("date") String date) {
//
//
//    }

}
