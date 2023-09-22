package com.buskingland.subpage.mainpicture;

import org.springframework.data.jpa.repository.JpaRepository;
import com.buskingland.subpage.text.Text;

public interface MainPictureRepository extends JpaRepository<MainPicture, Long> {

    /**
     * 주어진 Text와 연결된 MainPicture를 찾습니다.
     *
     * @param text 연결된 Text 엔티티
     * @return 연결된 MainPicture 엔티티
     */
    MainPicture findByText(Text text);
}