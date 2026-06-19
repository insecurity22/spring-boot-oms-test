package board.board_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    // GET /demo 요청이 들어오면 해당 메서드가 실행된다.
    @GetMapping("demo")
    public String demo(Model model) {
        // 1. Model은 Controller에서 View로 데이터를 전달하는 역할을 한다.
        // 2. addAttribute("data", value)로 등록한 데이터는 View에서 ${data}로 접근할 수 있다.
        model.addAttribute("data", "hello!");

        // 3. View 이름을 반환하면 ViewResolver가 templates/board.html을 렌더링한다.
        return "demo";
    }

    // GET /demo-mvc
    @GetMapping("demo-mvc")
    // 1. ?name=spring
    public String demoMvc(@RequestParam("name") String name, Model model) {
        // 2. 두 메서드 모두 MVC 패턴을 사용한다.
        // - Model: 화면에 필요한 데이터를 담는다.
        // - View: 화면을 렌더링하는 역할만 담당한다.
        // - Controller: 요청을 처리하고 비즈니스 로직을 수행한 뒤 Model과 View를 연결한다.
        model.addAttribute("name", name);
        return "demo-template";
    }
}
