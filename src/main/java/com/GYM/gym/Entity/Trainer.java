package com.GYM.gym.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer TrainerId;
    String Name;

    @ManyToMany
    List<Gym> gymList=new ArrayList<>();

    @ManyToOne
    Member member;



}
