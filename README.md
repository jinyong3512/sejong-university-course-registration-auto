<p align='center' style='font-size:150%'>sejong-university-course-registration-automation-project</p>
<p align='center' style='font-size:150%'>자동화 크롬을 이용한 수강신청 매크로</p>

# 주제
웹 애플리케이션 자동화 프레임워크인 Selenium과 CAPTCHA 이미지를 읽기 위한 OpenCV를 이용한 대학교 수강 신청 매크로

학번, 비밀번호, 수강 신청하고 싶은 과목 정보를 입력하면 자리가 생길 때까지 계속 신청을 시도하고 자리가 생길 시 수강 신청을 마무리

## 기술 스택
Selenium Java OpenCV Tess4j

## 기간
2021.09 ~ 2023.06

# [시연 영상](https://www.notion.so/jinyong3512/sejong-university-course-registration-automation-project-79d7deff558c4d00ae422258b4fa9571) 

## 업데이트
>1. [2023 여름학기 업데이트] 수강신청 기간 작동
>2. [2023 여름학기 업데이트] 수강신청 변경 기간 작동

## 프로젝트 진행
개인 프로젝트

## 구현 상세
>1. ID, PW, 수강신청 정보 입력받기
>2. ChromeDriver 설정
>3. URL 접속 후 팝업창 닫고 ID PW 입력 후 로그인
>4. 해상도에 따른 알림 창 지우기
>5. Simple_GUI 검사 (이후 버튼들 xpath 달라지는 이유)
>6. 수강신청 조회 페이지까지 이동하기
>7. 학수 번호 분반 입력 후 검색 후 몇 번째 위치인지에 따라 신청 버튼 클릭
>8. 수강신청 변경 기간인지 검사 (기간이라면 CAPTCHA 처리)
>9. 수강신청 클릭 마무리하기 
>10. 성공 시 비프음 1분 알림 이후 종료 or 실패 시 7번으로 돌아가기

## 어려움
>1. CAPTCHA 인식률이 너무 낮음
>   2. CAPTCHA 이미지가 인식하기에 복잡하다
>      3. 이미지의 전처리 기술들 (Gray Scale, Resize, Equalize, Binarization)을 이용하여 확률 높이기
>2. 컴퓨터마다 Element (CAPTCHA 이미지)의 좌표 값이 다름
>   3. 컴퓨터 시스템 디스플레이 배율이 달라서 생기는 문제
>      4.   컴퓨터 시스템 디스플레이 배율이 100% 기준으로 코딩

## 프로젝트 후기
- 좋은 점
    - Framework 와 Library를 프로젝트에 적용해보는 경험
    - 수업 시간에 배운 이미지 전처리를 이용하였다
    - 많은 버그가 발생하여 많은 디버깅을 경험

- 부족한 점
    - 서버를 이용하여 계속 실행되게 하고 싶었으나 관련 지식 부족으로 IDE가 계속 실행되어야 함 배포를 할 때도 코드만 배포하여 사용자가 직접 실행해야 한다. 완전한 서비스를 개발하기 위해서 프론트와 백의 중요성을 깨닫고 공부의 필요성을 느낌
