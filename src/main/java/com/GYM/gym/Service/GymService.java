package com.GYM.gym.Service;

import com.GYM.gym.Entity.Gym;
import com.GYM.gym.Repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    GymRepository gymRepository;

    public String AddGym(Gym gym){
        gymRepository.save(gym);
        return "Gym Added Sucessfully";
    }

    public Gym findGymWithMostMembers() {
        List<Gym> gyms = gymRepository.findAll();

        Gym gymWithMostMembers = null;
        int maxMemberCount = 0;

        for (Gym gym : gyms) {
            int memberCount = gym.getMemberList().size();
            if (memberCount > maxMemberCount) {
                maxMemberCount = memberCount;
                gymWithMostMembers = gym;
            }
        }

        return gymWithMostMembers;
    }


}
