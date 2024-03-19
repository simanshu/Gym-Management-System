package com.GYM.gym.Repository;

import com.GYM.gym.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    @Query(value = "select GymName,count (*) as total_member from member group by GymName limit 1",nativeQuery = true)
    public String findgym();

}
