package com.youtube.aroundhub.data.Service.Impl;

import com.youtube.aroundhub.Dto.MemberDto;
import com.youtube.aroundhub.data.Service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);


    // just rest controller
    @Override
    public String getAroundHub() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/around-hub")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class); // 요청결과값 String 받아옴


        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }


    // query parameter
    @Override
    public String getName() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/name")
                .queryParam("name","ronnie")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class); // 요청결과값 String 받아옴


        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    // @@PathVariable
    @Override
    public String getName2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/path-variable/{name}")
                .encode()
                .build()
                .expand("Ronnie") // 복수의 값을 넣어야할 경우 , 사용
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class); // 요청결과값 String 받아옴


        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDto> postDto() {

        // queryParam 으로 전송
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/member")
                .queryParam("name","Ronnie")
                .queryParam("email","Ronnie@muscle.com")
                .queryParam("organization","Around Hub Studio")
                .encode()
                .build()
                .toUri();


        // Dto 객체로 전송
        MemberDto memberDto = new MemberDto();
        memberDto.setName("Ronnie..!");
        memberDto.setEmail("protein@working.out");
        memberDto.setOrganization("Around hub Studio");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDto> responseEntity = restTemplate.postForEntity(uri,memberDto ,MemberDto.class); // 요청결과값 String 받아옴


        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDto> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/add-header")
                .encode()
                .build()
                .toUri();


        MemberDto memberDto = new MemberDto();
        memberDto.setName("Ronnie..!");
        memberDto.setEmail("proteinHeader@working.out");
        memberDto.setOrganization("Around hub Studio");

        RequestEntity<MemberDto> requestEntity = RequestEntity
                .post(uri)
                .header("around-header", "Around Hub Studio")
                .body(memberDto);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDto> responseEntity = restTemplate.exchange(requestEntity, MemberDto.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
