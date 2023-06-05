package ru.mirea.newsforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.newsforum.entity.GroupEntity;


@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, String> {
}
