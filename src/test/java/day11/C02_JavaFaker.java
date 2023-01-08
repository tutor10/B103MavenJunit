package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javaFakerTest(){
        // 1. FAKER OBJESI OLUSTUR
       Faker faker = new Faker();

       // 2.FAKER OBJESI ILE FAKE DATA OLUSTUR

        //FIRST NAME DATASI
        String firstName=faker.name().firstName();
        System.out.println(firstName);

        //LAST NAME DATASI
        String lastName =faker.name().lastName();
        System.out.println(lastName);

        //KULLANICI ADI
        String userName = faker.name().username();
        System.out.println(userName);

        //MESLEK ISMI
        String jobTitle = faker.name().title();
        System.out.println(jobTitle);

        //SEHIR ISMI
        String cityName = faker.address().city();
        System.out.println(cityName);

        //EYALET ISMI
        String stateName = faker.address().state();
        System.out.println(stateName);

        //FULL ADDRESS
        String fAddress = faker.address().fullAddress();
        System.out.println(fAddress);

        //CEP TELEFON NUMARASI
        String mobileNumber = faker.phoneNumber().cellPhone();
        System.out.println(mobileNumber);

        //EMAIL
        String email= faker.internet().emailAddress();
        System.out.println(email);

        //POST CODE
        String postCode = faker.address().zipCode();
        System.out.println(postCode);

        //RASTGELE 15 HANELI NUMARA
        String  randomNumber = faker.number().digits(15);
        System.out.println(randomNumber);

        /*
          TEST DATA : kullanici adi, sifre, tel no, e-mail, sehir, kredi kart no,...
          Test datalari kimden alinir?
          1- BA-Business Analyst (Acceptance Criteria'lari yazar)
          2- Test Lead
          3- Manual Tester
          4- Tech Lead & Team Lead & DEV Lead
          5- Developer
          6- Database
          7- API call'lar
          8- Documentations. Ornegin, API swagger dokumani.
          9- Java Faker da fake data almak icin kullaniyoruz.
          NERDEN GELMEZ : kullanicidan alinmaz, scrum master,..
       */


        //Faker Kutuphanesi HOMEWORK
       //Faker class'i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
       //degerler uretmemize imkan tanir.
       //Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.
       //"https://facebook.com"  Adresine gidin
       //"create new account"  butonuna basin
       //"firstName" giris kutusuna bir isim yazin
       //"surname" giris kutusuna bir soyisim yazin
       //"email" giris kutusuna bir email yazin
       //"email" onay kutusuna emaili tekrar yazin
       //Bir sifre girin
       //Tarih icin gun secin
       //Tarih icin ay secin
       //Tarih icin yil secin
       //Cinsiyeti secin
       //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
       //Sayfayi kapatin

    }
}


