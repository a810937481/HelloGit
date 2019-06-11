package p14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class TimeController {

    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    public String Rest(Model model){
        Date date = new Date(System.currentTimeMillis());
        model.addAttribute("d","现在是："+date+"，是下课时间。");
        System.out.println(date);
        return "rest";
    }

}
