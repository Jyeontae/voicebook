package study.voicebook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryImplTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    VoiceRepository voiceRepository;

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

    /*@Test
    public void searchTest() {
        Book book1 = new Book("1", "1", 1, "1", "1", "1");
        Book book2 = new Book("2", "2", 2, "2", "2", "2");
        bookRepository.save(book1);
        bookRepository.save(book2);

        VoiceService voiceService = new VoiceService();
        Voice voice1 = new Voice("123", "123", 123, book1);
        Voice voice2 = new Voice("1234", "1234", 1234, book1);
        voiceRepository.save(voice1);
        voiceRepository.save(voice2);

        List<SearchResultDto> searchResultDtos = bookRepository.SearchResult();
        for (SearchResultDto searchResultDto : searchResultDtos) {
            System.out.println("searchResultDto = " + searchResultDto);
        }
    }*/
}