package tech.freecode.commonmark.ext.url.accessibility;

public class EmailAccessabilityValidator implements UrlAccessibilityValidator {
    @Override
    public ValidationResult validate(Url url) {
        ValidationResult result =  new ValidationResult();

        if (!UrlUtils.isEmailLink(url)){
            result.setStatus(ValidationResult.Status.IGNORE);
            result.setDone(false);
            return result;

        }
        // 如果是邮件地址,验证方式比较麻烦,总不能真的发邮件吧
        // 弃坑 弃坑

        result.setStatus(ValidationResult.Status.IGNORE);
        result.setMsg("Email is merely ignored");
        result.setDone(true);
        return result;

    }
}
