package com.buskingland.mainpage.banner;

//RuntimeException을 상속받아서 사용자 정의 예외 클래스인 BannerNotFoundException을 정의합니다.
@SuppressWarnings("serial")
public class BannerNotFoundException extends RuntimeException {
 /**
  * 주어진 id를 사용하여 예외 메시지를 생성하는 생성자 메서드입니다.
  * 
  * @param id 찾을 수 없는 배너의 ID
  */
 public BannerNotFoundException(Long id) {
     super("Banner not found with id: " + id);
 }
}