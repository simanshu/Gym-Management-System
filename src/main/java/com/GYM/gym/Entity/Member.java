package com.GYM.gym.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer MemberId;
    String Name;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;


    @OneToMany(mappedBy = "member",cascade=CascadeType.ALL)
    List<Trainer> trainerList=new ArrayList<>();


}
