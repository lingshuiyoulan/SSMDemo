package com.ssm.action;

import com.alibaba.fastjson.JSON;
import com.ssm.domain.AuthAndGroup;
import com.ssm.domain.Emp;
import com.ssm.domain.json.Menu;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/action/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/login")
    public String login(HttpSession session, String name, String pass) throws SQLException {
        Emp emp = empService.login(name, pass);
        if (emp != null) {
            session.setAttribute("user", emp);
            return "forward:/WEB-INF/manager/index.jsp";
        } else
            return "forward:/WEB-INF/manager/login.jsp";
    }

    @RequestMapping("/json")
    public void json(String empId, HttpServletResponse response) throws IOException {



        List<Menu> menuList = new ArrayList<>();

        String groupName = "";
        Menu mainMenu = null;
        List<Menu> secondMenuList = null;
        Menu secondMenu = null;

        List<AuthAndGroup> authInGroupById = empService.findAuthInGroupById(1);
        for (AuthAndGroup item:authInGroupById) {
            if (!groupName.equals(item.getGroupName())) {
                groupName = item.getGroupName();
                mainMenu = new Menu();
                mainMenu.setId(item.getAuthgroupId());
                mainMenu.setText(groupName);
                mainMenu.setState("open");
                secondMenuList = new ArrayList<>();
                mainMenu.setChildren(secondMenuList);
                menuList.add(mainMenu);
            }
            secondMenu = new Menu();
            secondMenu.setId(item.getId());
            secondMenu.setText(item.getName());
            Map<String, String> map = new HashMap<>();
            map.put("url", "../trans.do?url="+item.getUrl()+"/"+item.getOp()+".jsp");
            map.put("op", item.getOp());
            secondMenu.setAttributes(map);
            secondMenuList.add(secondMenu);
        }

        List<AuthAndGroup> authOutGroupById = empService.findAuthOutGroupById(1);
        for (AuthAndGroup item2: authOutGroupById) {
            mainMenu = new Menu();
            mainMenu.setId(item2.getId());
            mainMenu.setText(item2.getName());
            Map<String, String> map = new HashMap<>();
            map.put("url", item2.getUrl());
            map.put("op", item2.getOp());
            mainMenu.setAttributes(map);
            menuList.add(mainMenu);
        }

        String json = JSON.toJSONString(menuList);
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }
}
