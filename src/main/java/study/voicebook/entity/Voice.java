package study.voicebook.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Voice {

    @Id @GeneratedValue
    @Column(name = "voice_id")
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
