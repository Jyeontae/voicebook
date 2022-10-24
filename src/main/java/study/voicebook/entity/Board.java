package study.voicebook.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    private Long id;
    @GeneratedValue
    private Long num;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String title;
    private String contents;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Book book;

    public Board(String title, String contents,Member member, Book book) {
        this.createTime = LocalDateTime.now();
        this.title = title;
        this.contents = contents;
        this.member = member;
        this.book = book;
    }

    public void modifiedBoard(Long id, Long num, String title, String contents, Member member, Book book){
        this.id = id;
        this.num = num;
        this.title = title;
        this.contents = contents;
        this.modifiedTime = LocalDateTime.now();
        this.member = member;
        this.book = book;
    }
}
