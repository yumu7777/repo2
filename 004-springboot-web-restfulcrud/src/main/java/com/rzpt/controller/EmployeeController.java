package com.rzpt.controller;

import com.rzpt.dao.DepartmentDao;
import com.rzpt.dao.EmployeeDao;
import com.rzpt.entities.Department;
import com.rzpt.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.reflect.Member;
import java.util.Collection;

/*
* 员工管理
* */
@Controller
public class EmployeeController {
    //注入员工
    @Autowired
    EmployeeDao employeeDao;
    //注入部门
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping(value = "/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        //放到请求域中
        model.addAttribute("emps",employees);
        //thymeLeaf会自动拼串到类路径下
        //classpath/templates/ XXX/.html
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        //添加部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到添加页面
        return "emp/add";
    }
    //springMVC自动将请求参数和入参的对象进行一一绑定,要求请求参数的名字和Javabean入参的对象里面的属性名名字一致
    //员工添加
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        System.out.println("员工保存"+employee);

        //来到员工列表页面
        //保存员工信息
        employeeDao.save(employee);
        //redirect  重定向
        //forward 转发
        return "redirect:/emps";
    }
    //来到修改页面,回显当前员工信息
    @GetMapping("/emp/{id}")   //路径变量的方式发送请求   @PathVariable("id")路径变量
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //添加部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面  (add页面是一个修改添加二合一的页面
        return "emp/add";
    }
    //员工信息修改
    @PutMapping("/emp")
    public String UpdateEmployee(Employee employee){

        System.out.println("修改后的员工信息"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工信息删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
       employeeDao.delete(id);
        return "redirect:/emps";
    }
}
