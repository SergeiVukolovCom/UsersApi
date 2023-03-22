package com.a1qa.l2project2.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestsData {
    String urlPosts;
    String urlUsers;
    String body;
    Integer numberUser;
    Integer numberOfUsers;
    Integer incorrectUser;
    Integer code200;
    Integer code201;
    Integer code404;
    Integer userId;
    Integer id;
    Integer length;
    Integer postUserId;
}
