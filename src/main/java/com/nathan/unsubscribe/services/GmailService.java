package com.nathan.unsubscribe.services;

import com.nathan.unsubscribe.dtos.EmailDTO;
import com.nathan.unsubscribe.dtos.GmailProfile;
import com.nathan.unsubscribe.dtos.UnsubscribeUri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GmailService {

    @Autowired
    private GmailApiClient gmailApiClient;

    // Fetch the user's Gmail profile.
    public GmailProfile getProfile() {
        return gmailApiClient.getProfile();
    }

    // List all emails from the Gmail API.
    public List<EmailDTO> listMessages() {
        return (List<EmailDTO>) gmailApiClient.listMessages();
    }

    // Fetch a specific message by its ID.
    public EmailDTO getMessage(String messageId) {
        return gmailApiClient.getMessage(messageId);
    }

    // Extract unsubscribe URIs from all emails.
    public List<UnsubscribeUri> extractUnsubscribeUris() {
        List<EmailDTO> emails = (List<EmailDTO>) gmailApiClient.listMessages();
        return emails.stream()
                .flatMap(email -> extractUnsubscribeUriFromEmail(email).stream())
                .toList();
    }

    // Extract unsubscribe URIs from a single email.
    private List<UnsubscribeUri> extractUnsubscribeUriFromEmail(EmailDTO email) {
        // TODO: Need Logic to scan email body for unsubscribe URIs (searching for keywords)
        return List.of(); // Placeholder for unsubscribe URIs extraction logic
    }
}

