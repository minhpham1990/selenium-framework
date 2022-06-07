package testcase.login;

@FunctionalInterface
interface Hello {
    public String sayHello();
}

class LambdaExpression{
    public static void main(String[] args) {
        Hello s = () -> {return "test no param";};

        System.out.println(s.sayHello());
    }

}
