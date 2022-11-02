package study.voicebook.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.controller.form.LoginForm;
import study.voicebook.controller.form.MemberForm;
import study.voicebook.dto.MemberListDto;
import study.voicebook.dto.MemberSearchDto;
import study.voicebook.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class MemberRestController {

    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원가입 폼 이동
     */
    @GetMapping("/members/new")
    public ModelAndView createMember() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("members/createMember");
        modelAndView.addObject("memberForm", new MemberForm());
        return modelAndView;
    }

    /**
     * 회원가입 데이터 insert
     */
    @PostMapping("/members/new")
    public ModelAndView joinMember(@ModelAttribute("memberForm") @Valid MemberForm memberForm, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){ //에러가 나면
            modelAndView.setViewName("members/createMember");
            return modelAndView;
        }
        memberService.joinMember(memberForm);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    /**
     * 로그인 폼 이동
     */
    @GetMapping("/members/login")
    public ModelAndView loginMember() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loginForm", new LoginForm());
        modelAndView.setViewName("members/login");
        return modelAndView;
    }

    /**
     * 로그인 검증
     */
    @PostMapping("/members/login")
    public ModelAndView loginComp(@ModelAttribute("loginForm") @Valid LoginForm loginForm, HttpServletRequest request) {
        Boolean compResult = memberService.loginMember(loginForm);
        HttpSession session;
        ModelAndView modelAndView;
        //로그인 성공
        if(!compResult) {
            modelAndView = new ModelAndView();
            modelAndView.addObject("message", loginForm.getSite_id()+"님 반갑습니다.");
            session = request.getSession();
            session.setAttribute("session_id", loginForm.getSite_id());
            new ModelAndView().setViewName("redirect:/");
            return modelAndView;
        }
        //로그인 실패
        else{
            modelAndView = new ModelAndView();
            modelAndView.addObject("message", "회원 정보가 일치하지 않습니다.");
            modelAndView.setViewName("members/login");
            return modelAndView;
        }
    }

    /**
     * 로그인(세션)
     */
    @PostMapping("/members/rest/login")
    public String loginRest(HttpServletRequest request, LoginForm loginForm) {
        //true면 그냥 들어와도 세션이 만들어지므로 false로
        HttpSession session;
        Boolean loginMember = memberService.loginMember(loginForm);
        if(!loginMember) {
            session = request.getSession();
            session.setAttribute("session_Id", loginForm.getSite_id());
            return session.getAttribute("session_Id").toString();
        }
        return null;
    }

    /**
     * 마이페이지
     */
    @GetMapping("/members/mypage/rest")
    public String longinHome(HttpServletRequest request) {
        HttpSession session;
        session = request.getSession();
        return session.getAttribute("session_Id").toString()+"의 마이페이지";
    }

    @GetMapping("/members/mypage")
    public ModelAndView myPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        System.out.println("세션값 = " + session.getAttribute("session_id"));
        modelAndView.setViewName("members/myPage");
        modelAndView.addObject("pageData", session.getAttribute("session_id"));
        return modelAndView;
    }

    /**
     * 회원 목록 뷰 이동
     */
    @GetMapping("/members/list")
    public ModelAndView MemberList(@ModelAttribute("condition") MemberSearchDto memberSearchDto, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        Page<MemberListDto> result = memberService.findMember(memberSearchDto, pageable);
        System.out.println("result = " + result);
        modelAndView.addObject("memberList", result);
        modelAndView.setViewName("members/memberList");
        return modelAndView;
    }

    /**
     * 회원 목록(Rest)
     */
    @GetMapping("/members/list/rest")
    public Page<MemberListDto> viewMemberListRest(MemberSearchDto memberSearchDto, Pageable pageable) {
        return memberService.findMember(memberSearchDto, pageable);
    }

}
