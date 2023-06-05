package ru.mirea.newsforum.service;


import ru.mirea.newsforum.entity.GroupEntity;

import java.util.List;

public interface GroupService {
    GroupEntity save(GroupEntity group);
    int parseCourse(String group);
    List<GroupEntity> parseGroups(List<String> groupNumbers);
    GroupEntity parseGroup(String groupNumber);
}
