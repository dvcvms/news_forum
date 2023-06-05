package ru.mirea.newsforum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class GroupEntity {
    @Id
    @Column(unique = true)
    private String groupNumber;
    private int course;
}
