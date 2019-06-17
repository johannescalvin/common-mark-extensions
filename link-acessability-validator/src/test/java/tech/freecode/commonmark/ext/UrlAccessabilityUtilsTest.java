package tech.freecode.commonmark.ext;

import org.junit.Test;
import tech.freecode.commonmark.ext.url.accessibility.UrlAccessibilityValidator;
import tech.freecode.commonmark.ext.url.accessibility.UrlAccessibilityValidatorUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class UrlAccessabilityUtilsTest {
    @Test
    public void test() throws IOException {
        File file = new File("/tmp/markdown.md");
        file.createNewFile();
        String markdown = "# Markdown\n" +
                "\n" +
                "[本地文件](../localfile.tmp);\n";
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(markdown);
        fileWriter.close();

        File localFile = new File("/tmp/localfile.tmp");
        localFile.createNewFile();

        List<UrlAccessibilityValidator.ValidationResult> results =
                UrlAccessibilityValidatorUtils.validate(file);

        assertEquals(1,results.size());
        assertEquals(UrlAccessibilityValidator.ValidationResult.Status.OK,results.get(0).getStatus());


        file.delete();
        localFile.delete();
    }
}
