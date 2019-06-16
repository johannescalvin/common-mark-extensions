package tech.freecode.commonmark.ext.url.accessibility;

import java.io.File;

public class RelativePathValidator implements UrlAccessibilityValidator {
    private String filebase;
    private LocalFile localFile = new LinuxLocalFile();

    public RelativePathValidator(String filebase, LocalFile localFile) {
        this.filebase = filebase;
        this.localFile = localFile;
    }

    @Override
    public ValidationResult  validate(Url url) {
        ValidationResult result =  new ValidationResult();

        if (!UrlUtils.isRelativePath(url)){
            result.setDone(false);
            return result;
        }

        String filePath = localFile.getAbsolutePath(filebase,url.getDestination());
        if (filePath == null){
            result.setStatus(ValidationResult.Status.FAIL);
            result.setMsg("cann't convert to a valid file path");
            result.setDone(true);
            return result;
        }

        File file = new File(filePath);
        if (!file.exists()){
            // 文件不存在
            if(!UrlUtils.isExternalUrl(url)){
                result.setStatus(ValidationResult.Status.FAIL);
                result.setMsg("文件 " + filePath +" 不存在");
                result.setDone(true);
                return result;
            }else {
                result.setStatus(ValidationResult.Status.IGNORE);
                result.setDone(false);
                return result;
            }

        }else if (!file.canRead()){
            result.setStatus(ValidationResult.Status.FAIL);
            result.setMsg("文件 " + filePath +" 不可读");
            result.setDone(true);
            return result;
        }
        result.setStatus(ValidationResult.Status.OK);
        result.setMsg("OK");

        result.setDone(true);
        return result;
    }
}
