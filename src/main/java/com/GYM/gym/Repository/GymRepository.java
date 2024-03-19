package com.GYM.gym.Repository;

import com.GYM.gym.Entity.Gym;
import com.GYM.gym.Entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GymRepository extends JpaRepository<Gym,Integer> {
    @Query(value = "select count (TrainerId) as numoftrainer from(select TrainerId from gym group by TrainerId having count (distinct GymId)>5) as trainermorethan5",nativeQuery = true)
    public List<Trainer> findnumberoftrainer();
}
