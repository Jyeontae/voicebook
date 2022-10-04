package study.voicebook.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String name;
    private String isbn;
    private Long price;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "book")
    List<Voice> voice = new ArrayList<>();

    @OneToMany(mappedBy = "books")
    List<Buy_Product> buy_products = new ArrayList<>();

}
