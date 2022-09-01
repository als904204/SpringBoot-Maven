package com.youtube.aroundhub.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("hello")
    public String Hello() {
        return "hello";
    }

    @PostMapping("log-test")
    public void logTest() {
        LOGGER.trace("Trace log");
        LOGGER.debug("Debug log");
        LOGGER.info("Info log");
        LOGGER.warn("Warn log");
        LOGGER.error("Error log");
    }

    @PostMapping("/exception")
    public void exceptionTest() throws Exception {
        throw new Exception();
    }

    /**
     * 주석처리시 @RestControllerAdvice 호출
     * **/
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//
//        LOGGER.info(e.getMessage());
//        LOGGER.info("Controller 내 ExceptionHandler 호출");
//
//        Map<String, String> map = new HashMap<>();
//        map.put("error type", httpStatus.getReasonPhrase());
//        map.put("code", "400");
//        map.put("message", "에러 발생");
//        return new ResponseEntity<>(map, responseHeaders, httpStatus);
//    }
}
