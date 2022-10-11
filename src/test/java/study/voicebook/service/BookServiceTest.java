package study.voicebook.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.entity.Book;
import study.voicebook.entity.QBook;
import study.voicebook.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static study.voicebook.entity.QBook.book;

@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired
    BookService bookService;
    @Autowired
    EntityManager em;

    @Test
    public void findOne() {
        Book book = new Book("1", "1", 1, "1", "1", "1");
        em.persist(book);
        Book result = bookService.findOne(book.getId());
        assertThat(book.getId()).isEqualTo(result.getId());
    }

    @Test
    public void updateBook() {
        Book book = new Book("1", "1", 1, "1", "1", "1");
        em.persist(book);
        createBookForm createBookForm = new createBookForm();
        createBookForm.setName("1");
        createBookForm.setIsbn("1");
        createBookForm.setPrice(10000);
        bookService.updateBook(createBookForm, book.getId());
    }

}