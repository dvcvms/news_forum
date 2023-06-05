package ru.mirea.newsforum.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.entity.Post;
import ru.mirea.newsforum.exception.CustomException;
import ru.mirea.newsforum.repository.PostRepository;
import ru.mirea.newsforum.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new CustomException("POST_NOT_FOUND", "Публикация не найдена"));
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findByGroup(GroupEntity group) {
        return postRepository.findByGroupsContains(group);
    }

    @Override
    public List<Post> findPostByCourseOrGroup(int course, GroupEntity group) {
        return postRepository.findPostByCourseOrGroupsContains(course, group);
    }
}
