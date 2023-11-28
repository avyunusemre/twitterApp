package com.techpro.twitter.services.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String text;
    private Long userId;
}
