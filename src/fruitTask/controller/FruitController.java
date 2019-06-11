package fruitTask.controller;

import fruitTask.domain.Fruit;
import fruitTask.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FruitController {
    private FruitService fruitService = new FruitService();
    @RequestMapping(value = "/fruitController")
    public String handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) throws Exception {
        List<Fruit> fruitList=fruitService.queryFruitList();
        model.addAttribute("fruitList",fruitList);
        return "/index.jsp";
    }
}
