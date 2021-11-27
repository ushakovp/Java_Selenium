import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Trainer {
    static WebDriver wd;

    public static void main(String[] args) throws InterruptedException {

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wd.get("http://xn--e1axes.h1n.ru/node/5");
        String result;
        int[] intOperands;

        while (isElementPresent(By.name("exp"))) {
            Thread.sleep(900);
            intOperands = getIntOperands();

            List<WebElement> operators = wd.findElements(By.cssSelector(".mrow .mo"));
            result = calculate(intOperands, operators.get(0).getText());

            wd.findElement(By.cssSelector("#eresult")).sendKeys(result);
        }
    }

    private static int[] getIntOperands() {
        int[] operand = new int[2];
        List<WebElement> operands = wd.findElements(By.cssSelector(".mrow .mn"));
        operand[0] = Integer.parseInt(operands.get(0).getText());
        operand[1] = Integer.parseInt(operands.get(1).getText());
        return operand;
    }

    private static String calculate(int[] operands, String operator) {
        if (operator.equals("+")) {
            return String.valueOf(operands[0] + operands[1]);
        } else {
            return String.valueOf(operands[0] - operands[1]);
        }
    }

    private static boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
