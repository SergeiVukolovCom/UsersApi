package com.a1qa.l2project2.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;

}
