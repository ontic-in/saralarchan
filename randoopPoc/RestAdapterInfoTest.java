package saralarchan.org.adapter.rest;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class RestAdapterInfoTest {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test01");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        com.jayway.jsonpath.DocumentContext documentContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("", hashMap1,
                    documentContext2);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test02");
        com.jayway.jsonpath.DocumentContext documentContext1 = saralarchan.org.adapter.rest.RestAdapterInfo
                .getBodyTmpl("hi!");
        assertNull(documentContext1);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test03");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        com.jayway.jsonpath.DocumentContext documentContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.doGet("hi!", hashMap1,
                    documentContext2);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test04");
        java.lang.String str1 = saralarchan.org.adapter.rest.RestAdapterInfo.getMethod("hi!");
        assertNull(str1);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test05");
        java.util.HashMap hashMap0 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        java.lang.Class<?> wildcardClass1 = hashMap0.getClass();
        assertNotNull(hashMap0);
        assertNotNull(wildcardClass1);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test06");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        com.jayway.jsonpath.DocumentContext documentContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.doGet("", hashMap1, documentContext3);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Disabled
    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test07");
        java.lang.String str0 = saralarchan.org.adapter.AdapterInfo.adapterName;
        assertEquals("'" + str0 + "' != '" + "" + "'", str0, "");
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test08");
        java.lang.String str1 = saralarchan.org.adapter.rest.RestAdapterInfo.getMethod("");
        assertNull(str1);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test09");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        com.jayway.jsonpath.DocumentContext documentContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("hi!", hashMap1,
                    documentContext2);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Disabled
    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test10");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.parseQS("hi!", hashMap2);
        com.jayway.jsonpath.DocumentContext documentContext4 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap2,
                    documentContext4);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
        assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test11");
        com.jayway.jsonpath.DocumentContext documentContext1 = saralarchan.org.adapter.rest.RestAdapterInfo
                .getBodyTmpl("");
        assertNull(documentContext1);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test12");
        saralarchan.org.adapter.AdapterInfo.adapterName = "";
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test13");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap1;
        com.jayway.jsonpath.DocumentContext documentContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("hi!", hashMap1,
                    documentContext3);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test14");
        java.util.HashMap hashMap2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.getUri("", "", hashMap2);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test15");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache;
        com.jayway.jsonpath.DocumentContext documentContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("hi!", hashMap1,
                    documentContext2);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test16");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap2;
        restAdapterInfo1.options = hashMap2;
        com.jayway.jsonpath.DocumentContext documentContext5 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap2,
                    documentContext5);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test17");
        java.util.HashMap hashMap0 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap0;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap0;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap0;
        assertNotNull(hashMap0);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test18");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        com.jayway.jsonpath.DocumentContext documentContext6 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str7 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("", hashMap5,
                    documentContext6);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test19");
        java.net.http.HttpRequest.Builder builder1 = null;
        java.util.HashMap hashMap3 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        // The following exception was thrown during execution in test generation
        try {
            java.net.http.HttpRequest.Builder builder4 = saralarchan.org.adapter.rest.RestAdapterInfo.setUri("",
                    builder1, "", hashMap3);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap3);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test20");
        saralarchan.org.adapter.AdapterInfo.adapterName = "hi!";
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test21");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        java.lang.Class<?> wildcardClass8 = hashMap5.getClass();
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertNotNull(wildcardClass8);
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test22");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap1;
        restAdapterInfo0.options = hashMap1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo8 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int9 = restAdapterInfo8.type;
        restAdapterInfo8.type = (short) -1;
        java.util.HashMap hashMap12 = restAdapterInfo8.options;
        restAdapterInfo0.options = hashMap12;
        assertNotNull(hashMap1);
        assertNotNull(hashMap5);
        assertTrue(int9 == 0, "'" + int9 + "' != '" + 0 + "'");
        assertNotNull(hashMap12);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test23");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        com.jayway.jsonpath.DocumentContext documentContext7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("hi!", hashMap5,
                    documentContext7);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test24");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        com.jayway.jsonpath.DocumentContext documentContext7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = saralarchan.org.adapter.rest.RestAdapterInfo.doGet("", hashMap5, documentContext7);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test25");
        java.net.http.HttpRequest.Builder builder1 = null;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo3 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int4 = restAdapterInfo3.type;
        restAdapterInfo3.type = (short) -1;
        java.util.HashMap hashMap8 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap8;
        restAdapterInfo3.options = hashMap8;
        // The following exception was thrown during execution in test generation
        try {
            java.net.http.HttpRequest.Builder builder11 = saralarchan.org.adapter.rest.RestAdapterInfo.setUri("",
                    builder1, "hi!", hashMap8);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int4 == 0, "'" + int4 + "' != '" + 0 + "'");
        assertNotNull(hashMap8);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test26");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo8 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int9 = restAdapterInfo8.type;
        restAdapterInfo8.type = (short) -1;
        java.util.HashMap hashMap13 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap13;
        restAdapterInfo8.options = hashMap13;
        restAdapterInfo0.options = hashMap13;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertTrue(int9 == 0, "'" + int9 + "' != '" + 0 + "'");
        assertNotNull(hashMap13);
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test27");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        com.jayway.jsonpath.DocumentContext documentContext7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("hi!", hashMap5,
                    documentContext7);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test28");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("");
        com.jayway.jsonpath.DocumentContext documentContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap2,
                    documentContext3);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test29");
        java.net.http.HttpRequest.Builder builder1 = null;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo3 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        java.util.HashMap hashMap4 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap4;
        restAdapterInfo3.options = hashMap4;
        // The following exception was thrown during execution in test generation
        try {
            java.net.http.HttpRequest.Builder builder7 = saralarchan.org.adapter.rest.RestAdapterInfo.setUri("",
                    builder1, "hi!", hashMap4);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap4);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test30");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        com.jayway.jsonpath.DocumentContext documentContext6 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str7 = saralarchan.org.adapter.rest.RestAdapterInfo.doGet("hi!", hashMap5,
                    documentContext6);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test31");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo2 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int3 = restAdapterInfo2.type;
        restAdapterInfo2.type = (short) -1;
        java.util.HashMap hashMap6 = restAdapterInfo2.options;
        restAdapterInfo0.options = hashMap6;
        java.lang.Class<?> wildcardClass8 = restAdapterInfo0.getClass();
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertTrue(int3 == 0, "'" + int3 + "' != '" + 0 + "'");
        assertNotNull(hashMap6);
        assertNotNull(wildcardClass8);
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test32");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        com.jayway.jsonpath.DocumentContext documentContext6 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str7 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap5,
                    documentContext6);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test33");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache;
        com.jayway.jsonpath.DocumentContext documentContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("", hashMap1,
                    documentContext2);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test34");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        com.jayway.jsonpath.DocumentContext documentContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("hi!", hashMap1,
                    documentContext3);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test35");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap6 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap6;
        restAdapterInfo1.options = hashMap6;
        java.util.HashMap hashMap9 = restAdapterInfo1.options;
        com.jayway.jsonpath.DocumentContext documentContext10 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap9,
                    documentContext10);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap6);
        assertNotNull(hashMap9);
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test36");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap2;
        com.jayway.jsonpath.DocumentContext documentContext4 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("hi!", hashMap2,
                    documentContext4);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test37");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap5 = restAdapterInfo1.options;
        java.util.HashMap hashMap6 = restAdapterInfo1.options;
        com.jayway.jsonpath.DocumentContext documentContext7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("", hashMap6,
                    documentContext7);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertNotNull(hashMap6);
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test38");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap6 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap6;
        restAdapterInfo1.options = hashMap6;
        java.util.HashMap hashMap9 = restAdapterInfo1.options;
        com.jayway.jsonpath.DocumentContext documentContext10 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("hi!", hashMap9,
                    documentContext10);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap6);
        assertNotNull(hashMap9);
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test39");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap1;
        restAdapterInfo0.options = hashMap1;
        int int4 = restAdapterInfo0.type;
        java.util.HashMap hashMap5 = restAdapterInfo0.options;
        assertNotNull(hashMap1);
        assertTrue(int4 == 0, "'" + int4 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test40");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        java.util.HashMap hashMap8 = restAdapterInfo0.options;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap8;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertNotNull(hashMap8);
    }

    @Test
    public void test41() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test41");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        java.util.HashMap hashMap2 = restAdapterInfo0.options;
        java.lang.Class<?> wildcardClass3 = hashMap2.getClass();
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap2);
        assertNotNull(wildcardClass3);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test42");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        com.jayway.jsonpath.DocumentContext documentContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap2,
                    documentContext3);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
    }

    @Test
    public void test43() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test43");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        java.util.HashMap hashMap8 = restAdapterInfo0.options;
        restAdapterInfo0.type = (byte) 1;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertNotNull(hashMap8);
    }

    @Test
    public void test44() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test44");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        restAdapterInfo0.type = (byte) -1;
        int int3 = restAdapterInfo0.type;
        assertTrue(int3 == (-1), "'" + int3 + "' != '" + (-1) + "'");
    }

    @Test
    public void test45() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test45");
        java.net.http.HttpRequest.Builder builder1 = null;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo3 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int4 = restAdapterInfo3.type;
        restAdapterInfo3.type = (short) -1;
        java.util.HashMap hashMap7 = restAdapterInfo3.options;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap7;
        // The following exception was thrown during execution in test generation
        try {
            java.net.http.HttpRequest.Builder builder9 = saralarchan.org.adapter.rest.RestAdapterInfo.setUri("",
                    builder1, "", hashMap7);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertTrue(int4 == 0, "'" + int4 + "' != '" + 0 + "'");
        assertNotNull(hashMap7);
    }

    @Test
    public void test46() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test46");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        restAdapterInfo0.type = (byte) -1;
        java.lang.Class<?> wildcardClass3 = restAdapterInfo0.getClass();
        assertNotNull(wildcardClass3);
    }

    @Test
    public void test47() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test47");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("");
        com.jayway.jsonpath.DocumentContext documentContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("hi!", hashMap2,
                    documentContext3);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
    }

    @Disabled
    @Test
    public void test48() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test48");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.parseQS("hi!", hashMap2);
        com.jayway.jsonpath.DocumentContext documentContext4 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("hi!", hashMap2,
                    documentContext4);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
        assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test49() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test49");
        java.net.http.HttpRequest.Builder builder1 = null;
        java.util.HashMap hashMap4 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap4;
        // The following exception was thrown during execution in test generation
        try {
            java.net.http.HttpRequest.Builder builder6 = saralarchan.org.adapter.rest.RestAdapterInfo.setUri("hi!",
                    builder1, "", hashMap4);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap4);
    }

    @Test
    public void test50() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test50");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap4 = restAdapterInfo0.options;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap4;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap4);
    }

    @Disabled
    @Test
    public void test51() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test51");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        java.lang.String str4 = saralarchan.org.adapter.rest.RestAdapterInfo.parseQS("", hashMap1);
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        assertNotNull(hashMap1);
        assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test52() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test52");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache = hashMap1;
        restAdapterInfo0.options = hashMap1;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        assertNotNull(hashMap1);
    }

    @Test
    public void test53() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test53");
        java.util.HashMap hashMap2 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap2;
        com.jayway.jsonpath.DocumentContext documentContext4 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = saralarchan.org.adapter.rest.RestAdapterInfo.sendPOST("", hashMap2,
                    documentContext4);
            fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.ArrayList.size()\" because \"resourceList\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap2);
    }

    @Test
    public void test54() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test54");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        java.util.HashMap hashMap1 = restAdapterInfo0.options;
        assertNotNull(hashMap1);
    }

    @Test
    public void test55() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test55");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo8 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int9 = restAdapterInfo8.type;
        restAdapterInfo8.type = (short) -1;
        java.util.HashMap hashMap12 = restAdapterInfo8.options;
        java.util.HashMap hashMap13 = restAdapterInfo8.options;
        restAdapterInfo0.options = hashMap13;
        restAdapterInfo0.type = 1;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertTrue(int9 == 0, "'" + int9 + "' != '" + 0 + "'");
        assertNotNull(hashMap12);
        assertNotNull(hashMap13);
    }

    @Test
    public void test56() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test56");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        java.util.HashMap hashMap5 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap5;
        restAdapterInfo0.options = hashMap5;
        java.util.HashMap hashMap8 = restAdapterInfo0.options;
        java.util.HashMap hashMap9 = restAdapterInfo0.options;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertNotNull(hashMap5);
        assertNotNull(hashMap8);
        assertNotNull(hashMap9);
    }

    @Disabled
    @Test
    public void test57() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test57");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo1 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int2 = restAdapterInfo1.type;
        restAdapterInfo1.type = (short) -1;
        java.util.HashMap hashMap6 = saralarchan.org.adapter.rest.RestAdapterInfo.loadTransformer("hi!");
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap6;
        restAdapterInfo1.options = hashMap6;
        java.util.HashMap hashMap9 = restAdapterInfo1.options;
        java.lang.String str10 = saralarchan.org.adapter.rest.RestAdapterInfo.parseQS("hi!", hashMap9);
        assertTrue(int2 == 0, "'" + int2 + "' != '" + 0 + "'");
        assertNotNull(hashMap6);
        assertNotNull(hashMap9);
        assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
    }

    @Disabled
    @Test
    public void test58() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test58");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache;
        saralarchan.org.adapter.rest.RestAdapterInfo.bodyTmplCache = hashMap1;
        java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.parseQS("hi!", hashMap1);
        assertNotNull(hashMap1);
        assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test59() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test59");
        saralarchan.org.adapter.rest.RestAdapterInfo restAdapterInfo0 = new saralarchan.org.adapter.rest.RestAdapterInfo();
        int int1 = restAdapterInfo0.type;
        restAdapterInfo0.type = (short) -1;
        int int4 = restAdapterInfo0.type;
        assertTrue(int1 == 0, "'" + int1 + "' != '" + 0 + "'");
        assertTrue(int4 == (-1), "'" + int4 + "' != '" + (-1) + "'");
    }

    @Test
    public void test60() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RestAdapterInfoTest0.test60");
        java.util.HashMap hashMap1 = saralarchan.org.adapter.rest.RestAdapterInfo.transformerCache;
        com.jayway.jsonpath.DocumentContext documentContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = saralarchan.org.adapter.rest.RestAdapterInfo.transform("", hashMap1,
                    documentContext2);
            fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        assertNotNull(hashMap1);
    }
}
