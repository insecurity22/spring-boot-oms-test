package board.board_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    // 1. GETMapping(URL) GET 요청이 들어오면 해당 메서드가 실행된다.
    @GetMapping("demo")
    public String demo(Model model) {
        // 1) Model은 Controller에서 View로 데이터를 전달하는 역할을 한다.
        // 2) addAttribute("data", value)로 등록한 데이터는 View에서 ${data}로 접근할 수 있다.
        model.addAttribute("data", "hello!");

        // 3) View 이름을 반환하면 ViewResolver가 templates/board.html을 렌더링한다.
        return "demo";
    }

    @GetMapping("demo-mvc")
    public String demoMvc(@RequestParam("name") String name, Model model) {
        // 1) 두 메서드 모두 MVC 패턴을 사용한다.
        // - Model: 화면에 필요한 데이터를 담는다.
        // - View: 화면을 렌더링하는 역할만 담당한다.
        // - Controller: 요청을 처리하고 비즈니스 로직을 수행한 뒤 Model과 View를 연결한다.

        // 2) RequestParam = ?name=spring
        model.addAttribute("name", name);
        return "demo-template";
    }

    // 2. ResponseBody Annotation을 사용한 API 방식
    @GetMapping("demo-string")
    @ResponseBody
    // 1) ViewResolver 대신 HttpMessageConverter가 동작한다.
    // - 기본 문자 처리: StringHttpMessageConverter
    // - 기본 객체 처리: MappingJackson2HttpMessageConverter
    // - 이외에도 Byte 처리 등 다양한 MessageConverter가 기본 등록되어 있다.
    // 2) 반환값을 HTTP Protocol Response Body에 직접 담아 응답한다.
    // - 원하는 포맷으로 요청을 받을 수 있고, 반환 타입을 기준으로 HTTPMessageConverter가 선택된다. ex) HTTP Accept Header: XML or JSON
    public String demoString(@RequestParam("name") String name) {
        // 3) 단순 문자일 경우, HttpMessageConverter의 StringConverter가 문자 그대로 내려준다.
        return "demo " + name;
    }

    @GetMapping("demo-api")
    @ResponseBody
    public Demo demoApi(@RequestParam("name") String name) {
        Demo demo = new Demo();
        // 4) 객체일 경우, HttpMessageConverter의 JsonConverter가 JSON 형식으로 변환하여 HTTP 응답 본문에 반환한다.
        demo.setName(name);
        return demo;
    }

    static class Demo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
