package study.voicebook.repository;


import study.voicebook.dto.showBookDto;

public interface MemberRepositoryCustom {
    Boolean loginComp(String site_id, String site_pw);
}
