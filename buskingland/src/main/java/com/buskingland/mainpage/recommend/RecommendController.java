package com.buskingland.mainpage.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/recommends")
public class RecommendController {
    private final RecommendRepository recommendRepository;

    @Autowired
    public RecommendController(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    /**
     * 추천 정보를 조회하는 엔드포인트입니다.
     *
     * @return 조회된 추천 정보
     * @throws RecommendNotFoundException 조회된 정보가 없을 경우 예외 발생
     */
    @GetMapping("/get")
    public Recommend getRecommendation() {
        return recommendRepository.findById((long) 1)
                .orElseThrow(() -> new RecommendNotFoundException("추천 정보를 찾을 수 없습니다."));
    }

    /**
     * 추천 정보를 생성하는 엔드포인트입니다.
     *
     * @param recommend 생성할 추천 정보
     * @return 생성된 추천 정보
     */
    @PostMapping("/post")
    public Recommend createRecommendation(@RequestBody Recommend recommend) {
        Recommend existingRecommendation = recommendRepository.findById((long) 1).orElse(null);
        if (existingRecommendation != null) {
            return existingRecommendation;
        } else {
            return recommendRepository.save(recommend);
        }
    }

    /**
     * 추천 정보를 업데이트하는 엔드포인트입니다.
     *
     * @param updatedRecommendation 업데이트할 추천 정보
     * @return 업데이트된 추천 정보
     * @throws RecommendNotFoundException 업데이트할 정보가 없을 경우 예외 발생
     */
    @PutMapping("/put")
    public Recommend updateRecommendation(@RequestBody Recommend updatedRecommendation) {
        Recommend existingRecommendation = recommendRepository.findById(1L).orElseThrow(() -> new RecommendNotFoundException("추천 정보를 찾을 수 없습니다."));

        // 업데이트할 필드들을 업데이트합니다.
        existingRecommendation.setId1(updatedRecommendation.getId1());
        existingRecommendation.setId2(updatedRecommendation.getId2());
        existingRecommendation.setId3(updatedRecommendation.getId3());
        existingRecommendation.setId4(updatedRecommendation.getId4());
        existingRecommendation.setId5(updatedRecommendation.getId5());
        existingRecommendation.setId6(updatedRecommendation.getId6());

        // 엔티티를 저장하여 업데이트를 반영합니다.
        return recommendRepository.save(existingRecommendation);
    }
}