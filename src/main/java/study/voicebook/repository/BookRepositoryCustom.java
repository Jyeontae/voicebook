package study.voicebook.repository;

import study.voicebook.dto.QshowBookDto;
import study.voicebook.dto.showBookDto;

import java.util.List;

public interface BookRepositoryCustom {
    List<showBookDto> ShowBookDto(showBookDto showBookDto);
}
