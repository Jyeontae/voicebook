package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class VoiceDto {

    private Long id;
    private String name;
    private String book;

    @QueryProjection
    public VoiceDto(Long id, String name, String book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }
}
