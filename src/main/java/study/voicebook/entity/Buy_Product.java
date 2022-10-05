package study.voicebook.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "buy_product")
    List<Book> books = new ArrayList<>();

    public Buy_Product(OpenType open, LocalDateTime buy_date, LocalDateTime recent_date, int recent_page, String buy_id) {
        this.open = open;
        this.buy_date = buy_date;
        this.recent_date = recent_date;
        this.recent_page = recent_page;
    }
}
