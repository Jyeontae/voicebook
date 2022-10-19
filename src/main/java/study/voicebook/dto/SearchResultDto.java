package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class SearchResultDto {
    private String bookName;
    private String author;
    private int bookPrice;
    private String voiceName;
    private int voicePrice;

    @QueryProjection
    public SearchResultDto(String bookName, String author, int bookPrice, String voiceName, int voicePrice) {
        this.bookName = bookName;
        this.author = author;
        this.bookPrice = bookPrice;
        this.voiceName = voiceName;
        this.voicePrice = voicePrice;
    }
}
