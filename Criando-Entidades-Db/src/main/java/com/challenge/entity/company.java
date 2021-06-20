package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String slug;

    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<candidate> candidates;
}
