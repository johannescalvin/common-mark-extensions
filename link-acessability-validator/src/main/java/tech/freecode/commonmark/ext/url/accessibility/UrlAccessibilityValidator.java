package tech.freecode.commonmark.ext.url.accessibility;

public interface UrlAccessibilityValidator {
    class ValidationResult {
        public enum Status {
            OK,
            FAIL,
            IGNORE
        }

        Status status;
        String msg;
        boolean done;

        public Status getStatus() {
            return status;
        }

        public String getMsg() {
            return msg;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }



    ValidationResult validate(Url url);
}
