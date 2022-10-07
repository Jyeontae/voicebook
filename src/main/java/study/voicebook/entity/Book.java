package study.voicebook.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String name;
    private String isbn;
    private int price;
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

    public Book(String name, String isbn, int price, String author, String category1, String category2) {
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.author = author;
        this.category1 = category1;
        this.category2 = category2;

    }
}
