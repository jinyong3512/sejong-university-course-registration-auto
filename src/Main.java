import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        // 학번과 비밀번호 수강신청 정보 설정
        Scanner scan = new Scanner(System.in);
        System.out.print("ID를 입력하세요 ");
        String ID = scan.nextLine();
        System.out.print("PW를 입력하세요 ");
        String PW = scan.nextLine();
        System.out.println("(학수번호,분반,검색시 몇번째 위치)를 입력하세요 ex)106245 001 1    그만 입력 하려면 X를 입력하세요");
        ArrayList<ArrayList<String>> informations = new ArrayList<ArrayList<String>>();
        while (true) {
            String input_line = scan.nextLine();
            if (input_line.equals("X"))
                break;
            ArrayList<String> information = new ArrayList<String>();
            information.add(input_line.split(" ")[0]);
            information.add(input_line.split(" ")[1]);
            information.add(input_line.split(" ")[2]);
            informations.add(information);
        }

        // ChromeDriver 이름 과 설치경로
        String WEB_DRIVER_ID = "chromedriver.exe";
        String WEB_DRIVER_PATH = "C:/Sejong-University-Auto-Apply";

        // ChromeDriver 경로 시스템 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // 크롬옵션 만들어 주기
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // option 넣고 driver 변수 만들기
        ChromeDriver driver = new ChromeDriver(options);

        // driver 변수 설정
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 학사정보 시스템 URL 접속
        String URL = "https://portal.sejong.ac.kr/jsp/login/loginSSL.jsp?rtUrl=sjpt.sejong.ac.kr/main/view/Login/doSsoLogin.do?p=";
        driver.get(URL);

        // 키보드 보안 팝업 취소 후 확인
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();

        // ID PW 입력후 로그인 버튼 클릭
        driver.findElement(By.xpath("/html/body/form/div[2]/div/div[2]/div[1]/input")).sendKeys(ID);
        driver.findElement(By.xpath("/html/body/form/div[2]/div/div[2]/div[2]/input")).sendKeys(PW);
        driver.findElement(By.xpath("/html/body/form/div[2]/div/div[2]/a")).click();
        Thread.sleep(1000);

        // 수업/성적 클릭
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/span")).click();

        // 강좌조회 및 수강신청 클릭
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[1]/td[3]/span")).click();

        // 수강신청 클릭
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[2]/div/div[4]/table/tbody/tr/td[3]/span")).click();

        // NEXT 버튼 클릭
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/a")).click();
        Thread.sleep(1000);

        int index = 0;
        while (true) {
            index = index % informations.size();

            // 학수번호 입력
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[1]")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[1]")).sendKeys(informations.get(index).get(0));

            // 분반 입력
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[2]")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[2]")).sendKeys(informations.get(index).get(1));

            // 검색 버튼 클릭
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[5]/a")).click();
            Thread.sleep(1000);

            // 신청 버튼 클릭
            switch (informations.get(index).get(2)) {
                case "1":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[2]/button")).click();
                    break;
                case "2":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[2]/td[2]/button")).click();
                    break;
                case "3":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]/button")).click();
                    break;
                case "4":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[4]/td[2]/button")).click();
                    break;
                case "5":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[5]/td[2]/button")).click();
                    break;
                case "6":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[6]/td[2]/button")).click();
                    break;
                case "7":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[7]/td[2]/button")).click();
                    break;
                case "8":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[8]/td[2]/button")).click();
                    break;
                case "9":
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[9]/td[2]/button")).click();
                    break;
                default:
                    System.out.println("분반 입력 오류 입니다. 분반은 1부터 9까지 입니다.");
                    System.exit(0);
            }
            Thread.sleep(1000);

            // "선택한 과목을 수강신청 하시겠습니까?" 확인 클릭
            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a[2]")).click();
            Thread.sleep(1000);

            // "수강여석이 없습니다" 확인 클릭 or "신청 되었습니다 재조회 하시겠습니까?" 취소 클릭
            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a")).click();
            Thread.sleep(1000);

            index++;
        }
    }
}