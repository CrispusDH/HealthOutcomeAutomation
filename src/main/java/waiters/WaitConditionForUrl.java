package waiters;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum WaitConditionForUrl {

    urlToBe(ExpectedConditions::urlToBe);

    private final Function<String, ExpectedCondition<java.lang.Boolean>> type;

}