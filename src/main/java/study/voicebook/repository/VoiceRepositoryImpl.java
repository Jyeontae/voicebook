package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.dto.QVoiceDto;
import study.voicebook.dto.VoiceDto;
import study.voicebook.entity.Book;
import study.voicebook.entity.Voice;

import javax.persistence.EntityManager;

import java.util.List;

import static study.voicebook.entity.QVoice.voice;

public class VoiceRepositoryImpl implements VoiceRepositoryCustom{
    @Autowired
    EntityManager em;
    private final JPAQueryFactory queryFactory;

    public VoiceRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public void saveVoice(createVoiceForm voiceForm, Long bookId) {
        Book book = new Book(bookId);
        Voice voice = new Voice(voiceForm.getName(), voiceForm.getRecord(), voiceForm.getPrice(), book);
        em.persist(voice);
    }

    @Override
    public Page<VoiceDto> findAllDto(Pageable pageable) {
        List<VoiceDto> contents = queryFactory
                .select(new QVoiceDto(voice.id, voice.name, voice.book.name))
                .from(voice)
                .fetch();
        long count = contents.size();
        return new PageImpl<>(contents, pageable, count);
    }
}
