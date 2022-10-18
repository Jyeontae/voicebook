package study.voicebook.repository;

import study.voicebook.controller.form.createVoiceForm;

public interface VoiceRepositoryCustom {
    void saveVoice(createVoiceForm voiceForm, Long bookId);
}
