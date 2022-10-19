package study.voicebook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.dto.VoiceDto;

public interface VoiceRepositoryCustom {
    void saveVoice(createVoiceForm voiceForm, Long bookId);
    Page<VoiceDto> findAllDto(Pageable pageable);
}
