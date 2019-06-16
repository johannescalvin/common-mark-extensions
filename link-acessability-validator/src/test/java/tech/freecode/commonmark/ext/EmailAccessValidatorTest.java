package tech.freecode.commonmark.ext;

import static org.junit.Assert.*;
import org.junit.Test;
import tech.freecode.commonmark.ext.url.accessibility.EmailAccessabilityValidator;
import tech.freecode.commonmark.ext.url.accessibility.Url;
import tech.freecode.commonmark.ext.url.accessibility.UrlAccessibilityValidator;

public class EmailAccessValidatorTest {
    @Test
    public void test(){
        UrlAccessibilityValidator.ValidationResult result
                = new EmailAccessabilityValidator().validate(Url.of("mailto:yangchengzhu@163.com"));
        assertTrue(result.isDone());
        assertEquals(UrlAccessibilityValidator.ValidationResult.Status.IGNORE,result.getStatus());
    }

    @Test
    public void testIgnore(){
        UrlAccessibilityValidator.ValidationResult result
                = new EmailAccessabilityValidator().validate(Url.of("https://www.baidu.com"));
        assertFalse(result.isDone());
    }
}
