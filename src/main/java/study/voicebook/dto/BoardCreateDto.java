package study.voicebook.dto;

import lombok.Data;

@Data
public class BoardCreateDto {
    private String title;
    private String contents;
    private String member_name;
    private String book_name;
}
