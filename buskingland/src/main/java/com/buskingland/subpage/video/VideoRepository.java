package com.buskingland.subpage.video;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buskingland.subpage.text.Text;

public interface VideoRepository extends JpaRepository<Video, Long> {

    /**
     * 주어진 Text 엔티티에 속한 모든 Video 엔티티를 조회합니다.
     *
     * @param text 속한 Text 엔티티
     * @return 주어진 Text 엔티티에 속한 모든 Video 엔티티의 리스트
     */
    List<Video> findByText(Text text);
}