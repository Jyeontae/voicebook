package study.voicebook.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.dto.VoiceDto;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
import study.voicebook.entity.Voice;
import study.voicebook.service.BookService;
import study.voicebook.service.VoiceService;

import javax.validation.Valid;

@RestController
public class VoiceRestController {

    private final BookService bookService;
    private final VoiceService voiceService;

    public VoiceRestController(BookService bookService, VoiceService voiceService) {
        this.bookService = bookService;
        this.voiceService = voiceService;
    }

    @GetMapping("/voices/{id}/new")
    public ModelAndView saveVoice(@PathVariable("id") Long id, @ModelAttribute("create") @Valid createVoiceForm voiceForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("create", voiceForm);
        modelAndView.setViewName("voices/createVoice");
        return modelAndView;
    }

    @PostMapping("/voices/{id}/new")
    public ModelAndView submitVoice(@PathVariable("id") Long id, @ModelAttribute("create") @Valid createVoiceForm voiceForm, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("voices/"+id+"/create");
            return modelAndView;
        }
        System.out.println("voiceForm = " + voiceForm);
        voiceService.saveVoice(voiceForm, id);
        modelAndView.setViewName("redirect:/books");
        return modelAndView;
    }
    /**
     * 성우 정보 출력
     */
    @GetMapping("/voice")
    public ModelAndView voiceList(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        Page<VoiceDto> all = voiceService.findAll(pageable);
        modelAndView.addObject("voice", all);
        modelAndView.setViewName("voices/VoiceList");
        return modelAndView;
    }

    /**
     * 성우 정보 출력(RestAPI)
     */
    @GetMapping("/voice/rest")
    public Page<VoiceDto> voiceRestList(Pageable pageable) {
        return voiceService.findAll(pageable);
    }
}
