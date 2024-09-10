package com.nathan.unsubscribe.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "emails")
@NoArgsConstructor
@AllArgsConstructor
public class Emails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="message_id", nullable=false, unique=true)
        private String messageId;

        @Column(name="thread_id")
        private String threadId;

        @Column(name="sender_email")
        private String senderEmail;

        @Column(name="reply_to")
        private String replyTo;

        @Column(name="subject")
        private String subject;

        @Column(name="date_received")
        private LocalDateTime dateReceived;

        @Column(name="has_unsubscribe_uri")
        private Boolean hasUnsubscribeUri;

        @ManyToOne
        @JoinColumn(name = "vendor_id")
        private Vendors vendors;

        @OneToMany(mappedBy = "emails", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<UnsubscribeURI> unsubscribeUris;

        @OneToMany(mappedBy = "emails", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<EmailLabels> labels;

        @OneToMany(mappedBy = "emails", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<EmailParts> parts;

}
