package ru.mirea.newsforum.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDTO {
    private String header;
    private String content;
    private List<String> groups;
    private String imageUrl;
    private int course;
}
