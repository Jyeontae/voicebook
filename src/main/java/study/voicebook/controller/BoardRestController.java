package study.voicebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
     * 게시글 목록
     */
    @GetMapping("/board")
    public Page<BoardDto> Board(Pageable pageable, BoardDto condition) {
        return boardService.searchBoard(pageable, condition);
    }


    /**
     * 게시글 생성
     */
    @PostMapping("/board/new")
    public void createBoardRest(BoardCreateDto boardCreateDto) {
        boardService.createBoard(boardCreateDto);
    }

    /**
     * 게시글 수정(id는 게시글 번호)
     */
    @PostMapping("/board/{id}/update")
    public void updateBoard(@PathVariable Long id, BoardUpdateDto boardUpdateDto) {
        boardService.updateBoard(id, boardUpdateDto);
    }
    /**
     * 게시글 삭제
     */
    @PostMapping("/board/{id}/delete")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
