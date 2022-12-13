package com.example.hello.controller;

import com.example.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

//delete api: 웹 애플리케이션 서버를 거쳐 DB 등의 저장소에 있는 리소스를 삭제할 때 사용
//get 메서드와 같이 URI에 값을 넣어 요청을 받는 형식으로 구현
@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    //1.@PathVariable
    //http://localhost:8080/api/v1/delete-api/{string값}
    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

    //2.@RequestParam 활용
    //http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping("/request1")
    public String getRequestParam(@RequestParam String email) {
        return "e-mail : " + email;
    }

    //3.@Dto객체 매핑
    @DeleteMapping("/request2")
    public String getRequestParam2(MemberDto memberDto) {
        return memberDto.toString();
        //= return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
    }


}
