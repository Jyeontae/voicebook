package study.voicebook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.repository.BookRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public void initBook() {
        Book book1 = new Book("1", "1", 1, "1", "1", "1");
        Book book2 = new Book("2", "2", 2, "2", "2", "2");
        Book book3 = new Book("3", "3", 3, "3", "3", "3");
        Book book4 = new Book("4", "4", 4, "4", "4", "4");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
    }
    @Transactional
    public Long saveBooks(createBookForm createBookForm) {
        Book book = new Book(createBookForm.getName(), createBookForm.getIsbn(), createBookForm.getPrice(),
                createBookForm.getAuthor(), createBookForm.getCategory1(), createBookForm.getCategory2());
        bookRepository.save(book);
        return book.getId();
    }

    @Transactional
    public List<showBookDto> showList(showBookDto show) {
        List<showBookDto> result = bookRepository.ShowBookDto(show);
        return result;
    }
}
