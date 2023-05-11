package WebProject.TodoList.repository;

import WebProject.TodoList.domain.ListComp;

import java.util.List;
import java.util.Optional;

public interface ListRepository {
    ListComp save(ListComp comp);
    Optional<ListComp> findByNum(Long num);
    List<ListComp> findAll();
}
