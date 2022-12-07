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

import java.awt.Toolkit;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static String id;
    static String pw;
    static ArrayList<ArrayList<String>> informations = new ArrayList<>();
    static ChromeDriver driver;
    static boolean simple_GUI = false;

    public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
        get_informations();
        set_ChromeDriver();
        go_Course_Registration_Page();
        register_Course();
    }

    public static void get_informations() {
        System.out.print("id를 입력하세요 ");
        id = scan.nextLine();

        System.out.print("pw를 입력하세요 ");
        pw = scan.nextLine();

        System.out.println("(학수번호, 분반, 검색 시 몇 번째 위치)를 입력하세요 ex)106245 001 1    [그만 입력하려면 대문자 X를 입력하세요]");
        while (true) {
            String input_Line = scan.nextLine();

            if (input_Line.equals("X")) break;

            ArrayList<String> information = new ArrayList<>();
            information.add(input_Line.split(" ")[0]);
            information.add(input_Line.split(" ")[1]);
            information.add(input_Line.split(" ")[2]);

            informations.add(information);
        }
    }

    public static void set_ChromeDriver() {
        String WEB_DRIVER_ID = "chromedriver.exe";
        String WEB_DRIVER_PATH = "C:/Sejong-University-Auto-Apply";

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void go_Course_Registration_Page() throws InterruptedException {
        driver.get("https://portal.sejong.ac.kr/jsp/login/loginSSL.jsp?rtUrl=sjpt.sejong.ac.kr/main/view/Login/doSsoLogin.do?p=");

        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[1]/input")).sendKeys(id);
        driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[2]/input")).sendKeys(pw);
        driver.findElement(By.xpath("/html/body/form/div/div/div[2]/a")).click();

        try {
            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a")).click();
        } catch (Exception e) {

        }

        if (driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/ul/li/div[1]/a")).getText().equals("수강신청"))
            simple_GUI = true;

        if (simple_GUI) {
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/a")).click();
        } else {
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/span")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[1]/td[3]/span")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[2]/div/div[4]/table/tbody/tr/td[3]/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/a")).click();
            Thread.sleep(1000);
        }
    }

    public static void register_Course() throws InterruptedException, IOException, TesseractException {
        int informations_Index = 0;
        int change_Period_Flag = -1;

        while (true) {
            informations_Index = informations_Index % informations.size();

            if (simple_GUI) {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[1]")).clear();
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[1]")).sendKeys(informations.get(informations_Index).get(0));
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[2]")).clear();
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[2]")).sendKeys(informations.get(informations_Index).get(1));
            } else {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[1]")).clear();
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[1]")).sendKeys(informations.get(informations_Index).get(0));
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[2]")).clear();
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[3]/div[3]/input[2]")).sendKeys(informations.get(informations_Index).get(1));
            }

            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[5]/a")).click();
            Thread.sleep(1000);

            switch (informations.get(informations_Index).get(2)) {
                case "1" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[2]/button")).click();
                case "2" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[2]/td[2]/button")).click();
                case "3" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]/button")).click();
                case "4" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[4]/td[2]/button")).click();
                case "5" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[5]/td[2]/button")).click();
                case "6" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[6]/td[2]/button")).click();
                case "7" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[7]/td[2]/button")).click();
                case "8" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[8]/td[2]/button")).click();
                case "9" -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[9]/td[2]/button")).click();
                default -> {
                    System.out.println("검색 시 위치 입력 오류입니다. 학수 번호 분반 검색 시 몇 번째 위치인지 잘 입력하세요.");
                    System.exit(0);
                }
            }
            Thread.sleep(1000);

            if (change_Period_Flag == -1) {
                try {
                    driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/div[1]/iframe"));
                    change_Period_Flag = 1;
                } catch (Exception e) {
                    change_Period_Flag = 0;
                }
            }

            if (change_Period_Flag == 1) {
                pass_CAPTCHA();
            }

            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a[2]")).click();
            Thread.sleep(1000);

            if (driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div")).getText().equals("수강여석이 없습니다!")
                    || driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div")).getText().equals("입력된 코드가 일치하지 않습니다.")) {
                driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a")).click();

                informations_Index++;
            } else {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 60; i++) {
                    toolkit.beep();
                    Thread.sleep(1000);
                }
                System.exit(0);
            }
        }
    }

    public static void pass_CAPTCHA() throws IOException, TesseractException {

        // 캡쳐하고 싶은 element 찾기
        WebElement ele = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/div[1]/iframe"));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        Point point = ele.getLocation();

        // Get width and height of the element
        int eleWidth = ele.getSize().getWidth() + 5;
        int eleHeight = ele.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

        // Save File to disk
        ImageIO.write(eleScreenshot, "png", new File("elem_screen_shot.png"));

        // OCR dll 파일 시스템 로드
        System.load("C://Sejong-University-Auto-Apply//opencv//build//java//x64//opencv_java455.dll");

        Mat image = Imgcodecs.imread("elem_screen_shot.png");

        // Gray Scale
        Mat imageGray = new Mat();
        Imgproc.cvtColor(image, imageGray, Imgproc.COLOR_RGB2GRAY);

        // Resize
        Mat imageResize = new Mat();
        Size size = new Size(2000, 1000);
        Imgproc.resize(imageGray, imageResize, size);

        // Equalize
        Mat imageEqualizedGray = new Mat();
        Imgproc.equalizeHist(imageResize, imageEqualizedGray);

        // Binarization
        Mat imageBinarizationGray = new Mat();
        Imgproc.threshold(imageEqualizedGray, imageBinarizationGray, 1, 255, Imgproc.THRESH_BINARY);
        Imgcodecs.imwrite("C://Sejong-University-Auto-Apply//result.png", imageBinarizationGray);

        // 인식시키기
//        String testResourcesDataPath = "C://Sejong-University-Auto-Apply//Tess4J//tessdata";
        Tesseract instance = new Tesseract();
        instance.setDatapath(new File("C://Sejong-University-Auto-Apply//Tess4J").getPath());
        instance.setLanguage("eng");
        ImageIO.scanForPlugins();
        File imageFile = new File("C://Sejong-University-Auto-Apply//result.png");
        String result = instance.doOCR(imageFile);

        result = result.replaceAll("[^0-9]", "");

        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/div[2]/input")).sendKeys(result);
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/a[1]")).click();
    }
}