package com.linkedkwon.tech.model.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Builder
    public User(String name) {
        this.name = name;
    }

}