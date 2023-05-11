package WebProject.TodoList.service;

import WebProject.TodoList.domain.ListComp;
import WebProject.TodoList.repository.MemoryListCompRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListCompServiceTest {
    ListCompService listCompService;
    MemoryListCompRepository listCompRepository;

    @BeforeEach
    public void BeforeEach(){
        listCompRepository = new MemoryListCompRepository();
        listCompService = new ListCompService(listCompRepository);
    }

    @AfterEach
    public void afterEach(){
        listCompRepository.clearStore();
    }

    @Test
    public void addNew() throws Exception{
        ListComp listComp = new ListComp();
        listComp.setContent("test1");

        Long saveNum = listCompService.add(listComp);

        ListComp findList = listCompRepository.findByNum(saveNum).get();
        assertEquals(listComp.getContent(), findList.getContent());
    }
}
