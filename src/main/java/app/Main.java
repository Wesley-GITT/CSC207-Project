package app;

public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        appBuilder.addLoginView()
                .addSignupView()
                .build();
    }
}
