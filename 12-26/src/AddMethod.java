public class AddMethod extends Calculate{

    public AddMethod(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int execute() {
        return a+b;
    }
}
