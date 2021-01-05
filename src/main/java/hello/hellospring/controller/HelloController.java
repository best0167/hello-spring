package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    // 외부에서 파라미터를 받을거다.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // body 부분에 직접 넣어주겠다. 뷰 없이 데이터를 그대로 내려준다..
    // return "<html>hello " + name + "/<html>; 대신에 효율적으로 사용.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    // 데이터를 내놔
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }
    // {"name":"spring!!!!!"} json 형태로 출력

    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
