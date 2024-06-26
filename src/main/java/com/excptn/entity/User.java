package com.excptn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "USERS_TBL")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;
}
