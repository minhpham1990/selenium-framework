package testcase.login;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class testCsv {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/data/login01.csv")
    public void test(String name, String pass){
        System.out.println("Username: "+name);
        System.out.println("Password: "+pass);
    }
}
