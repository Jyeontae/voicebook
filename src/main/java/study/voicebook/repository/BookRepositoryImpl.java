package study.voicebook.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import study.voicebook.controller.form.BookSearchCondition;
import study.voicebook.dto.QSearchResultDto;
import study.voicebook.dto.SearchResultDto;
import study.voicebook.controller.form.createBookForm;
import study.voicebook.dto.QshowBookDto;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.entity.QBook;

import javax.persistence.EntityManager;

import java.util.List;

import static org.springframework.util.StringUtils.*;
import static study.voicebook.entity.QBook.*;
import static study.voicebook.entity.QVoice.*;

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
    public Page<showBookDto> ShowBookDto(showBookDto showBookDto, Pageable pageable) {
        List<showBookDto> result = queryFactory
                .select(new QshowBookDto(book.id, book.name, book.isbn, book.price, book.author, book.category1, book.category2))
                .from(book)
                .offset(0)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = result.size();
        return new PageImpl<>(result, pageable, count);
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

    @Override
    public Page<SearchResultDto> SearchResult(Pageable pageable, BookSearchCondition condition) {
        List<SearchResultDto> result = queryFactory
                .select(new QSearchResultDto(voice.book.name, voice.book.author, voice.book.price, voice.name, voice.price))
                .from(voice)
                .rightJoin(voice.book)
                .where(bookNameEq(condition.getBookName()),
                        voiceNameEq(condition.getVoiceName()))
                .fetch();
        long count = result.size();
        return new PageImpl<>(result, pageable, count);
    }

    private BooleanExpression voiceNameEq(String voiceName) {
        return hasText(voiceName) ? voice.name.eq(voiceName) : null;
    }

    private BooleanExpression bookNameEq(String bookName) {
        return hasText(bookName) ? voice.book.name.eq(bookName) : null;
    }
}
