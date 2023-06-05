package ru.mirea.newsforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostByCourseOrGroupsContains(int course, GroupEntity group);
    List<Post> findByGroupsContains(GroupEntity group);
}
