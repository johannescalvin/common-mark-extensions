package tech.freecode.commonmark.ext.url.accessibility;

public class AbosultePathAccessabilityValidator implements UrlAccessibilityValidator {

    // 不鼓励在markdown中使用基于本地文件系统的绝对路径
    @Override
    public ValidationResult validate(Url url) {
        ValidationResult result =  new ValidationResult();

        if (!UrlUtils.isAbsolutePath(url)){
            result.setDone(false);
            result.setStatus(ValidationResult.Status.IGNORE);
            return result;
        }

        result.setStatus(ValidationResult.Status.FAIL);
        result.setMsg("Abosulte file path is forbidden in markdown");
        result.setDone(true);
        return result;

    }
}
