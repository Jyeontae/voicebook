package study.voicebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.dto.BoardCreateDto;
import study.voicebook.dto.BoardDto;
import study.voicebook.dto.BoardUpdateDto;
import study.voicebook.repository.BoardRepository;

@Service
@Transactional(readOnly = true)
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public void createBoard(BoardCreateDto boardCreateDto) {
        boardRepository.createBoard(boardCreateDto);
    }

    public Page<BoardDto> searchBoard(Pageable pageable, BoardDto condition) {
        return boardRepository.searchBoard(pageable, condition);
    }

    public void updateBoard(Long id, BoardUpdateDto boardUpdateDto) {
        boardRepository.update(id, boardUpdateDto);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteBoard(id);
    }
}
