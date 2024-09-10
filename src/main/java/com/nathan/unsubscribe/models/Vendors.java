package com.nathan.unsubscribe.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vendors")
@NoArgsConstructor
@AllArgsConstructor
public class Vendors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "vendors", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emails> emails = new ArrayList<>();

}

