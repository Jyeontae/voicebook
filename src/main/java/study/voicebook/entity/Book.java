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
    private String category1;
    private String category2;

    @OneToMany(mappedBy = "books")
    List<Member_Book> member_books = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    List<Voice> voice = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buy_product_id")
    Buy_Product buy_product;

}
