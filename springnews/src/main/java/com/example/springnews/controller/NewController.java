package com.example.springnews.controller;

import com.example.springnews.model.News;
import com.example.springnews.repository.NewsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewController {

    private final NewsRepository newsRepository;

    //전체 뉴스 출력
    @GetMapping("/newsmain")
    public ModelAndView newsList() {
        ModelAndView mav = new ModelAndView();
        List<News> newsList = newsRepository.findAll();

        if (newsList.size() != 0) {
            mav.addObject("newsList", newsList);
        } else {
            mav.addObject("msg", "뉴스 글 내용이 없어요");
        }
        mav.setViewName("newsmain");
        return mav;
    }

    //뉴스 제목을 선택하여 요청 -> 뉴스 id로 해당 뉴스 내용 출력
    @GetMapping(value = "/listOne", produces = "application/json; charset=utf-8")
    @ResponseBody
    public News newsContent(int id) {
        News news = newsRepository.findById(id);
        return news;
    }

    //삭제 버튼을 클릭하여 요청 -> 뉴스 id로 뉴스 삭제
//    @GetMapping("/delete")

    //검색 요청 -> 전달된 검색어로 뉴스글 내용에서 검색하여 결과 출력
//    @GetMapping("/search")

    //리스트에 출력된 작성자 이름을 클릭하여 요청 -> 작성자가 작성한 뉴스 글만 출력
//    @GetMapping("/writer")

    //    뉴스작성
    @PostMapping("/insert")
    @Transactional
    public ModelAndView insert(News news) {
        System.out.println(news);
        news.setWriteDate(LocalDateTime.now());
        System.out.println(news);
        ModelAndView mav = new ModelAndView();
        try {
            newsRepository.save(news);
            mav.addObject("newsList", newsRepository.findAll());
        } catch (Exception e) {
            mav.addObject("msg", "글 작성을 처리하는 동안 오류 발생");
        }
        mav.setViewName("newsmain");
        return mav;
    }

    //뉴스 수정
//    @PostMapping("update")


}
