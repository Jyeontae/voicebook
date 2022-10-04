package study.voicebook.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

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
    List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "members")
    List<Buy_Product> buy_products = new ArrayList<>();
}
