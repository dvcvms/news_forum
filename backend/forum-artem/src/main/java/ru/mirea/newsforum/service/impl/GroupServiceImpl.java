package ru.mirea.newsforum.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.exception.CustomException;
import ru.mirea.newsforum.repository.GroupRepository;
import ru.mirea.newsforum.service.GroupService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private Pattern pattern;

    @Override
    public GroupEntity save(GroupEntity group) {
        return groupRepository.save(group);
    }

    @Override
    public int parseCourse(String group) {
        pattern = Pattern.compile("^[a-zA-Zа-яА-Я]{4}-\\d{2}-\\d{2}$");
        //log.info("INFO: " + pattern.matcher(group).find());

        if (pattern.matcher(group).find()) {
            int year = LocalDate.now().getYear();

            return year - Integer.parseInt(
                    Integer.toString(year).substring(0, 2)
                            + group.substring(group.length() - 2)
            );
        }

        throw new CustomException("GROUP_IS_INVALID", "Группа была введена не корректно");
//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "GROUP_IS_INVALID");
    }

    @Override
    public List<GroupEntity> parseGroups(List<String> groupNumbers) {
        List<GroupEntity> groups = new ArrayList<>();
        for(String groupNumber: groupNumbers) {
            groups.add(groupRepository.findById(groupNumber).orElseThrow(() -> new CustomException("GROUP_NOT_FOUND", "Группа не найдена")));
        }

        return groups;
    }

    @Override
    public GroupEntity parseGroup(String groupNumber) {
        return groupRepository.findById(groupNumber).orElseThrow(() -> new CustomException("GROUP_NOT_FOUND", "Группа не найдена"));
    }
}
