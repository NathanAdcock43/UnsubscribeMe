package com.nathan.unsubscribe.models;

import jakarta.persistence.*;

@Entity
public class UnsubscribeURI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;
    private String host;

    @ManyToOne
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;
    // Getters and Setters
}

