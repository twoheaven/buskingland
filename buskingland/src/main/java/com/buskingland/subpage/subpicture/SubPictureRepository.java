package com.buskingland.subpage.subpicture;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buskingland.subpage.text.Text;

public interface SubPictureRepository extends JpaRepository<SubPicture, Long> {

    /**
     * 주어진 Text와 관련된 SubPicture 목록을 검색합니다.
     *
     * @param text 검색할 Text 엔티티
     * @return Text와 관련된 SubPicture 목록
     */
    List<SubPicture> findByText(Text text);
}