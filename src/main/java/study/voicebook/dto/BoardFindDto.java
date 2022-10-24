package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardFindDto {
    private Long num;
    private String title;
    private String memberName;
    private String bookName;
    private String contents;

    @QueryProjection
    public BoardFindDto(Long num, String title, String memberName, String bookName, String contents) {
        this.num = num;
        this.title = title;
        this.memberName = memberName;
        this.bookName = bookName;
        this.contents = contents;
    }
}
