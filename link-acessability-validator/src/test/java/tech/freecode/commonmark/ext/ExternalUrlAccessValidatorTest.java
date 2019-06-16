package tech.freecode.commonmark.ext;

import org.junit.Test;
import tech.freecode.commonmark.ext.url.accessibility.Url;
import tech.freecode.commonmark.ext.url.accessibility.UrlAccessibilityValidator;
import tech.freecode.commonmark.ext.url.accessibility.ExternalUrlAccessabilityValidator;

import static org.junit.Assert.*;

public class ExternalUrlAccessValidatorTest {
    @Test
    public void valid(){
        UrlAccessibilityValidator.ValidationResult result =
                new ExternalUrlAccessabilityValidator()
                        .validate(Url.of("https://www.baidu.com"));

        assertTrue(result.isDone());
        assertEquals(UrlAccessibilityValidator.ValidationResult.Status.OK,result.getStatus());


    }

    @Test
    public void invalid(){
        UrlAccessibilityValidator.ValidationResult result =
                new ExternalUrlAccessabilityValidator()
                        .validate(Url.of("https://non-exist-url.com"));

        assertTrue(result.isDone());
        assertEquals(UrlAccessibilityValidator.ValidationResult.Status.FAIL,result.getStatus());
    }
}
