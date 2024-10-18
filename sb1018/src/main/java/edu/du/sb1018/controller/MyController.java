package edu.du.sb1018.controller;

import edu.du.sb1018.entity.Dept;
import edu.du.sb1018.entity.Emp;
import edu.du.sb1018.service.DeptService;
import edu.du.sb1018.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {

    final EmpService empService;
    final DeptService deptService;

    @GetMapping("/")
    public String index(@ModelAttribute Emp emp, Model model) {
        List<Emp> empList = empService.findAll();
        model.addAttribute("empList", empList);
        return "index";
    }

    @GetMapping("/dept")
    public String dept(@ModelAttribute Dept dept, Model model) {
        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList", deptList);
        return "dept";
    }

    @PostMapping("/dept/addDept")
    public String addDept(@ModelAttribute("dept") Dept dept, Model model) {
        deptService.addDept(dept);
        model.addAttribute("dept", dept);
        return "redirect:/dept";
    }

    @GetMapping("/edit/{empno}")
    public String edit(@PathVariable int empno, Model model) {
        model.addAttribute("emp", empService.findByEmpno(empno));
        return "edit";
    }

    @PostMapping("/edit/updateEmp")
    public String updateEmp(@ModelAttribute("emp") Emp emp, Model model) {
        empService.updateEmp(emp);
        model.addAttribute("emp", emp);
        return "redirect:/";
    }

    @PostMapping("/addEmp")
    public String eddEmp(@ModelAttribute("emp") Emp emp, Model model) {
        empService.addEmp(emp);
        model.addAttribute("addEmployee", emp);
        return "redirect:/";
    }

    @GetMapping("/editdept/{deptno}")
    public String editdept(@PathVariable int deptno, Model model) {
        Dept dept = deptService.findByDeptno(deptno);
        model.addAttribute("dept", dept);
        return "editdept";
    }

    @PostMapping("/editdept/updateDept")
    public String updateDept(@ModelAttribute("dept") Dept dept, Model model) {
        deptService.updateDept(dept);
        model.addAttribute("dept", dept);
        return "redirect:/dept";
    }

    @GetMapping("/delete/{empno}")
    public String empDeletePage(@PathVariable int empno, Model model) {
        model.addAttribute("deleteEmp", empService.findByEmpno(empno));
        return "delete";
    }

    @PostMapping("/deleteEmp")
    public String deleteEmp(@ModelAttribute("deleteEmp") Emp emp) {
        empService.deleteEmp(emp.getEmpno());
        return "redirect:/";
    }

    @GetMapping("/dept/deleteDept/{deptno}")
    public String deptDeletePage(@PathVariable int deptno, Model model) {
        model.addAttribute("deleteDept", deptService.findByDeptno(deptno));
        return "deleteDept";
    }

    @PostMapping("/dept/delete")
    public String deleteDept(@ModelAttribute("deleteDept") Dept dept) {
        deptService.deleteDept(dept.getDeptno());
        return "redirect:/dept";
    }
}
