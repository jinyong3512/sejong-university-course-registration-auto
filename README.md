<p align='center' style='font-size:150%'>Sejong-University-Auto-Apply는 자동화 크롬을 통한 수강신청 매크로입니다</p>

# :star: 특징

## Main.java
>1. [2022 겨울 계절학기 업데이트] 수강신청 기간 작동
>2. [2022 겨울 계절학기 업데이트] 수강신청 변경 기간 작동

### 과정
>1. ID, PW, 수강신청 정보 입력받기
>2. ChromeDriver 설정
>3. URL 접속 후 팝업창 닫고 ID PW 입력 후 로그인
>4. 해상도에 따른 알림 창 지우기
>5. Simple_GUI 검사 (이후 버튼들 xpath 달라지는 이유)
>6. 수강신청 조회 페이지까지 이동하기
>7. 학수 번호 분반 입력 후 검색 후 몇 번째 위치인지에 따라 신청 버튼 클릭
>8. 수강신청 변경 기간인지 검사 (기간이라면 CAPTCHA 처리)
>9. 수강신청 클릭 마무리하기 (성공 시 비프음 1분 알림 이후 종료) (실패 시 7번으로 돌아가기)

## Main.py
>1. [업데이트 안 했음] 수강신청 기간 작동

### 과정
>1. ID, PW, 수강신청 정보 입력받기
>2. ChromeDriver 설정
>3. URL 접속 후 팝업창 닫고 ID PW 입력 후 로그인
>4. 해상도에 따른 알림 창 지우기
>5. Simple_GUI 검사 (이후 버튼들 xpath 달라지는 이유)
>6. 수강신청 조회 페이지까지 이동하기
>7. 학수 번호 분반 입력 후 검색 후 몇 번째 위치인지에 따라 신청 버튼 클릭
>8. 수강신청 클릭 마무리하기 (성공 시 비프음 10초 알림 이후 종료) (실패 시 7번으로 돌아가기)


# :white_check_mark: 실행 방법

## 1.  Git Bash를 이용하여 clone
```    
$ (/c에서) git clone https://github.com/jinyong3512/Sejong-University-Auto-Apply.git
```    
>(C 드라이브에 폴더명 "Sejong-University-Auto-Apply" 맞추기 필수)

## 2.  chromedriver 다운로드하기

>본인 컴퓨터의 크롬 버전을 확인한 후 크롬 버전에 맞는 chromedriver.exe를 다운로드합니다
>
>크롬 버전 확인 방법: https://blog.naver.com/kiddwannabe/221539689821
>
>chromedriver.exe 다운: https://chromedriver.chromium.org/downloads
>
>C 드라이브에 있는 Sejong-University-Auto-Apply 안에 chromedriver.exe를 자신이 다운로드한 chromedriver.exe로 덮어주세요

## 3.  보안 프로그램 삭제하기

>학교 로그인할 때 쓰는 키보드 보안 프로그램을 삭제해야 합니다
>
>프로그램 추가/제거에서 nProtect Online Security V1.0을 제거해 주세요
 
## 4
시스템 -> 디스플레이 설정에서 배율 100%로 설정

## 5.  실행 도구

### Java  
>1. IDE로 프로젝트를 열고 **Run Main.java**
>
>(꼭 프로젝트로 Sejong-University-Auto-Apply 열어야 함!)

### Python  
>1. cmd 열고 'pip install selenium'
>2. [IDE로 프로젝트를 열고 **Run Main.py**] 혹은 [**Main.py** 오른쪽 마우스 눌러서 **Edit with idle**로 열어서 **Run**]
>
>(IDE로 열려면 꼭 프로젝트로 Sejong-University-Auto-Apply 열어야 함!)

# 😞 한계
>1. 수강신청 변경 기간 CAPTCHA 뚫을 확률이 30% 정도 되는 것 같습니다
>2. Python은 CAPTCHA 구현 못 했습니다

# :page_with_curl: 라이선스
>APACHE LICENSE, VERSION 2.0
