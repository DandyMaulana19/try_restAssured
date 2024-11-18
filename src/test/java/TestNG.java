import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {
    @Test
    public void Test1() {
        System.out.println("Ini Adalah Test 1");
        System.out.println("Thread 1" + Thread.currentThread().getId());
        System.out.println("Thread 1" + Thread.currentThread().getId());
        Assert.assertEquals(2, 2);
    }

    @Test
    public void Test2() {
        System.out.println("Thread 2" + Thread.currentThread().getId());
        System.out.println("Ini Adalah Test 2");
    }

    @Test
    public void Test3() {
        System.out.println("Thread 3" + Thread.currentThread().getId());
        System.out.println("Ini Adalah Test 3");
    }
}
