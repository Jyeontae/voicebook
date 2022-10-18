package study.voicebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.voicebook.controller.form.LoginForm;
import study.voicebook.controller.form.MemberForm;
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

    @GetMapping("/members/login")
    public String loginMember(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "members/login";
    }

    @PostMapping("/members/login")
    public String loginComp(@Valid LoginForm loginForm, Model model) {
        Boolean compResult = memberService.loginMember(loginForm);
        if(compResult == true) {
            model.addAttribute("message", "회원 정보가 일치하지 않습니다");
            return "members/login";
        }
        return "redirect:/@id="+loginForm.getSite_id();
    }

    /**
     * 마이페이지로 이동할 예정(로그인후 바로)
     */
    @GetMapping("/{id}")
    public String longinHome(@PathVariable("id") String site_id) {
        return "home";
    }
}
