package com.nathan.unsubscribe.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "email_parts")
@NoArgsConstructor
@AllArgsConstructor
public class EmailParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="part_id")
    private String partId;

    @Column(name="mime_type")
    private String mimeType;

    @Lob
    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name="email_id", nullable=false)
    private Emails emails;
}

