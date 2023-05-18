package WebProject.TodoList.controller;

import WebProject.TodoList.domain.ListComp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    public static List<ListComp> comps = new ArrayList<>();
    @GetMapping("/")
    public String home(){
        comps.add(new ListComp("Make To-Do List"));
        comps.add(new ListComp("Study English"));
        comps.add(new ListComp("Update Linked-in"));
        comps.add(new ListComp("Algorithm Study"));
        return "todolist";
    }

}
