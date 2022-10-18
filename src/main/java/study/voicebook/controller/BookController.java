package study.voicebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.service.BookService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @RequestMapping("/")
    public String page_main(Model model) {
        bookService.initBook();
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

    /*@GetMapping("books")
    public String showBookList(Model model) {
        List<showBookDto> result = bookService.showList(new showBookDto());
        model.addAttribute("bookList", result);
        return "books/BookList";
    }*/

    /**
     * 책 정보 수정페이지 이동
     */
    /*@GetMapping("/books/{id}/edit")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findOne(id);
        showBookDto show = new showBookDto(book.getId(), book.getName(), book.getIsbn(), book.getPrice(), book.getAuthor(), book.getCategory1(), book.getCategory2());
        model.addAttribute("edit", show);
        return "books/BookEdit";
    }*/

    /**
     * 책 정보 수정 반영
     */
    /*@PostMapping("/books/{id}/edit")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("edit") @Valid createBookForm bookForm, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "books/createBook";
        }
        bookService.updateBook(bookForm, id);
        return "redirect:/books";
    }*/

    /**
     * 책 정보 삭제
     */
    /*@GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }*/
}
