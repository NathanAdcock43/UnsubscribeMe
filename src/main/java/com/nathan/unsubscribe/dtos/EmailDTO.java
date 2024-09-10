package com.nathan.unsubscribe.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDTO {
    private String messageId;
    private String threadId;
    private String subject;
    private String sender;
    private String date;
    private String replyTo;
    private List<String> labelIds;
    private String body;
}

