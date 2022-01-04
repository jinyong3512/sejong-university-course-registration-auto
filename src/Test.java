import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import java.util.Scanner;
import java.util.ArrayList;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        // ChromeDriver 이름 과 설치경로
        String WEB_DRIVER_ID = "chromedriver.exe";
        String WEB_DRIVER_PATH = "C:/Sejong-University-Auto-Apply";

        // ChromeDriver 경로 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // ChromeDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // driver 옵션 설정
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 학사정보 시스템 URL 접속
        String URL = "https://portal.sejong.ac.kr/jsp/login/loginSSL.jsp?rtUrl=sjpt.sejong.ac.kr/main/view/Login/doSsoLogin.do?p=";
        driver.get(URL);

        // 키보드 보안 팝업 취소 후 확인
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);


    }
}
