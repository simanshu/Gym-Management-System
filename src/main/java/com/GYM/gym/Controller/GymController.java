package com.GYM.gym.Controller;

import com.GYM.gym.Entity.Gym;
import com.GYM.gym.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("gym")
public class GymController {
    @Autowired
    GymService gymService;

    @PostMapping("AddGym")
    public ResponseEntity AddGym(Gym gym){
        String res=gymService.AddGym(gym);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @GetMapping("/numberoftrainer")
    public ResponseEntity findNumberOfTrainer(){
       Gym gymWithMostMembers=gymService.findGymWithMostMembers();
        return new ResponseEntity(gymWithMostMembers, HttpStatus.OK);
    }
}
