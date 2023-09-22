package com.buskingland.mainpage.recruit;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buskingland.subpage.text.TextNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/recruits")
public class RecruitController {
    private final RecruitRepository recruitRepository;

    @Autowired
    public RecruitController(RecruitRepository recruitRepository) {
        this.recruitRepository = recruitRepository;
    }

    /**
     * 모든 공연 모집 정보를 조회하는 엔드포인트입니다.
     *
     * @return 모든 공연 모집 정보 목록
     */
    @GetMapping("/get")
    public List<Recruit> getAllRecruits() {
        return recruitRepository.findAll();
    }

    /**
     * 특정 ID의 공연 모집 정보를 조회하는 엔드포인트입니다.
     *
     * @param id 조회할 공연 모집 정보의 ID
     * @return 조회된 공연 모집 정보 또는 예외 메시지
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Recruit> getRecruitById(@PathVariable Long id) {
        Recruit recruit = recruitRepository.findById(id)
                                  .orElseThrow(() -> new TextNotFoundException(id));

        return ResponseEntity.ok(recruit);
    }

    /**
     * 공연 모집 정보를 생성하는 엔드포인트입니다.
     *
     * @param recruit 생성할 공연 모집 정보
     * @return 생성된 공연 모집 정보
     */
    @PostMapping("/post")
    public Recruit createRecruit(@RequestBody Recruit recruit) {
        Recruit savedRecruit = recruitRepository.save(recruit);
        return savedRecruit;
    }

    /**
     * 공연 모집 정보를 업데이트하는 엔드포인트입니다.
     *
     * @param id          업데이트할 공연 모집 정보의 ID
     * @param newRecruit  새로운 공연 모집 정보
     * @return 업데이트된 공연 모집 정보
     */
    @PutMapping("/put/{id}")
    public Recruit updateRecruit(@PathVariable Long id, @RequestBody Recruit newRecruit) {
        Recruit existingRecruit = recruitRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Text not found with id: " + id));

         existingRecruit.setYoutubeLink(newRecruit.getYoutubeLink());
         
         return recruitRepository.save(existingRecruit);
    }

    /**
     * 공연 모집 정보를 삭제하는 엔드포인트입니다.
     *
     * @param id 삭제할 공연 모집 정보의 ID
     */
    @DeleteMapping("/delete/{id}")
    public void deleteRecruit(@PathVariable Long id) {
        recruitRepository.deleteById(id);
    }
}