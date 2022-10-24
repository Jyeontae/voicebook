package study.voicebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.dto.BoardMainDto;
import study.voicebook.repository.BoardRepository;

@Service
@Transactional(readOnly = true)
public class BoardService {

    @Autowired
    BoardRepository boardRepository;


    public Page<BoardMainDto> findAll(Pageable pageable) {
        return boardRepository.findDtoAll(pageable);
    }
}
