package saralarchan.org.adapter.rest;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class HttpsClientTest {

    public static boolean debug = false;

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test1");
        saralarchan.org.adapter.rest.HttpsClient httpsClient0 = new saralarchan.org.adapter.rest.HttpsClient();
        java.lang.Class<?> wildcardClass1 = httpsClient0.getClass();
        assertNotNull(wildcardClass1);
    }

    @Test
    public void test2() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test2");
        saralarchan.org.adapter.rest.HttpsClient httpsClient0 = new saralarchan.org.adapter.rest.HttpsClient();
        java.lang.String str3 = httpsClient0.CallServer("hi!", "hi!");
        java.lang.Class<?> wildcardClass4 = httpsClient0.getClass();
        assertNull(str3);
        assertNotNull(wildcardClass4);
    }

    @Test
    public void test3() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test3");
        saralarchan.org.adapter.rest.HttpsClient httpsClient0 = new saralarchan.org.adapter.rest.HttpsClient();
        java.lang.String str3 = httpsClient0.CallServer("", "");
        java.lang.String str6 = httpsClient0.CallServer("", "");
        java.lang.String str9 = httpsClient0.CallServer("", "hi!");
        assertNull(str3);
        assertNull(str6);
        assertNull(str9);
    }

    @Test
    public void test4() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test4");
        saralarchan.org.adapter.rest.HttpsClient httpsClient0 = new saralarchan.org.adapter.rest.HttpsClient();
        java.lang.String str3 = httpsClient0.CallServer("", "");
        java.lang.String str6 = httpsClient0.CallServer("", "");
        java.lang.Class<?> wildcardClass7 = httpsClient0.getClass();
        assertNull(str3);
        assertNull(str6);
        assertNotNull(wildcardClass7);
    }

    @Test
    public void test5() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test5");
        saralarchan.org.adapter.rest.HttpsClient httpsClient0 = new saralarchan.org.adapter.rest.HttpsClient();
        java.lang.String str3 = httpsClient0.CallServer("", "");
        java.lang.String str6 = httpsClient0.CallServer("", "");
        java.lang.String str9 = httpsClient0.CallServer("", "");
        java.lang.Class<?> wildcardClass10 = httpsClient0.getClass();
        assertNull(str3);
        assertNull(str6);
        assertNull(str9);
        assertNotNull(wildcardClass10);
    }
}

