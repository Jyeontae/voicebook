package study.voicebook.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageForm {

    private String message = "";
    private String href = "";

    public MessageForm(String message, String href) {
        this.message = message;
        this.href = href;
    }
}
