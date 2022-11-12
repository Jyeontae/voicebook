package study.voicebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.dto.BoardCreateDto;
import study.voicebook.dto.BoardDto;
import study.voicebook.dto.BoardMainDto;
import study.voicebook.dto.BoardUpdateDto;
import study.voicebook.service.BoardService;


@RestController
public class BoardRestController {

    @Autowired
    BoardService boardService;

    /**
     * 게시글 목록(READ)
     */
    @GetMapping("/board")
    public Page<BoardDto> Board(Pageable pageable, BoardDto condition) {
        return boardService.searchBoard(pageable, condition);
    }

    /**
     * 게시글 생성(CREATE)
     */
    @PostMapping("/board/new")
    public void createBoardRest(BoardCreateDto boardCreateDto) {
        boardService.createBoard(boardCreateDto);
    }

    /**
     * 게시글 수정(id는 게시글 번호)(UPDATE)
     */
    @PutMapping("/board/{id}")
    public void updateBoard(@PathVariable Long id, BoardUpdateDto boardUpdateDto) {
        boardService.updateBoard(id, boardUpdateDto);
    }

    /**
     * 게시글 삭제(DELETE)
     */
    @DeleteMapping("/board/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
