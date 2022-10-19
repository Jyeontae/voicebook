package study.voicebook.controller.form;

import lombok.Data;

@Data
public class SearchForm {

    private String bookName;
    private String category;
    private String voiceName;
}
