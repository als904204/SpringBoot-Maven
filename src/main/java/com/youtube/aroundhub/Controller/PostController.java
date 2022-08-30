package com.youtube.aroundhub.Controller;

import com.youtube.aroundhub.Dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api/v1/post-api")
@RestController
public class PostController {


    // http://localhost:8080/api/v1/post-api/default
    @PostMapping("/default")
    public String postMethod() {
        return "hello";
    }

    // http://localhost:8080/api/v1/post-api/member1
    @PostMapping("/member1")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }


}
