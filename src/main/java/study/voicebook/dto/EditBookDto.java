package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class EditBookDto {
    private Long id;
    private String name;
    private String isbn;
    private int price;
    private String author;
    private String category1;
    private String category2;
    private Enum roletype;

    public EditBookDto() {
    }

    @QueryProjection
    public EditBookDto(Long id, String name, String isbn, int price, String author, String category1, String category2, Enum rooltype) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.author = author;
        this.category1 = category1;
        this.category2 = category2;
        this.roletype = rooltype;
    }
}
