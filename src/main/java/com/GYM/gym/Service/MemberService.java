package com.GYM.gym.Service;

import com.GYM.gym.Entity.Member;
import com.GYM.gym.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;


    public String AddMember(Member member){
        memberRepository.save(member);
        return "Member Added Sucessfully";
    }
    public Member findmemberWhoisUsemostTrainer(){
        List<Member> memberList=memberRepository.findAll();

        Member member=null;
        int mostmember=0;

        for(Member member1:memberList){
            int trainercount=member1.getTrainerList().size();
            if(trainercount>mostmember){
                mostmember=trainercount;
                member=member1;
            }

        }
        return member;

    }
}
