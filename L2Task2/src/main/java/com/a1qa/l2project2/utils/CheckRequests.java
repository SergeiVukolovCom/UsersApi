package com.a1qa.l2project2.utils;

import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.requests.ApiApplicationRequests;
import java.util.List;

public class CheckRequests {
    public static boolean checkOfSortUsers() {
        List<Post> posts = ApiApplicationRequests.getAllPosts();
        for (int i = 0; i < posts.size() - 1; i++) {
            if (posts.get(i).getId() < posts.get(i + 1).getId()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
