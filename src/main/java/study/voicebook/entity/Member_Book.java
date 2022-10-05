package study.voicebook.entity;

import org.springframework.data.util.Lazy;

import javax.persistence.*;

@Entity
public class Member_Book {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book books;
}
