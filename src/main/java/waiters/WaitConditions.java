package waiters;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

import static java.util.Optional.ofNullable;

@Getter
@RequiredArgsConstructor
public enum WaitConditions {

    visible(ExpectedConditions::visibilityOfElementLocated),
    enabled(ExpectedConditions::elementToBeClickable),
    allPresence(ExpectedConditions::presenceOfAllElementsLocatedBy),
    allPresenceExtended(CustomExpectedCondition::moreThanOne),
    isNotEmpty(locator -> driver -> ofNullable(driver)
            .map(d -> d.findElements(locator))
            .filter(list -> !list.isEmpty())
            .orElse(null));

    private final Function<By, ExpectedCondition<?>> type;

}