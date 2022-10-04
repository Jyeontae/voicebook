package study.voicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.voicebook.entity.Buy_Product;

public interface Buy_ProductRepository extends JpaRepository<Buy_Product, Long> {
}
