package bbs.controller;

import bbs.domain.Forum;
import bbs.domain.User;
import bbs.service.ForumService;
import bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,String account,String password)throws IOException{
        boolean flag=userService.login(account, password);
        if(flag) {
            User user=userService.getUserByAccount(account);
            request.getSession().setAttribute("user", user);
            return "redirect:/index";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mav= new ModelAndView("index");
        List<Forum>forums=forumService.getAllForums();
        mav.addObject("forums",forums);
        return mav;
    }

    @RequestMapping("forumInfo.do")
    public ModelAndView forumInfo(int forum_id) {
        ModelAndView modelAndView=new ModelAndView("forumInfo");
        List<Map>posts=forumService.getPosts(forum_id);
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }

    @RequestMapping("modifyUser.do")
    public String modifyUser(HttpServletRequest request,@RequestParam(value="file",required=false)MultipartFile file,String nickname) throws IllegalStateException, IOException {
        User user=(User)request.getSession().getAttribute("user");
        if(file!=null && !file.getOriginalFilename().equals("")) {
            String originalFileName=file.getOriginalFilename();
            String newFileName=UUID.randomUUID()+originalFileName;
            System.out.println(newFileName);
            String filePath=request.getSession().getServletContext().getRealPath("/")+"/img/"+newFileName;
            System.out.println(filePath);
            file.transferTo(new File(filePath));
            user.setAvatar(newFileName);
        }
        // user.setNickname(nickname);//重新设置昵称
        userService.updateUser(user);
        request.getSession().setAttribute("user", user);
        return "redirect:/index.do";
    }

}
