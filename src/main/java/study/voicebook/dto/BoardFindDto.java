package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardFindDto {
    private String title;
    private String contents;
    private String memberName;
    private String bookName;

    @QueryProjection
    public BoardFindDto(String title, String contents, String memberName, String bookName) {
        this.title = title;
        this.contents = contents;
        this.memberName = memberName;
        this.bookName = bookName;
    }
}
