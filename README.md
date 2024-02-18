<p align='center' style='font-size:150%'>sejong-university-course-registration-auto</p>
<p align='center' style='font-size:150%'>자동화 크롬을 이용한 수강신청 매크로</p>

# 주제
웹 애플리케이션 자동화 프레임워크인 Selenium과 CAPTCHA 이미지를 읽기 위한 OpenCV를 이용한 대학교 수강 신청 매크로

학번, 비밀번호, 수강 신청하고 싶은 과목 정보를 입력하면 자리가 생길 때까지 계속 신청을 시도하고 자리가 생길 시 수강 신청을 마무리

## 기술 스택
Selenium Java OpenCV Tess4j

## 기간
2021.09 ~ 2023.06

# [시연 영상](https://jinyong3512.notion.site/sejong-university-course-registration-auto-79d7deff558c4d00ae422258b4fa9571?pvs=4) 

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
