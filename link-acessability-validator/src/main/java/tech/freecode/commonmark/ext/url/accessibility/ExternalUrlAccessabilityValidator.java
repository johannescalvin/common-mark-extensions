package tech.freecode.commonmark.ext.url.accessibility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExternalUrlAccessabilityValidator implements UrlAccessibilityValidator {
    @Override
    public ValidationResult  validate(Url url) {
        ValidationResult result =  new ValidationResult();
        if (!UrlUtils.isExternalUrl(url)){
            result.setDone(false);
            return result;
        }

        try{
            url = UrlUtils.wellform(url);
            URL link = new URL(url.getDestination());
            HttpURLConnection conn = (HttpURLConnection) link.openConnection();
            int status = conn.getResponseCode();

            if (status == 200){
                result.setStatus(ValidationResult.Status.OK);
                result.setMsg("OK");
                result.setDone(true);
                return result;
            }else {
                result.setStatus(ValidationResult.Status.FAIL);
                result.setMsg(url.getDestination() + " can not be accessed.");
                result.setDone(true);
                return result;
            }

        }catch (MalformedURLException ex){
            result.setStatus(ValidationResult.Status.FAIL);
            result.setMsg(url.getDestination() + " is a bad-formed url.");
            result.setDone(true);
            return result;
        }catch (IOException ex){
            result.setStatus(ValidationResult.Status.FAIL);
            result.setMsg(url.getDestination() + " can not be accessed.");
            result.setDone(true);
            return result;
        }
    }
}
