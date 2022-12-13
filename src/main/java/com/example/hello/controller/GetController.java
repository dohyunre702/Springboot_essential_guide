package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    //1.매개변수 없는 get 메서드 구현
    @GetMapping("/name")
    public String getName() {
        return "Flature";
    }

    //2-1.PathVariable(url 자체에 파라미터 담아 요청)
    @GetMapping("/variable1/{test}")
    public String getVariable(@PathVariable String test) {
        return test;
    }

    //2-2.PathVariable(변수명 매핑)
    @GetMapping("/variable2/{test2}")
    public String getVariable2(@PathVariable("test2") String var) {
        return var;
    }

    //3-1. @RequestParam(url에 쿼리 형식으로 값 전달)
    //http://localhost:8080/api/v1/get-api/request1?name=value&email=value2&organization=value3
    @GetMapping("/request1")
    //1.
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //3-2. @RequestParam(쿼리에 어떤 값이 들어올지 모르는 경우, map 객체 활용 가능)
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping("request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

}
