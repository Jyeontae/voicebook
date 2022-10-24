package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardMainDto {
    private Long num;
    private String title;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    @QueryProjection
    public BoardMainDto(Long num, String title, String name, LocalDateTime createTime, LocalDateTime modifiedTime) {
        this.num = num;
        this.title = title;
        this.name = name;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }
}
