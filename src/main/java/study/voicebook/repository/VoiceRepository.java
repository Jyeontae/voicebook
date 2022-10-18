package study.voicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.voicebook.entity.Voice;

public interface VoiceRepository extends JpaRepository<Voice, Long>, VoiceRepositoryCustom {
}
