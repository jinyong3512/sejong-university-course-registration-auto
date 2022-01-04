import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 학번과 비밀번호 수강신청정보 설정
        Scanner scan = new Scanner(System.in);
        System.out.print("ID를 입력하세요 ");
        String ID = scan.nextLine();
        System.out.print("PW를 입력하세요 ");
        String PW = scan.nextLine();
        System.out.println("(학수번호,분반,검색시 몇번째 위치)를 입력하세요 ex)106245 001 1    그만 입력 하려면 X를 입력하세요");
        ArrayList<ArrayList<String>> informations = new ArrayList<ArrayList<String>>();
        while(true){
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

    }
}