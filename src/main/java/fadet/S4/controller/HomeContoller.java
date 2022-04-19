package fadet.S4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeContoller {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
