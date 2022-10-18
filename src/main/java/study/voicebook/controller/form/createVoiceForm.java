package study.voicebook.controller.form;

import lombok.Data;

@Data
public class createVoiceForm {
    private Long id;
    private String name;
    private String record;
    private int price;
}
