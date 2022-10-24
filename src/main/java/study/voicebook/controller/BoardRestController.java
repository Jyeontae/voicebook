package study.voicebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.dto.BoardMainDto;
import study.voicebook.service.BoardService;


@RestController
public class BoardRestController {

    @Autowired
    BoardService boardService;

    /**
     * 게시판
     */
    @GetMapping("/board")
    public ModelAndView clickBoard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("board/boardMain");
        return modelAndView;
    }

    /**
     * 게시판(RestAPI)
     */
    @GetMapping("/board/rest")
    public Page<BoardMainDto> clickBoardRest(Pageable pageable) {
        return boardService.findAll(pageable);
    }

    /**
     * 게시글 생성
     */
    @GetMapping("/board/{id}/new")
    public ModelAndView createBoard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("board/boardCreate");
        return modelAndView;
    }

    /**
     * 게시글 생성(RestAPI)
     */
    @GetMapping("/board/{id}/new/rest")
    public void createBoardRest() {

    }
}
