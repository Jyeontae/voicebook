package study.voicebook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.voicebook.controller.form.BookSearchCondition;
import study.voicebook.dto.SearchResultDto;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<showBookDto> ShowBookDto(showBookDto showBookDto);
    Page<showBookDto> ShowBookDto(showBookDto showBookDto, Pageable pageable);
    Book findByOne(Long id);
    void updateById(createBookForm bookForm, Long id);
    Page<SearchResultDto> SearchResult(Pageable pageable, BookSearchCondition condition);
}
