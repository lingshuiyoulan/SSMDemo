package com.ssm.action;

import com.ssm.domain.Dept;
import com.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/action/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/showDept")
    public ModelAndView showDept() throws SQLException {
        List<Dept> depts = deptService.findDeptsByCondition(null);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/deptAllShow.jsp");
        mav.addObject("depts", depts);
        return mav;
    }
}
