package com.GYM.gym.Controller;

import com.GYM.gym.Entity.Trainer;
import com.GYM.gym.Service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping("AddTrainer")
    public ResponseEntity AddTrainer(Trainer trainer){
        String res=trainerService.AddTrainer(trainer);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @GetMapping("findnumofTrainer")
    public ResponseEntity findnumofTrainer(){
        int res=trainerService.NumberofTrainer();
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
