public class Test {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
//            System.out.println("Thread");
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("Thread END");
        });
        thread.setDaemon(true);
        thread.start();

        System.out.println("END");
//        .raed();
    }
}
