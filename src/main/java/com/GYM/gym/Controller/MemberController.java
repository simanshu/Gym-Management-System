package com.GYM.gym.Controller;


import com.GYM.gym.Entity.Member;
import com.GYM.gym.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("memeber")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("AddMember")
    public ResponseEntity AddMember(Member member){
        String res=memberService.AddMember(member);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @GetMapping("findmemberwhoisusemostTrainer")
    public ResponseEntity findmemberwhoisusemostTrainer(){
        Member res=memberService.findmemberWhoisUsemostTrainer();
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
