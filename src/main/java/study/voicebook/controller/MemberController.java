package study.voicebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.voicebook.service.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMember(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMember";
    }

    @PostMapping("/members/new")
    public String joinMember(@Valid MemberForm memberForm, BindingResult result) {
        if(result.hasErrors()){ //에러가 나면
            return "members/createMember";
        }
        memberService.joinMember(memberForm);
        return "redirect:/";
    }
}
