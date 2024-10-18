package edu.du.sb1018.controller;

import edu.du.sb1018.entity.Dept;
import edu.du.sb1018.entity.Emp;
import edu.du.sb1018.service.DeptService;
import edu.du.sb1018.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    final DeptService deptService;
    final EmpService empService;

//    @GetMapping("/reset")
//    public void reset() {
//        deptService.reset();
//    }
//
//    @GetMapping("/{deptno}/{dname}")
//    public Dept index(@PathVariable int deptno, @PathVariable String dname) {
//        return deptService.updateDeptName(deptno, dname);
//    }
//
//    @GetMapping("/empList")
//    public List<Emp> empList() {
//        return empService.findAll();
//    }
//
//    @GetMapping("/deptList")
//    public List<Dept> deptList() {
//        return deptService.findAll();
//    }

//    @PostMapping("/?testAddDept/{no}/{name}/{loc}")
//    public void addDept(@PathVariable int no, @PathVariable String name, @PathVariable String loc) {
//        Dept dept = new Dept();
//        dept.setDeptno(no);
//        dept.setDname(name);
//        dept.setLoc(loc);
//        deptService.addDept(dept);
//    }

    @GetMapping("/findbydeptno/{no}")
    public Dept findbydeptno(@PathVariable int no) {
        return deptService.findByDeptno(no);
    }
}
