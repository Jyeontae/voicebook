package study.voicebook.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.voicebook.dto.MemberListDto;

public interface MemberRepositoryCustom {
    Boolean loginComp(String site_id, String site_pw);
    Page<MemberListDto> findMemberAll(MemberListDto memberListDto, Pageable pageable);
}
