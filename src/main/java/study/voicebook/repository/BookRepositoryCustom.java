package study.voicebook.repository;

import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.QshowBookDto;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<showBookDto> ShowBookDto(showBookDto showBookDto);
    Book findByOne(Long id);
    void updateById(createBookForm bookForm, Long id);
}
