package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void webTablesTest() {

//        https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

//        Create a class: WebTables
//        Task 1 : Table1’i print edin
        String table1 = driver.findElement(By.xpath("//*[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        System.out.println(table1);

        List<WebElement> tumVeriler = driver.findElements(By.xpath("//*[@id='table1']//td"));
        //    tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMBDA ILE
        for (WebElement w : tumVeriler) {
            System.out.println(w.getText());
        }



//        Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//        Parameter 1 = row numarasi
//        Parameter 2 = column numarasi
//        printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
    }

    @Test
    public void row3Print() {
        //        Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
//        row3Elements.forEach(t-> System.out.println(t.getText()));//LAMBDA
        for (WebElement veri : row3Elements) {
            System.out.println(veri.getText());
        }

    }

    @Test
    public void sonSatirVerileri() {
//        Task 3 : Son row daki dataları print edin
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(t-> System.out.println(t.getText()));//LAMBDA

    }

    @Test
    public void sutun5Test(){
        //        Task 4 : 5. Column datalarini print edin
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(veri-> System.out.println(veri.getText()));//LAMBDA


    }


}