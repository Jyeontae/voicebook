package study.voicebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.voicebook.dto.showBookDto;
import study.voicebook.service.BookService;

import java.util.List;

@RestController
public class BookRestController {

     private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("Restbooks")
    public List<showBookDto> showBookList(Model model) {
        bookService.initBook();
        return bookService.showList(new showBookDto());
    }
}
