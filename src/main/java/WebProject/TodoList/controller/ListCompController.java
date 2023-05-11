package WebProject.TodoList.controller;

import WebProject.TodoList.domain.ListComp;
import WebProject.TodoList.service.ListCompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ListCompController {
    private final ListCompService listCompService;

    @Autowired
    public ListCompController(ListCompService listCompService){
        this.listCompService = listCompService;
    }

    @GetMapping("/lists")
    public String list(Model model){
        List<ListComp> lists = listCompService.findAll();
        model.addAttribute("lists", lists);
        return "todolist";
    }
}
