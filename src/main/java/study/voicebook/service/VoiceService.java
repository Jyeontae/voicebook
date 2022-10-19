package study.voicebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.dto.VoiceDto;
import study.voicebook.entity.Voice;
import study.voicebook.repository.VoiceRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VoiceService {

    @Autowired
    VoiceRepository voiceRepository;

    @Transactional
    public void saveVoice(createVoiceForm voiceForm, Long id) {
        voiceRepository.saveVoice(voiceForm, id);
    }

    public Page<VoiceDto> findAll(Pageable pageable) {
        return voiceRepository.findAllDto(pageable);
    }
}
