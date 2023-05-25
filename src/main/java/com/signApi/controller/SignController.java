package com.signApi.controller;

import com.signApi.domain.dto.MemberDto;
import com.signApi.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class SignController {

    @Autowired
    SignService signService;
/*
    @PostMapping("/sign-in")
    public UserDetails signIn(@RequestBody MemberDto memberDto){
        return signService.signIn(memberDto);
    }
*/
    @PostMapping("/sign-up")
    public int signUp(@RequestBody MemberDto memberDto){
        return signService.sighUp(memberDto);
    }

    @GetMapping("/test")
    public String test(){
        return "로그인 실패";
    }
}
