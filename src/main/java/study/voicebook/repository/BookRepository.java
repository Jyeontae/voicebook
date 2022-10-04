package study.voicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.voicebook.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
