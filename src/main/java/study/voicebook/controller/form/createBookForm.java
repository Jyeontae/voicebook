package study.voicebook.controller.form;

import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class createBookForm {
    @NotEmpty(message = "책 이름은 필수입니다.")
    private String name;
    @NotEmpty(message = "ISBN은 필수입니다.")
    private String isbn;
    @NotNull(message = "가격은 필수입니다.")
    private int price;
    private String author;
    private String category1;
    private String category2;
}
