package study.voicebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
public class BookController {

    @RequestMapping("/")
    public String page_main(Model model) {
        model.addAttribute("data", "정연태");
        return "home";
    }

}
