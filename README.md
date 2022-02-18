<p align='center' style='font-size:150%'>Sejong-University-Auto-Apply는 자동화 크롬을 통해 수강신청을 계속 합니다.</p>

# :star: 특징
## Main.java
>1. [완료] 수강신청 계속하기
>2. [예정] 수강정정기간 보안 문자 뚫기 

## Main.py
>1. [완료] 수강신청 계속하기



# :white_check_mark: 실행방법

## 1.  Git Bash를 이용하여 clone or Git Bash가 없다면 아래 참고
```    
$ cd .. 
$ cd .. 
$ (/c 에서) git clone https://github.com/jinyong3512/Sejong-University-Auto-Apply.git
```    
>("Updating files: 100% (7645/7645), done." 라고 나오면 그때부터 사용 가능)

## 1. (참고) Git Bash 없으면 Download ZIP 

![image](https://user-images.githubusercontent.com/88269663/154381764-ad8874b1-7f53-4ad5-95db-6181cd728d58.png)
>1. Code -> Download ZIP 
>
>2. 압축 풀기
>
>3. 폴더명 "Sejong-University-Auto-Apply"로 바꾸고 C드라이브에 위치 시켜주기
>
>(C:\Sejong-University-Auto-Apply\chromedriver.exe 이런 식으로 위치하게)

## 2.  chromedriver 다운 받기

>본인 컴퓨터의 크롬 버전을 확인한 후 크롬 버전에 맞는 chromedriver.exe를 다운로드합니다.

>크롬 버전 확인 방법: https://blog.naver.com/kiddwannabe/221539689821

>chromedriver.exe 다운: https://chromedriver.chromium.org/downloads

>C드라이브에 있는 Sejong-University-Auto-Apply 안에 chromedriver.exe를 자신이 다운받은 chromedriver.exe로 덮어주세요.



## 3.  보안 프로그램 삭제 하기

>학교 로그인할 때 쓰는 키보드 보안 프로그램을 삭제해야 합니다.

>프로그램 추가/제거에서 nProtect Online Security V1.0을 제거해 주세요!



## 4.  실행 도구

### Java  
>IDE로 프로젝트를 열고 **Run Main.java**
>(꼭 폴더 열기로 Sejong-University-Auto-Apply 열어야함 !)

### Python  
>1. cmd 열고 'pip install selenium'
>2. IDE로 프로젝트를 열고 **Run Main.py** or **Main.py** 오른쪽 마우스 눌러서 **Edit with idle**로 열어서 **Run**
>
>(IDE로 열려면 꼭 폴더 열기로 Sejong-University-Auto-Apply 열어야함 !)

# 😞 한계
> 1. 여러 과목을 입력 해놔도 하나라도 성공할 시 프로그램이 멈춥니다.
> 
> 2. 학수 번호 검색 시 여러 과목이 뜰 경우 예를 들어 순번 3번이 성공할 경우 순번 4번에 있던 게 3번이 되기 때문에 수강신청에 성공했지만 안 멈추고 계속 신청할 수 있습니다.
> 
# :page_with_curl: 라이센스
>APACHE LICENSE, VERSION 2.0
