import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @BeforeClass
    public void setUp() {
        System.out.println("ini dijalankan sekali setiap setup class");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("ini dijalankan setiap scenario dipanggil");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("ini dijalankan setelah semua scenario dijalankan pada level class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("ini adalah after method");

    }
}
