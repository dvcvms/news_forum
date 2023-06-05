package ru.mirea.newsforum.service;


import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.entity.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);
    List<Post> findAllPosts();
    Post findById(long id);
    void deleteById(long id);
    List<Post> findByGroup(GroupEntity group);
    List<Post> findPostByCourseOrGroup(int course, GroupEntity group);
}
