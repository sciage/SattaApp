package in.co.sattamaster.retrofit;

import retrofit2.Response;

@SuppressWarnings({"unchecked", "unused"})
public class ANError extends Exception {

        private String errorBody;

        private int errorCode = 0;

        private String errorDetail;

        private Response response;

        public ANError() {
        }

        public ANError(Response response) {
            this.response = response;
        }

        public ANError(String message) {
            super(message);
        }

        public ANError(String message, Response response) {
            super(message);
            this.response = response;
        }

        public ANError(String message, Throwable throwable) {
            super(message, throwable);
        }

        public ANError(String message, Response response, Throwable throwable) {
            super(message, throwable);
            this.response = response;
        }

        public ANError(Response response, Throwable throwable) {
            super(throwable);
            this.response = response;
        }

        public ANError(Throwable throwable) {
            super(throwable);
        }

        public Response getResponse() {
            return response;
        }

        public void setErrorDetail(String errorDetail) {
            this.errorDetail = errorDetail;
        }

        public String getErrorDetail() {
            return this.errorDetail;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public void setCancellationMessageInError() {
            this.errorDetail = "Request Cancelled";
        }

        public String getErrorBody() {
            return errorBody;
        }

        public void setErrorBody(String errorBody) {
            this.errorBody = errorBody;
        }

}
