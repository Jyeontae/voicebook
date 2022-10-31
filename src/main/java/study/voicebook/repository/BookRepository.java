package study.voicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.voicebook.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
    Book findByName(String name);
}
