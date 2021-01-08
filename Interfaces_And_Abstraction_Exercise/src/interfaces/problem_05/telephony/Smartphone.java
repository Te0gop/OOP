package interfaces.problem_05.telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        urls.forEach(url -> {
            boolean hasDigit = url.matches(".*\\d+.*");
            if(hasDigit) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }

            });
                                                                                                                                                                        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(number -> {
            try {
                Integer.parseInt(number);
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            } catch (Exception e) {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        });
        return sb.toString();
    }
}
