import java.util.concurrent.CompletableFuture;

public class Test {

    public static void main(String[] args) {
        CompletableFuture future1 = CompletableFuture.runAsync(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("future1:"+i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        CompletableFuture future2 = CompletableFuture.runAsync(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("future2:"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture future = CompletableFuture.allOf(future1,future2);
//        CompletableFuture future3 = CompletableFuture.runAsync(()->{});
        CompletableFuture future4 = future.thenRun(()->{
            System.out.println("All END");
        });

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
