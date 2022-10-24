package study.voicebook.dto;

import lombok.Data;
import study.voicebook.entity.MemberType;

@Data
public class MemberSearchDto {
    private String site_id;
    private String nickname;
    private String email;
    private String phone_num;
    private MemberType role;
}
