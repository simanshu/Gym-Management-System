package com.GYM.gym.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gym")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gym {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer GymId;
    String GymName;

    String Address;

    @OneToMany(mappedBy = "gym",cascade=CascadeType.ALL)
    List<Member> memberList=new ArrayList<>();

    @ManyToMany
    List<Trainer> trainerList=new ArrayList<>();
}
