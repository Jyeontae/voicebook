package study.voicebook.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "ID는 필수 입력 입니다.")
    private String site_id;
    @NotEmpty(message = "PW는 필수 입력 입니다.")
    private String site_pw;
    @NotEmpty(message = "이름은 필수 입력 입니다.")
    private String username;
    @NotEmpty(message = "휴대폰 번호는 필수 입력 입니다.")
    private String phone_num;
    @NotEmpty(message = "이메일은 필수 입력 입니다.")
    private String email;
    @NotEmpty(message = "닉네임은 필수 입력 입니다.")
    private String nickname;


}
