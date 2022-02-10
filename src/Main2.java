import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main2 {
    public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//            // elem_screen_shot.png 얻는 과정
//            // 캡쳐하고 싶은 element 찾기
//            WebElement ele = driver.findElement(By.xpath(???));
//
//            // Get entire page screenshot
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            BufferedImage fullImg = ImageIO.read(screenshot);
//
//            // Get the location of element on the page
//            Point point = ele.getLocation();
//
//            // Get width and height of the element
//            int eleWidth = ele.getSize().getWidth();
//            int eleHeight = ele.getSize().getHeight();
//
//            // Crop the entire page screenshot to get only element screenshot
//            BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//
//            // Save File to disk
//            ImageIO.write(eleScreenshot, "png", new File("elem_screen_shot.png"));
//
//            // OCR dll 파일 시스템 로드
//            System.load("C://Sejong-University-Auto-Apply//opencv//build//java//x64//opencv_java455.dll");
//
//            // Gray Scale
//            Mat image = Imgcodecs.imread("elem_screen_shot.png");
//            Mat imageGray = new Mat();
//            Imgproc.cvtColor(image, imageGray, Imgproc.COLOR_RGB2GRAY);
//
//            // Resize
//            Mat imageResize = new Mat();
//            Size size = new Size(2000, 1000);
//            Imgproc.resize(imageGray, imageResize, size);
//
//            // Equalize
//            Mat imageEqualizedGray = new Mat();
//            Imgproc.equalizeHist(imageResize,imageEqualizedGray);
//
//            // Binarization
//            Mat imageBinarizationGray = new Mat();
//            Imgproc.threshold(imageEqualizedGray,imageBinarizationGray,1,255,Imgproc.THRESH_BINARY);
//            Imgcodecs.imwrite("C://Sejong-University-Auto-Apply//result.png",imageBinarizationGray);
//
//            // 인식시키기
//            String datapath = "C://Sejong-University-Auto-Apply//Tess4J";
//            String testResourcesDataPath= "C://Sejong-University-Auto-Apply//Tess4J//tessdata";
//            Tesseract instance = new Tesseract();
//            instance.setDatapath(new File(datapath).getPath());
//            instance.setLanguage("eng");
//            ImageIO.scanForPlugins();
//            File imageFile = new File("C://Sejong-University-Auto-Apply//result.png");
//            String result = instance.doOCR(imageFile);
//
//            // 문자열 중 숫자만 뽑기
//            result = result.replaceAll("[^0-9]", "");
//
//            // 숫자 판독 결과 입력
//            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/div[2]/input")).sendKeys(result);
//
//            // 코드 입력 버튼 클릭
//            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a[1]")).click();
//            Thread.sleep(1000);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // "선택한 과목을 수강신청 하시겠습니까?" 확인 클릭
            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a[2]")).click();
            Thread.sleep(1000);

            // 수강 신청 성공시 종료 하기
            if ((driver.findElement(By.xpath( ? ? ?)).text).equals( ???)){
                driver.quit();
                System.exit(0);
            }

            // "수강여석이 없습니다" 확인 클릭
            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a")).click();
            Thread.sleep(1000);

            index++;
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////