package com.nathan.unsubscribe.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "unsubscribe_uri")
@NoArgsConstructor
@AllArgsConstructor
public class UnsubscribeURI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uri", nullable=false)
    private String uri;

    @Column(name="host")
    private String host;

    @ManyToOne
    @JoinColumn(name="email_id", nullable=false)
    private Emails emails;

    @ManyToOne
    @JoinColumn(name="vendor_id")
    private Vendors vendors;
}


