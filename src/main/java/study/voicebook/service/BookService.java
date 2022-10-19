package study.voicebook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.entity.Voice;
import study.voicebook.repository.BookRepository;
import study.voicebook.repository.VoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    VoiceRepository voiceRepository;

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

        Voice voice1 = new Voice("KIM", "123",123, book1);
        Voice voice2 = new Voice("Lee", "123",123, book1);
        Voice voice3 = new Voice("Kim", "123",123, book2);
        Voice voice4 = new Voice("Choi", "123",123, book2);
        voiceRepository.save(voice1);
        voiceRepository.save(voice2);
        voiceRepository.save(voice3);
        voiceRepository.save(voice4);
    }
    @Transactional
    public Long saveBooks(createBookForm createBookForm) {
        Book book = new Book(createBookForm.getName(), createBookForm.getIsbn(), createBookForm.getPrice(),
                createBookForm.getAuthor(), createBookForm.getCategory1(), createBookForm.getCategory2());
        bookRepository.save(book);
        return book.getId();
    }

    //상품 조회 서비스
    @Transactional
    public List<showBookDto> showList(showBookDto show) {
        List<showBookDto> result = bookRepository.ShowBookDto(show);
        return result;
    }

    @Transactional
    public Page<showBookDto> showPage(showBookDto show, Pageable pageable){
        Page<showBookDto> result = bookRepository.ShowBookDto(show, pageable);
        return result;
    }

    public Book findOne(Long id) {
        return bookRepository.findByOne(id);
    }

    @Transactional
    public void updateBook(createBookForm bookForm, Long id) {
        bookRepository.updateById(bookForm, id);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
        bookRepository.flush();
    }
}
