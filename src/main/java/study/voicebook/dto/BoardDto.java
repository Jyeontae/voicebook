package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private String contents;
    private String member_name;
    private String book_name;

    @QueryProjection
    public BoardDto(Long id, String title, String contents, String member_name, String book_name) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.member_name = member_name;
        this.book_name = book_name;
    }
}
