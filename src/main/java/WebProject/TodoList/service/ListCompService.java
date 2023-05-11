package WebProject.TodoList.service;

import WebProject.TodoList.domain.ListComp;
import WebProject.TodoList.repository.ListRepository;
import WebProject.TodoList.repository.MemoryListCompRepository;

import java.util.List;
import java.util.Optional;

public class ListCompService {
    private final ListRepository listRepository;

    public ListCompService(ListRepository listRepository){
        this.listRepository = listRepository;
    }
    /* create new list*/
    public Long add(ListComp comp){
        listRepository.save(comp);
        return comp.getNum();
    }

    /* select all list*/
    public List<ListComp> findAll(){
        return listRepository.findAll();
    }

    /* find list with num */
    public Optional<ListComp> findByNum(Long listNum){
        return listRepository.findByNum(listNum);
    }
}
