package study.voicebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import study.voicebook.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String site_id;
    private String site_pw;
    private String username;
    private String phone_num;
    private String email;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private MemberType role;

    @OneToMany(mappedBy = "member")
    List<Member_Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "members")
    List<Buy_Product> buy_products = new ArrayList<>();

    public Member(String site_id, String site_pw, String username, String phone_num, String email, String nickname, MemberType role) {
        this.site_id = site_id;
        this.site_pw = site_pw;
        this.username = username;
        this.phone_num = phone_num;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }
}
