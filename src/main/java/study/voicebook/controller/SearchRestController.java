package study.voicebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import study.voicebook.controller.form.BookSearchCondition;
import study.voicebook.controller.form.SearchForm;
import study.voicebook.dto.SearchResultDto;
import study.voicebook.service.SearchService;

@RestController
public class SearchRestController {

    @Autowired
    SearchService searchService;
    /**
     * 검색기능
     */
    @GetMapping("/search")
    public ModelAndView searchItem(Pageable pageable, @ModelAttribute("condition") BookSearchCondition condition) {
        ModelAndView view = new ModelAndView();
        Page<SearchResultDto> search = searchService.Search(pageable, condition);
        view.setViewName("search/SearchList");
        view.addObject("Search", search);
        return view;
    }

    @GetMapping("/search/rest")
    public Page<SearchResultDto> searchItemRest(Pageable pageable, BookSearchCondition condition) {
        return searchService.Search(pageable, condition);
    }
}
