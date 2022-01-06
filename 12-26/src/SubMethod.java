public class SubMethod extends Calculate{

    public SubMethod(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public int execute() {
        return a-b;
    }
}
