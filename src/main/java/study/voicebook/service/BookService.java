package study.voicebook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.entity.Book;
import study.voicebook.repository.BookRepository;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public Long saveBooks(createBookForm createBookForm) {
        Book book = new Book(createBookForm.getName(), createBookForm.getIsbn(), createBookForm.getPrice(),
                createBookForm.getAuthor(), createBookForm.getCategory1(), createBookForm.getCategory2());
        bookRepository.save(book);
        return book.getId();
    }
}
