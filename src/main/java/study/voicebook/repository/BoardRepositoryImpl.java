package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import study.voicebook.dto.BoardMainDto;
import study.voicebook.dto.QBoardMainDto;

import javax.persistence.EntityManager;

import java.util.List;

import static study.voicebook.entity.QBoard.*;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<BoardMainDto> findDtoAll(Pageable pageable) {
        List<BoardMainDto> contents = queryFactory
                .select(new QBoardMainDto(board.num, board.title, board.member.nickname, board.createTime, board.modifiedTime))
                .from(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long size = contents.size();
        return new PageImpl<>(contents, pageable, size);
    }
}
