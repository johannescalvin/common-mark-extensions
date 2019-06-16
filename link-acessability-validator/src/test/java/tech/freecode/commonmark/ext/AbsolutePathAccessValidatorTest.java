package tech.freecode.commonmark.ext;

import org.junit.Test;
import tech.freecode.commonmark.ext.url.accessibility.AbosultePathAccessabilityValidator;
import tech.freecode.commonmark.ext.url.accessibility.Url;
import tech.freecode.commonmark.ext.url.accessibility.UrlAccessibilityValidator;

import static org.junit.Assert.*;

public class AbsolutePathAccessValidatorTest {

    @Test
    public void testLinux(){
        String[] paths = new String[]{"~/absolutepath","/home/xxx/absolutepath"};
        for (String absolutepath : paths){
            UrlAccessibilityValidator.ValidationResult result = new AbosultePathAccessabilityValidator().validate(Url.of(absolutepath));
            assertTrue(result.isDone());
            assertEquals(UrlAccessibilityValidator.ValidationResult.Status.FAIL,result.getStatus());
        }
    }

    @Test
    public void testIgnore(){
        Url url = Url.of("https://www.baidu.com");
        UrlAccessibilityValidator.ValidationResult result = new AbosultePathAccessabilityValidator().validate(url);
        assertFalse(result.isDone());

    }
}
