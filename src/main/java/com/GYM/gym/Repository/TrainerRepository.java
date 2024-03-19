package com.GYM.gym.Repository;

import com.GYM.gym.Entity.Member;
import com.GYM.gym.Entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {

    @Query(value = "select member,count(distinct trainer_id) as numoftrainer from trainer group by member limit 1",nativeQuery = true)
    public String findmember();

    @Query(value = "select count (distinct MemberId)as numofmember from trainer where TrainerId in(select TrainerId from gym group by TrainerId having count (distinct GymId)>1)",nativeQuery = true)
    public List<Member> numberofmember();
}
