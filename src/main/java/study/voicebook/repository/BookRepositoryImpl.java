package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.QshowBookDto;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.entity.QBook;

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

    @Override
    public Book findByOne(Long id) {
        Book result = queryFactory
                .selectFrom(QBook.book)
                .where(QBook.book.id.eq(id))
                .fetchOne();

        if(result == null) {
            System.out.println("BookSearchResult = " + null);
        }
        return result;
    }

    @Override
    public void updateById(createBookForm bookForm, Long id) {
        queryFactory
                .update(book)
                .set(book.name, bookForm.getName())
                .set(book.isbn, bookForm.getIsbn())
                .set(book.price, bookForm.getPrice())
                .set(book.author, bookForm.getAuthor())
                .set(book.category1, bookForm.getCategory1())
                .set(book.category2, bookForm.getCategory2())
                .where(book.id.eq(id))
                .execute();
    }
}
