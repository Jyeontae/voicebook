package study.voicebook.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Buy_Product {

    @Id @GeneratedValue
    @Column(name = "buy_product_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private OpenType open;
    private LocalDateTime buy_date;
    private LocalDateTime recent_date;
    private int recent_page;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book books;

}
