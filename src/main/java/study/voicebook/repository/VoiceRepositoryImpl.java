package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.entity.Book;
import study.voicebook.entity.Voice;

import javax.persistence.EntityManager;

public class VoiceRepositoryImpl implements VoiceRepositoryCustom{

    @Autowired
    EntityManager em;

    @Override
    public void saveVoice(createVoiceForm voiceForm, Long bookId) {
        Book book = new Book(bookId);
        Voice voice = new Voice(voiceForm.getName(), voiceForm.getRecord(), voiceForm.getPrice(), book);
        em.persist(voice);
    }
}
