package p13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import p13.pojo.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ConverterController {

//    http://localhost:8109/SSMStudy_war_exploded/toAddGoods

    @RequestMapping("/toAddGoods")
    public String toAddGoods(){
        return "addGoods";
    }

    @RequestMapping("/addGoods")
    public String addGoods(Goods goods, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model)throws Exception{
        String goodsname = goods.getGoodsname();
        Double goodsprice = goods.getGoodsprice();
        Integer goodsnumber = goods.getGoodsnumber();
        model.addAttribute("goods",goods);
        return "success";
    }

}
