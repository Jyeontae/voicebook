package study.voicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.voicebook.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    Board findOneById(Long id);
}
