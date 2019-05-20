package com.younggam.morethanchat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public ResponseEntity getTest() {
        return new ResponseEntity("test api [get] 호출에 성공했습니다.", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postTest() {
        return new ResponseEntity("test api [post] 호출에 성공했습니다.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity putTest() {
        return new ResponseEntity("test api [put] 호출에 성공했습니다.", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTest() {
        return new ResponseEntity("test api [delete] 호출에 성공했습니다.", HttpStatus.OK);
    }
}
