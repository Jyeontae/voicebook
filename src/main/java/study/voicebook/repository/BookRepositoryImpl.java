package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import study.voicebook.dto.QshowBookDto;
import study.voicebook.dto.showBookDto;

import javax.persistence.EntityManager;

import java.util.List;

import static study.voicebook.entity.QBook.*;

public class BookRepositoryImpl implements BookRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public BookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<showBookDto> ShowBookDto(showBookDto showBookDto) {
        List<showBookDto> result = queryFactory
                .select(new QshowBookDto(book.id, book.name, book.isbn, book.price, book.author, book.category1, book.category2))
                .from(book)
                .fetch();

        return result;
    }
}
