package study.voicebook.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import study.voicebook.dto.*;
import study.voicebook.entity.Board;
import study.voicebook.entity.Book;
import study.voicebook.entity.Member;
import study.voicebook.entity.QBoard;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;
import static study.voicebook.entity.QBoard.*;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BookRepository bookRepository;
    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public void createBoard(BoardCreateDto boardCreateDto) {
        Member nickname = memberRepository.findByNickname(boardCreateDto.getMember_name());
        Book bookname = bookRepository.findByName(boardCreateDto.getBook_name());

        Board board = new Board(boardCreateDto.getTitle(), boardCreateDto.getContents(), nickname, bookname);
        em.persist(board);
        em.flush();
    }

    @Override
    public Page<BoardDto> searchBoard(Pageable pageable, BoardDto condition) {
        List<BoardDto> contents = queryFactory
                .select(new QBoardDto(board.id, board.title, board.contents, board.member.nickname, board.book.name))
                .from(board)
                .where(
                        idEq(condition.getId()),
                        titleEq(condition.getTitle()),
                        contentsContain(condition.getContents()),
                        nicknameEq(condition.getMember_name()),
                        booknameEq(condition.getBook_name())
                        )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = contents.size();
        return new PageImpl<BoardDto>(contents, pageable, count);
    }

    @Override
    public void update(Long id, BoardUpdateDto boardUpdateDto) {
        queryFactory
                .update(board)
                .set(board.title, boardUpdateDto.getTitle())
                .set(board.contents, boardUpdateDto.getContent())
                .where(board.id.eq(id))
                .execute();
    }

    @Override
    public void deleteBoard(Long id) {
        queryFactory
                .delete(board)
                .where(board.id.eq(id))
                .execute();
    }

    private BooleanExpression idEq(Long id) {
        return !ObjectUtils.isEmpty(id) ? board.id.eq(id) : null;
    }

    private BooleanExpression titleEq(String title) {
        return hasText(title) ? board.title.eq(title) : null;
    }

    private BooleanExpression contentsContain(String contents) {
        return hasText(contents) ? board.contents.eq(contents) : null;
    }

    private BooleanExpression nicknameEq(String member_name) {
        return hasText(member_name) ? board.member.nickname.eq(member_name) : null;
    }

    private BooleanExpression booknameEq(String book_name) {
        return hasText(book_name) ? board.book.name.eq(book_name) : null;
    }
}
