package com.ssm.action;

import com.alibaba.fastjson.JSON;
import com.ssm.domain.User;
import com.ssm.service.UserService;
import com.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/action/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session, String name, String pass) throws SQLException {
        User user = userService.login(name, pass);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/action/dept/showDept.do";
        } else
            return "redirect:/login.jsp";
    }

    @RequestMapping("/find")
    public void find(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "rows", defaultValue = "10") Integer pageSize, User user, HttpServletResponse response) throws IOException {
        PageBean<User> pageBean = userService.findUsersByPage(page, pageSize);
        System.out.println(pageSize);
        String json = "{\"total\":" + pageBean.getTotalRecords() + ",\"rows\":";
        json += JSON.toJSONString(pageBean.getData());
        json += "}";
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    @RequestMapping("/update")
    public void update(User user, HttpServletResponse response) throws IOException {
        String json = "{";
        System.out.println(user);
        boolean res = userService.update(user.getId(), user);
        if (res)
            json += "\"status\":true," + "\"errorMsg\":\"修改成功\"}";
        else
            json += "\"status\":false," + "\"errorMsg\":\"修改失败\"}";
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    @RequestMapping("/add")
    public void add(User user, HttpServletResponse response) throws IOException {
        String json = "{";
        System.out.println(user);
        boolean res = userService.add(user);
        if (res)
            json += "\"status\":true," + "\"msg\":\"添加成功\"}";
        else
            json += "\"status\":false," + "\"msg\":\"添加失败\"}";
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    @RequestMapping("/delete")
    public void delete( Integer id,HttpServletResponse response) throws IOException {
        String json = "{";
        boolean res = userService.delete(id);
        if (res)
            json += "\"status\":true," + "\"msg\":\"删除成功\"}";
        else
            json += "\"status\":false," + "\"msg\":\"删除失败\"}";
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }
}
