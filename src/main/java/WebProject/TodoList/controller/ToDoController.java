package WebProject.TodoList.controller;

import WebProject.TodoList.domain.ListComp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {

    public static List<ListComp> comps = new ArrayList<>();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        comps.add(new ListComp("Make To-Do List"));
        comps.add(new ListComp("Study English"));
        comps.add(new ListComp("Update Linked-in"));
        comps.add(new ListComp("Algorithm Study"));

        model.addAttribute("comps", comps);
        return "todolist";
    }

}
