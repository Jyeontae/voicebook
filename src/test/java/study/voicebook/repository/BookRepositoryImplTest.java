package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.dto.QshowBookDto;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryImplTest {

    @Autowired
    BookRepository bookRepository;


    @Test
    public void showList() {
        Book book = new Book("1", "1", 1, "1", "1", "1");
        bookRepository.save(book);
        List<showBookDto> result = bookRepository.ShowBookDto(new showBookDto(book.getId(), book.getName(), book.getIsbn(), book.getPrice(), book.getAuthor(), book.getCategory1(), book.getCategory2()));
        for (study.voicebook.dto.showBookDto bookDto : result) {
            System.out.println("bookDto = " + bookDto);
        }
        assertThat(result.get(0).getId()).isEqualTo(1);
    }

}