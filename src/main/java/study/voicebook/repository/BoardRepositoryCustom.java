package study.voicebook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.voicebook.dto.BoardMainDto;

public interface BoardRepositoryCustom{
    Page<BoardMainDto> findDtoAll(Pageable pageable);
}
