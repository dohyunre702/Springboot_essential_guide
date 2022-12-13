package com.example.hello.controller;

import com.example.hello.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//put api : 서버를 통해 db와 같은 저장소에 존재하는 리소스 값을 업데이트
//post api와 구현방식이 거의 비슷함 (이유: 리소스를 서버에 전달하기 위해 HTTP Body를 활용
@RestController
@RequestMapping("api/v1/put-api")
public class PutController {

    //1.Requestbody, map 활용
    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //2.Dto객체 활용 (1)String 반환. text/plain 형식으로 content type 전달
    @PutMapping("/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    //2.DTO객체 활용 (2)DTO객체 반환. application/json 형식으로 content type 전달
    //RequestMapping이 지정된 클래스는 @RequestBody를 생략할 수 있다
    //@RequestBody : 자동으로 값을 JSON과 같은 형식으로 변환해 전달
    @PutMapping("/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    //3. RequestEntity 활용
    //ResponseEntity, requestentity는 HttpEntity를 상속받아 구현한 클래스이다.
    //ResponseEntity: 서버에 들어온 요청에 대해 응답 데이터를 구성해 전달할 수 있다. 
    @PutMapping("/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //응답 상태코드 202
                .body(memberDto);
    }

}
