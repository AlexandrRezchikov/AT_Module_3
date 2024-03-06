package com.bolshayastrana.tests;

import com.bolshayastrana.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static com.bolshayastrana.RegexForNumberOfTours.regexForNumberOfTours;

public class SeleniumTest extends BaseTest {

    //переменная для записи количества найденных туров
    public static String numberOfTours;
    //карточка тура
    public static final By cardOfTours = By.xpath("//section[@id=\"group-initial\"]//div[@class=\"as-col tour-previews__col\"]");

    @Test
    public void test1() {

        //Проверка title
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Большая Страна — Все туры по России"));

        //Выбор региона
        WebElement placeholderRegion = driver
                .findElement(By.xpath("//input[@placeholder=\"Введите регион, место или тур\" and @name=\"search\"]"));
        placeholderRegion.click();
        placeholderRegion.sendKeys("Карелия");

        WebElement searchResultRegion = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-filters-dropdown']//a[@href=\"/kareliya\"]")));
        searchResultRegion.click();

        //Выбор тура
        WebElement placeholderTours = driver.findElement(By.xpath("//input[@placeholder='Любой']"));
        placeholderTours.click();
        WebElement dropdownViewTour = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-id=\"15\" and @data-type=\"rest_kinds\"]")));
        dropdownViewTour.click();

        //Выбор даты
        WebElement placeholderTourDates = driver.findElement(By.xpath("//input[@placeholder=\"Любые\"]"));
        placeholderTourDates.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement tourDates = driver
                .findElement(By.cssSelector(".search-filter-dates__period-btns > button:nth-child(3) > span"));
        tourDates.click();

        //Нажать кнопку "Найти туры"
        WebElement buttonSearchTours = driver.findElement(By.xpath(".//button[contains(., 'Найти туры')]"));
        Assert.assertTrue(buttonSearchTours.isDisplayed(), "Button number of tours is not displayed");
        buttonSearchTours.click();

        //Проверка найднных туров
        WebElement buttonNumberOfTours = driver.findElement(By.xpath(".//button[contains(.,'Найдено')]"));
        Assert.assertTrue(buttonNumberOfTours.isDisplayed(), "Button number of tours is not displayed");
        numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        int numberOfCard = driver.findElements(cardOfTours).size();
        System.out.println("Карточек туров на странице " + numberOfCard);
        Assert.assertEquals(regexForNumberOfTours(numberOfTours), numberOfCard);

        //Выбор дополнительных фильтров для поиска:
        //Проживание
        WebElement buttonSelectApartments = driver.findElement(By.xpath("//div[text()=\"Проживание\"]"));
        buttonSelectApartments.click();
        WebElement checkBoxHotel = driver.findElement(By.xpath(".//span[contains(., 'Гостиница')]"));
        checkBoxHotel.click();
        //Комфорт проживания
        WebElement buttonSelectComfortOfTheApartments = driver.findElement(By.xpath("//div[text()=\" Комфорт проживания \"]"));
        buttonSelectComfortOfTheApartments.click();
        WebElement checkBoxHigh = driver.findElement(By.xpath("//div[@class=\"collapse__body\"]//span[contains(., 'Высокий')]"));
        checkBoxHigh.click();
        //Уровень сложности
        WebElement buttonSelectLevelDifficulty = driver.findElement(By.cssSelector("#filter-difficulty use"));
        buttonSelectLevelDifficulty.click();
        WebElement checkBoxBasic = driver
                .findElement(By.xpath("//*[@id=\"search-filter-difficulty\"]/label[1]/div/span[@class=\"as-checkbox__icon\"]"));
        checkBoxBasic.click();

        //Проверка найднных туров
        Assert.assertTrue(buttonNumberOfTours.isDisplayed(), "Button number of tours is not displayed");
        numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        int numberOfCard2 = driver.findElements(cardOfTours).size();
        System.out.println("Карточек туров на странице " + numberOfCard2);
        Assert.assertEquals(regexForNumberOfTours(numberOfTours), numberOfCard2);
    }

    @Test
    public void test2() {

        //Проверка title
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Большая Страна — Все туры по России"));

        //Выбор региона
        WebElement placeholderRegion = driver
                .findElement(By.xpath("//input[@placeholder=\"Введите регион, место или тур\" and @name=\"search\"]"));
        placeholderRegion.click();
        placeholderRegion.sendKeys("Карелия");
        WebElement searchResultRegion = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-filters-dropdown']//a[@href=\"/kareliya\"]")));
        searchResultRegion.click();

        //Выбор тура
        WebElement placeholderTours = driver.findElement(By.xpath("//input[@placeholder='Любой']"));
        placeholderTours.click();
        WebElement dropdownViewTour = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-id=\"15\" and @data-type=\"rest_kinds\"]")));
        dropdownViewTour.click();

        //Выбор даты
        WebElement placeholderTourDates = driver.findElement(By.xpath("//input[@placeholder=\"Любые\"]"));
        placeholderTourDates.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement firstDateTour = driver
                .findElement(By.xpath(".//div[@class=\"dayContainer\"]/span[@aria-label=\"Март 22, 2024\"]"));
        firstDateTour.click();
        WebElement secondDateTour = driver
                .findElement(By.xpath(".//div[@class=\"dayContainer\"]/span[@aria-label=\"Март 25, 2024\"]"));
        secondDateTour.click();

        //Нажать кнопку "Найти туры"
        WebElement buttonSearchTours = driver.findElement(By.xpath(".//button[contains(., 'Найти туры')]"));
        Assert.assertTrue(buttonSearchTours.isDisplayed(), "Button number of tours is not displayed");
        buttonSearchTours.click();

        //Проверка найднных туров
        WebElement buttonNumberOfTours = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(.,'Найдено')]")));
        Assert.assertTrue(buttonNumberOfTours.isDisplayed(), "Button number of tours is not displayed");
        numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        int numberOfCard = driver.findElements(cardOfTours).size();
        System.out.println("Карточек туров на странице " + numberOfCard);
        Assert.assertEquals(regexForNumberOfTours(numberOfTours), numberOfCard);

        // Выбор диапазона цены
        WebElement sliderMaxPrice = driver.findElement(By.xpath("//div[@aria-valuenow=\"200000\"]"));
        Actions slider = new Actions(driver);
        slider.moveToElement(sliderMaxPrice).dragAndDropBy(sliderMaxPrice, -180, 0).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(.,'Найдено 0 туров')]")));
        Assert.assertTrue(buttonNumberOfTours.isDisplayed(), "Button number of tours is not displayed");
        numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        System.out.println("Карточек туров на странице " + 0);
        Assert.assertEquals(regexForNumberOfTours(numberOfTours), 0);
    }

    @Test
    public void test3() {
        //Проверка title
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Большая Страна — Все туры по России"));

        //Выбор региона
        WebElement placeholderRegion = driver
                .findElement(By.xpath("//input[@placeholder=\"Введите регион, место или тур\" and @name=\"search\"]"));
        placeholderRegion.click();
        placeholderRegion.sendKeys("Карелия");
        WebElement searchResultRegion = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-filters-dropdown']//li[@class=\"search-autocomplete-group__item\"]")));
        searchResultRegion.click();

        //Выбор тура
        WebElement placeholderTours = driver.findElement(By.xpath("//input[@placeholder='Любой']"));
        placeholderTours.click();
        WebElement dropdownViewTour = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-id=\"15\" and @data-type=\"rest_kinds\"]")));
        dropdownViewTour.click();

        //Выбор даты
        WebElement placeholderTourDates = driver.findElement(By.xpath("//input[@placeholder=\"Любые\"]"));
        placeholderTourDates.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement tourDates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(., 'Майские праздники')]")));
        tourDates.click();

        //Нажать кнопку "Найти туры"
        WebElement buttonSearchTours = driver.findElement(By.xpath(".//button[contains(., 'Найти туры')]"));
        Assert.assertTrue(buttonSearchTours.isDisplayed(), "Button number of tours is not displayed");
        buttonSearchTours.click();

        WebElement buttonWatchTheTour = driver.findElement(By.xpath("//div[@class=\"tour-preview\"]//span[contains(.,'Смотреть тур')]"));
        buttonWatchTheTour.click();

        //Переключение на новый фрейм
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String nextWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                nextWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(nextWindowHandle);

        WebElement buttonReserve = driver.findElement(By.xpath("//div[@class=\"tour-sidebar\"]//button[contains(., 'Забронировать места')]"));
        buttonReserve.click();
        WebElement buttonGoToBack = driver.findElement(By.xpath(".//span[contains(., 'Вернуться')]"));
        Assert.assertTrue(buttonGoToBack.isDisplayed());

        //Формма брони
        //Выбор дат
        WebElement placeholderSelectTourDate = driver.findElement(By.cssSelector(".as-input__append"));
        placeholderSelectTourDate.click();
        WebElement selectTourDate = driver.findElement(By.xpath("//li[@class='as-select__list-item']//strong[text()='3—5 мая']"));
        selectTourDate.click();

        //Форма брони
        //Ввод ФИО
        WebElement formName = driver.findElement(By.xpath("//input[@name='name']"));
        formName.click();
        formName.sendKeys(resource.getString("name"));

        //Форма брони
        //Ввод номера телефона
        WebElement formPhoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        formPhoneNumber.click();
        formPhoneNumber.sendKeys(resource.getString("phoneNumber"));

        //Форма брони
        //Ввод email
        WebElement formEmail = driver.findElement(By.xpath("//input[@name='email']"));
        formEmail.sendKeys(resource.getString("mail"));

        //Нажать на кнопку "Отправить заявку"
        WebElement buttonSendRequest = driver.findElement(By.xpath("//button[@name='submit']"));
        Assert.assertTrue(buttonSendRequest.isDisplayed());
        buttonSendRequest.click();

        //Проверка присутствия ошибки некорректного номера телефона
        WebElement errorMessageValidatingPhoneNumber = driver
                .findElement(By.xpath("//span[contains(., 'Введите корректный номер телефона')]"));
        Assert.assertTrue(errorMessageValidatingPhoneNumber.isDisplayed());
    }
}
