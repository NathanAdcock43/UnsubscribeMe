package com.nathan.unsubscribe.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GmailProfile {
    private String emailAddress;
    private long messagesTotal;
    private long threadsTotal;
}

