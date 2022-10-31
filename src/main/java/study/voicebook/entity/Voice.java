package study.voicebook.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import study.voicebook.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Voice extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "voice_id")
    private Long id;
    private String name;
    private String file;
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public Voice(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Voice(String name, String file,  int price, Book book) {
        this.name = name;
        this.file = file;
        this.price = price;
        if(book != null) {
            changeBook(book);
        }
    }

    private void changeBook(Book book) {
        this.book = book;
        book.getVoice().add(this);
    }
}
