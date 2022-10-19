package study.voicebook.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookRestController {

     private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("Restbooks/v1")
    public List<showBookDto> showBookList(Model model) {
        bookService.initBook();
        return bookService.showList(new showBookDto());
    }

    /**
     * 상품조회(페이지)
     */
    /*@GetMapping("/books")
    public Page<showBookDto> showBookPage(Pageable pageable) {
        return bookService.showPage(new showBookDto(), pageable);
    }*/
    @GetMapping("/books")
    public ModelAndView showBookPage(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        Page<showBookDto> result = bookService.showPage(new showBookDto(), pageable);
        modelAndView.setViewName("books/BookList");
        modelAndView.addObject("bookList", result);
        return modelAndView;
    }

    /**
     * 상품수정화면
     */
    @GetMapping("/books/{id}/edit")
    public ModelAndView editBook(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.findOne(id);
        showBookDto show = new showBookDto(book.getId(), book.getName(), book.getIsbn(), book.getPrice(), book.getAuthor(), book.getCategory1(), book.getCategory2());
        modelAndView.setViewName("books/BookEdit");
        modelAndView.addObject("edit", show);
        return modelAndView;
    }

    /**
     * 상품 수정
     */
    @PostMapping("/books/{id}/edit")
    public ModelAndView updateBook(@PathVariable("id") Long id, @ModelAttribute("edit") @Valid createBookForm bookForm, BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("books/createBook");
            return modelAndView;
        }
        bookService.updateBook(bookForm, id);
        modelAndView.setViewName("redirect:/books");
        return modelAndView;
    }
    /**
     * 상품 삭제
     */
    @GetMapping("/books/{id}/delete")
    public ModelAndView deleteBook(@ModelAttribute("id") @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        bookService.deleteBook(id);
        modelAndView.setViewName("redirect:/books?page=1&size=2");
        return modelAndView;
    }
}
