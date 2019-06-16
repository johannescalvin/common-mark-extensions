package tech.freecode.commonmark.ext;

import org.junit.Test;
import tech.freecode.commonmark.ext.url.accessibility.LinuxLocalFile;
import tech.freecode.commonmark.ext.url.accessibility.RelativePathValidator;
import tech.freecode.commonmark.ext.url.accessibility.Url;
import tech.freecode.commonmark.ext.url.accessibility.UrlAccessibilityValidator;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class RelativePathAccessValidatorTest {
    @Test
    public void valid() throws IOException {
        File file = new File("/tmp/common-mark-test.tmp");
        file.createNewFile();
        RelativePathValidator validator = new RelativePathValidator("/tmp/xxxx",new LinuxLocalFile());
        UrlAccessibilityValidator.ValidationResult result =
                validator.validate(Url.of("../common-mark-test.tmp"));

        assertTrue(result.isDone());
        assertEquals(UrlAccessibilityValidator.ValidationResult.Status.OK,result.getStatus());

        // delete the file
        file.delete();
        result = validator.validate(Url.of("../common-mark-test.tmp"));
        assertTrue(result.isDone());
        assertEquals(UrlAccessibilityValidator.ValidationResult.Status.FAIL,result.getStatus());

    }
}
