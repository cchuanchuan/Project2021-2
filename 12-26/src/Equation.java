public class Equation {

    private String express;
    private int result;

    public Equation(String express) {
        this.express = express;
        String strs[] = express.split(" ");
        if (strs.length == 3){
            String operator = strs[1];
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[2]);
            if (operator.trim().equals("+")){
                Calculate calculate = new AddMethod(a,b);
                result = calculate.execute();
            }else {
                Calculate calculate = new SubMethod(a,b);
                result = calculate.execute();
            }
        }
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
