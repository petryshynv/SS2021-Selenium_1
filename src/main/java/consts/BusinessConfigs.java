package consts;

public class BusinessConfigs {

    public enum page {
        BASE_URL("https://training.by"),
        HOME_PAGE_URL("https://training.by/#/Home");

        private String url;

        page(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public enum userInputs {
        EMAIL("vitaliypetr84@gmail.com"),
        PASSWORD("Sambir_Test_12"),
        INCORRECT_PASSWORD("Sambir_Test_11");

        private String input;

        userInputs(String input) {
            this.input = input;
        }

        public String getInput() {
            return input;
        }
    }
}

