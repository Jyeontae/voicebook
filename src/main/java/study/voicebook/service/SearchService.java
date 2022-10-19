package study.voicebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import study.voicebook.controller.form.BookSearchCondition;
import study.voicebook.dto.SearchResultDto;
import study.voicebook.repository.BookRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class SearchService {

    @Autowired
    BookRepository bookRepository;

    public Page<SearchResultDto> Search(Pageable pageable, BookSearchCondition condition) {
        return bookRepository.SearchResult(pageable, condition);
    }
}
