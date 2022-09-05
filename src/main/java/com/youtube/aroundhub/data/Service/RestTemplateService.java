package com.youtube.aroundhub.data.Service;

import com.youtube.aroundhub.Dto.FIFADto;
import com.youtube.aroundhub.Dto.MemberDto;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {

    public String getAroundHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDto> postDto();

    public ResponseEntity<MemberDto> addHeader();


}
