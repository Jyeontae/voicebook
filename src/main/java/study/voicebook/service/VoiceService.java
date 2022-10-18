package study.voicebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.repository.VoiceRepository;

import javax.transaction.Transactional;

@Service
public class VoiceService {

    @Autowired
    VoiceRepository voiceRepository;

    @Transactional
    public void saveVoice(createVoiceForm voiceForm, Long id) {
        voiceRepository.saveVoice(voiceForm, id);
    }
}
