package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class showBookDto {

    private Long id;
    private String name;
    private String isbn;
    private int price;
    private String author;
    private String category1;
    private String category2;

    public showBookDto() {
    }

    @QueryProjection
    public showBookDto(Long id, String name, String isbn, int price, String author, String category1, String category2) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.author = author;
        this.category1 = category1;
        this.category2 = category2;
    }
}
