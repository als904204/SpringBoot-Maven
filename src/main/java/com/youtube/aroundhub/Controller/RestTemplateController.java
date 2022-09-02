package com.youtube.aroundhub.Controller;

import com.youtube.aroundhub.Dto.MemberDto;
import com.youtube.aroundhub.data.Service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-template")
public class RestTemplateController {
    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/around-hub")
    public String getAroundHub() {
        return restTemplateService.getAroundHub();
    }


    @GetMapping("/name")
    public String getName() {
        return restTemplateService.getName();
    }

    @GetMapping("/name2")
    public String getName2() {
        return restTemplateService.getName2();
    }

    @PostMapping("/dto")
    public ResponseEntity<MemberDto> postDto() {
        return restTemplateService.postDto();
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDto> addHeader() {
        return restTemplateService.addHeader();
    }
}
