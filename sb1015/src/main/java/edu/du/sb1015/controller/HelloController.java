package edu.du.sb1015.controller;

import edu.du.sb1015.dto.DataObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "이름을 적어주세요");
        return "index";
    }

    @PostMapping("/")
    public String post(@RequestParam String text1, Model model) {
        model.addAttribute("value", text1);
        model.addAttribute("msg", "당신의 이름은 "+text1+"입니다.");
        return "index";
    }

    @GetMapping("/")
    public String index2(Model model) {
        model.addAttribute("msg", "message 1<hr/>message 2<br/>message 3");
        DataObject obj = new DataObject(123, "lee", "lee@flower");
        model.addAttribute("object", obj);
        return "index";
    }

    @GetMapping("/id/{id}")
    public String index3(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        model.addAttribute("check", id >= 0);
        model.addAttribute("trueValue", "POSSIBLE");
        model.addAttribute("falseValue", "negative");
        DataObject obj = new DataObject(123, "lee", "lee@flower");
        model.addAttribute("object", obj);
        return "index";
    }

    @GetMapping("/month/{month}")
    public String index4(Model model, @PathVariable int month) {
        int m = Math.abs(month) % 12;
        m = m == 0 ? 12 : m;
        model.addAttribute("month", m);
        model.addAttribute("check", Math.floor(m / 3));
        return "index2";
    }

    @GetMapping("/index3")
    public String index5(Model model) {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"park", "park@yamada", "090-999-999"});
        data.add(new String[]{"lee", "lee@flower", "080-888-888"});
        data.add(new String[]{"choi", "choi@happy", "070-777-777"});
        model.addAttribute("data", data);
        return "index3";
    }

    @GetMapping("/index4")
    public String index6(Model model) {
        ArrayList<String[]> data = new ArrayList<>();
        data.add(new String[]{"park", "park@yamada", "090-999-999"});
        data.add(new String[]{"lee", "lee@flower", "080-888-888"});
        data.add(new String[]{"choi", "choi@happy", "070-777-777"});
        model.addAttribute("data", data);
        return "index4";
    }

    @GetMapping("/tax/{tax}")
    public String index7(Model model, @PathVariable int tax) {
        model.addAttribute("tax", tax);
        return "index5";
    }
}
