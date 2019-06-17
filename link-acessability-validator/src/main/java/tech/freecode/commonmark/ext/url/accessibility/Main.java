package tech.freecode.commonmark.ext.url.accessibility;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        List<RelativePathValidator.ValidationResult> results =
                UrlAccessibilityValidatorUtils.validate(new File(filename));
        for (UrlAccessibilityValidator.ValidationResult result : results){
            if (result.getStatus() == UrlAccessibilityValidator.ValidationResult.Status.FAIL){
                System.out.println(result.getMsg());
            }
        }
    }
}
