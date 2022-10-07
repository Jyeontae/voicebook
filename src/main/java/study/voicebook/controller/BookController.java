package study.voicebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.voicebook.controller.form.MemberForm;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.service.BookService;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @RequestMapping("/")
    public String page_main(Model model) {
        model.addAttribute("data", "정연태");
        return "home";
    }

    @GetMapping("/books/new")
    public String loadBook(Model model) {
        model.addAttribute("bookForm", new createBookForm());
        return "books/createBook";
    }

    @PostMapping("/books/new")
    public String saveBook(@ModelAttribute("bookForm") @Valid createBookForm bookForm, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "books/createBook";
        }
        bookService.saveBooks(bookForm);
        model.addAttribute("message", "상품 등록이 완료되었습니다.");
        return "books/createBook";
    }


}
