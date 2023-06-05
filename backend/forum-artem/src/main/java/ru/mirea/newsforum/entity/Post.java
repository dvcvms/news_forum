package ru.mirea.newsforum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String header;
    private String content;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GroupEntity> groups;
    private String imageUrl;
    private int course;
}
