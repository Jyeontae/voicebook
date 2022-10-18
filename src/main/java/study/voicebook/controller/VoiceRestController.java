package study.voicebook.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.controller.form.createVoiceForm;
import study.voicebook.dto.showBookDto;
import study.voicebook.entity.Book;
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

    @GetMapping("/voices/{id}/create")
    public ModelAndView saveVoice(@PathVariable("id") Long id, @ModelAttribute("create") @Valid createVoiceForm voiceForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("create", voiceForm);
        modelAndView.setViewName("voices/createVoice");
        return modelAndView;
    }

    @PostMapping("/voices/{id}/create")
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
}
