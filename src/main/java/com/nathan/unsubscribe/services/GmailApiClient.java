package com.nathan.unsubscribe.services;

import com.nathan.unsubscribe.dtos.EmailDTO;
import com.nathan.unsubscribe.dtos.GmailProfile;
import com.nathan.unsubscribe.dtos.ListMessagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class GmailApiClient {

    private static final String BASE_URL = "https://gmail.googleapis.com/gmail/v1/users/";
    private static final String USER_ID = "me"; // This is the authenticated user

    @Autowired
    private RestTemplate restTemplate;

    // Get the current user's Gmail profile
    public GmailProfile getProfile() {
        String url = BASE_URL + USER_ID + "/profile";
        ResponseEntity<GmailProfile> response = restTemplate.getForEntity(url, GmailProfile.class);
        return response.getBody();
    }

    // List all messages in the user's Gmail account.
    public Object listMessages() {
        String url = BASE_URL + USER_ID + "/messages";
        ResponseEntity<ListMessagesResponse> response = restTemplate.getForEntity(url, ListMessagesResponse.class);
        ListMessagesResponse listResponse = response.getBody();

        return listResponse != null ? listResponse : new ArrayList<>();
    }

    // Get a specific email message by its ID.
    public EmailDTO getMessage(String messageId) {
        String url = BASE_URL + USER_ID + "/messages/" + messageId;
        ResponseEntity<EmailDTO> response = restTemplate.getForEntity(url, EmailDTO.class);
        return response.getBody();
    }

}

