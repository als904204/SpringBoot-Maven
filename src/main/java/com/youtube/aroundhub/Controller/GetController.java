package com.youtube.aroundhub.Controller;

import com.youtube.aroundhub.Dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // api/v1/get-api/hello
    @GetMapping("/hello")
    public String getHello() {
        return "getHello";
    }

    // api/v1/get-api/name
    @GetMapping("/name")
    public String getName() {
        return "getHello";
    }

    // api/v1/get-api/variable1/{String}
    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // api/v1/get-api/variable2/{String}
    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // api/v1/get-api/variable2/request1?
    // name="userName"&
    // email=myEmail@test.com&
    // organization=youtube
    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // // api/v1/get-api/variable2/request2?key1=value1&key2=value2
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // api/v1/get-api/variable2/request3?
    // name="userName"&
    // email=myEmail@test.com&
    // organization=youtube
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}