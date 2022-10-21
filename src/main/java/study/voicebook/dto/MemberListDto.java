package study.voicebook.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import study.voicebook.entity.MemberType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class MemberListDto {
    private Long id;
    private String site_id;
    private String nickname;
    private String email;
    private String phone_num;
    @Enumerated(EnumType.STRING)
    private MemberType role;

    @QueryProjection
    public MemberListDto(Long id, String site_id, String nickname, String email, String phone_num, MemberType role) {
        this.id = id;
        this.site_id = site_id;
        this.nickname = nickname;
        this.email = email;
        this.phone_num = phone_num;
        this.role = role;
    }
}
