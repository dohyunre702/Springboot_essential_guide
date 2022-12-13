package com.example.hello.controller;

import com.example.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//postapi: 저장하고자 하는 리소스나 값을 HTTP 바디(body)에 담아 서버에 전달한다.
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //1. RequestMapping 구현
    @RequestMapping(value="/domain", method= RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    //2. RequestBody + map 객체로 구현 (http://localhost:8080/api/v1/post-api/member)
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        //RequestBody: HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //3. Dto 객체 활용한 구현
    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
        //결과 : MemberDto{name='Flature', email='thinkground@gmail.com', organization='Aroud Hub Studio'} 로 출력됨
    }
}
