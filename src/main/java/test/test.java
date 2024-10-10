package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class test {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Maven\\prueba\\src\\main\\resources\\drivers\\chromedriver.exe");

        // Inicializamos el navegador Chrome
        WebDriver driver = new ChromeDriver();

        // Navegamos a la página de login
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        // Flujo 1: Login con contraseña incorrecta
        // Ingresamos un usuario válido
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        // Ingresamos una contraseña incorrecta
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("incorrectPassword");

        // Hacemos clic en el botón de Login
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Aqui hago una pequeña validacion para Verificar el mensaje de error por contraseña incorrecta
        WebElement errorMessage = driver.findElement(By.id("flash"));
        if (errorMessage.getText().contains("Your password is invalid!")) {
            System.out.println("Se ha detectado el mensaje de error correcto para password incorrecto.");
        }
        // Cerramos el navegador
        driver.quit();

        // Flujo 2: Login con usuario incorrecto
        // Aqui realizo los mismos pasos solo que en vez de contraseña, usamos un usuario  incorrecto
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("incorrectUser");

        passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        errorMessage = driver.findElement(By.id("flash"));
        if (errorMessage.getText().contains("Your username is invalid!")) {
            System.out.println("Se ha detectado el mensaje de error correcto para usuario incorrecto.");
        }

        driver.quit();
    }
}
