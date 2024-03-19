package com.GYM.gym.Service;

import com.GYM.gym.Entity.Member;
import com.GYM.gym.Entity.Trainer;
import com.GYM.gym.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public String AddTrainer(Trainer trainer){
        trainerRepository.save(trainer);
        return "Trainner Added Sucessfully";
    }

   public int NumberofTrainer(){
       List<Trainer> trainerList=trainerRepository.findAll();

       int numoftrainer=0;
       for(Trainer trainer:trainerList){
           int gymcount=trainer.getGymList().size();
           if(gymcount<=5){
               numoftrainer++;
           }
       }
       return numoftrainer;
   }
   public int NumOfMember(){
       List<Trainer> trainerList=trainerRepository.findAll();

       int member=0;
       for(Trainer trainer:trainerList){
           int gym=trainer.getGymList().size();
           Member member1=trainer.getMember();
           if(gym<=1 && member1!=null){
               member++;
           }
       }
       return member;

   }
}
