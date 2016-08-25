package test;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by hxl on 2016/7/29.
 */
@RunWith(OrderRunner.class)
public class TestOrder {

    @Test
    @Order(2)
    public void test1() {
        System.out.println(2);
    }

    @Test
    @Order(1)
    public void test2() {
        System.out.println(1);
    }

}
