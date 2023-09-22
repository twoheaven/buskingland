package com.buskingland.subpage.text;

public enum Division {
    // 버스킹(노래)
    BUSKING_ACOUSTIC_BAND("버스킹 어쿠스틱밴드"),                // 어쿠스틱 밴드 부문
    BUSKING_ACOUSTIC_GUITAR_VOCAL("버스킹 통기타보컬"),          // 통기타 보컬 부문
    BUSKING_KAYO_POP("버스킹 가요&팝"),                         // 가요 & 팝 부문
    BUSKING_ACAPELLA("버스킹 아카펠라"),                         // 아카펠라 부문
    BUSKING_POP_OPERA("버스킹 팝페라"),                         // 팝페라 부문
    BUSKING_VOCAL_ENSEMBLE("버스킹 성악&합창"),               // 성악 & 합창 부문
    BUSKING_TROT("버스킹 트로트"),                               // 트로트 부문
    BUSKING_HIPHOP_BEATBOX("버스킹 힙합&비트박스"),        // 힙합 & 비트박스 부문
    
    // 버스킹(연주)
    BUSKING_JAZZ_BAND("버스킹 재즈밴드"),                      // 재즈 밴드 부문
    BUSKING_DJ("버스킹 DJ"),                                       // DJ 부문
    BUSKING_CLASSICAL_ENSEMBLE("버스킹 클래식앙상블"),    // 클래식 앙상블 부문
    BUSKING_ELECTRIC_STRING("버스킹 전자현악/퓨전국악"), // 전자현악/퓨전국악 부문
    BUSKING_BRASS_BAND("버스킹 브라스밴드"),                // 브라스 밴드 부문
    BUSKING_MATCHING_BAND("버스킹 마칭밴드"),              // 마칭 밴드 부문
    BUSKING_ROCK_BAND("버스킹 락밴드"),                      // 락 밴드 부문
    
    // 버스킹(퍼포먼스)
    BUSKING_MEDIA_PERFORMANCE("버스킹 미디어퍼포먼스"),    // 미디어 퍼포먼스 부문
    BUSKING_LASER_TRON("버스킹 레이저트론"),                    // 레이저트론 부문
    BUSKING_MAGIC_BUBBLE("버스킹 매직&버블"),                 // 매직 & 버블 부문
    BUSKING_JUGGLING_MIME("버스킹 저글링&마임"),            // 저글링 & 마임 부문
    BUSKING_TAAK_NANTA("버스킹 타악(난타)"),                 // 타악(난타) 부문
    BUSKING_TAEKWONDO("버스킹 태권도"),                         // 태권도 부문
    BUSKING_BRUSH_CALLIGRAPHY("버스킹 붓글씨퍼포먼스"), // 붓글씨 퍼포먼스 부문
    BUSKING_ETC("버스킹 그 외 퍼포먼스"),                    // 기타 퍼포먼스 부문
    
    // 버스킹(댄스&무용)
    BUSKING_B_BOYING("버스킹 비보이&스트릿 댄스"),       // 비보이 & 스트릿 댄스 부문
    BUSKING_K_POP_DANCE("버스킹 케이팝 댄스"),                // 케이팝 댄스 부문
    BUSKING_CHEER("버스킹 치어리더"),                            // 치어리더 부문
    BUSKING_MODERN("버스킹 현대무용&발레"),                // 현대무용 & 발레 부문
    BUSKING_TRADITIONAL("버스킹 전통무용"),                // 전통무용 부문
    BUSKING_POLE_VALLEY("버스킹 폴&밸리 댄스"),            // 폴 & 밸리 댄스 부문
    
    // 버스킹(MC&아나운서)
    BUSKING_MC("버스킹 MC"),                                       // MC 부문
    BUSKING_ANNOUNCER("버스킹 아나운서"),                    // 아나운서 부문
    
    // 연예인
    CELEB_K_POP_IDOL("연예인 K.POP(아이돌)"),                  // 아이돌 가수 부문
    CELEB_GENERAL_KAYO("연예인 일반가요"),                      // 일반 가수 부문
    CELEB_TROT("연예인 트로트"),                                   // 트로트 가수 부문
    CELEB_HIPHOP_DJ("연예인 힙합DJ"),                           // 힙합 DJ 부문
    CELEB_BAND("연예인 밴드"),                                      // 연예인 밴드 부문
    CELEB_ANNOUNCER("연예인 아나운서"),                        // 연예인 아나운서 부문
    CELEB_COMEDIAN("연예인 개그맨"),                           // 연예인 개그맨 부문
    CELEB_YOUTUBER("연예인 유튜버/인플루언서"),         // 유튜버/인플루언서 부문
    
    // 시스템
    SYSTEM_SOUND("시스템 음향"),                                   // 음향 시스템 부문
    SYSTEM_LIGHTING("시스템 조명"),                                 // 조명 시스템 부문
    SYSTEM_VIDEO("시스템 영상(LED,빔)"),                     // 영상 시스템 부문
    SYSTEM_RELAY("시스템 중계"),                                   // 중계 시스템 부문
    SYSTEM_LASER("시스템 특수조명"),                             // 특수조명 시스템 부문
    SYSTEM_STRUCTURE("시스템 구조물(트러스,레이저)"),  // 구조물 시스템 부문
    SYSTEM_SPECIAL_EFFECTS("시스템 특수효과(장치,불꽃놀이)"), // 특수효과 시스템 부문
    SYSTEM_STAGE("시스템 무대"),                                   // 무대 시스템 부문
    SYSTEM_CHAIR("시스템 전식"),                                   // 전식 시스템 부문
    SYSTEM_POWER_CAR("시스템 발전차"),                       // 발전차 시스템 부문
    SYSTEM_STAGE_CAR("시스템 무대차");                       // 무대차 시스템 부문
    
    private final String value;
    
    Division(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}