package com.nathan.unsubscribe.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "email_labels")
@NoArgsConstructor
@AllArgsConstructor
public class EmailLabels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="label")
    private String label;

    @ManyToOne
    @JoinColumn(name="email_id", nullable=false)
    private Emails emails;
}

