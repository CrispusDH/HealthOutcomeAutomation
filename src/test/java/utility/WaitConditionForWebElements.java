package utility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum WaitConditionForWebElements {

    allPresence(ExpectedConditions::presenceOfAllElementsLocatedBy);

    private final Function<By, ExpectedCondition<List<WebElement>>> type;

}