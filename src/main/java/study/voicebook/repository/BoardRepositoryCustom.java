package study.voicebook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.voicebook.dto.BoardCreateDto;
import study.voicebook.dto.BoardDto;
import study.voicebook.dto.BoardMainDto;
import study.voicebook.dto.BoardUpdateDto;

public interface BoardRepositoryCustom{
    void createBoard(BoardCreateDto boardCreateDto);
    Page<BoardDto> searchBoard(Pageable pageable, BoardDto condition);
    void update(Long id, BoardUpdateDto boardUpdateDto);
    void deleteBoard(Long id);
}
