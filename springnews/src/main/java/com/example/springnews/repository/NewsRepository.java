package com.example.springnews.repository;

import com.example.springnews.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {

    //뉴스글 작성

    //뉴스글 전체 읽기
    public List<News> findAll();

    //id로 글 한 개 읽기
    //cnt변경도 필요
    public News findById(int id);

    //뉴스글 삭제

    //뉴스글 변경

    //뉴스 글 내용에서 검색 기능 필요
    public List<News> findByContentContains(String keyword);



}
