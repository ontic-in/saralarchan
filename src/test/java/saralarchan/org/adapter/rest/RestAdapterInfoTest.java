package saralarchan.org.adapter.rest;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import saralarchan.org.core.BaseRequestProcessor;
import com.jayway.jsonpath.DocumentContext;
import saralarchan.org.logger.LogManager;
import java.io.BufferedReader;
import org.apache.http.message.BasicHeader;
import static org.junit.jupiter.api.Assertions.*;
import java.net.URI;
import org.mockito.Mockito;
import java.util.HashMap;
import java.io.FileReader;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.net.URISyntaxException;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.io.File;
import com.jayway.jsonpath.JsonPath;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.net.http.HttpRequest;
import org.junit.jupiter.api.Disabled;

public class RestAdapterInfoTest {

@Test
    public void testDoGet() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext reqDc = mock(DocumentContext.class);
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.getUri(mappingFile, "", ctx)).thenReturn("http://test.com");
            mocked.when(() -> RestAdapterInfo.parseQS(mappingFile, ctx)).thenReturn("testQS");
            mocked.when(() -> RestAdapterInfo.parseHeaders(mappingFile, ctx)).thenReturn(new ArrayList<>());

            String result = RestAdapterInfo.doGet(mappingFile, ctx, reqDc);

            assertNull(result, "Result should be null as the actual service is not called");
        }
    }

    @Test
    public void testDoGetWithException() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext reqDc = mock(DocumentContext.class);
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.getUri(mappingFile, "", ctx)).thenThrow(new RuntimeException("Test Exception"));

            String result = RestAdapterInfo.doGet(mappingFile, ctx, reqDc);

            assertNull(result, "Result should be null as exception is thrown");
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testGetMethod() {
        String mappingFile = "mappingFile";
        HashMap<String, String> mappings = new HashMap<>();
        mappings.put("@METHOD", "GET");

        RestAdapterInfo restAdapterInfo = Mockito.spy(new RestAdapterInfo());
        when(restAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

        String method = restAdapterInfo.getMethod(mappingFile);
        assertEquals("GET", method, "Method should be GET");
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testGetMethodWhenMethodIsPost() {
        String mappingFile = "mappingFile";
        HashMap<String, String> mappings = new HashMap<>();
        mappings.put("@METHOD", "POST");

        RestAdapterInfo restAdapterInfo = Mockito.spy(new RestAdapterInfo());
        when(restAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

        String method = restAdapterInfo.getMethod(mappingFile);
        assertEquals("POST", method, "Method should be POST");
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testGetMethodWhenMethodIsNotDefined() {
        String mappingFile = "mappingFile";
        HashMap<String, String> mappings = new HashMap<>();

        RestAdapterInfo restAdapterInfo = Mockito.spy(new RestAdapterInfo());
        when(restAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

        String method = restAdapterInfo.getMethod(mappingFile);
        assertEquals(null, method, "Method should be null");
    }

@Test
    public void testLoadTransformer() throws IOException {
        String mappingFile = "testMappingFile";
        HashMap<String, String> expectedMappings = new HashMap<>();
        expectedMappings.put("testKey", "testValue");

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(expectedMappings);

            HashMap<String, String> actualMappings = RestAdapterInfo.loadTransformer(mappingFile);

            assertNotNull(actualMappings);
            assertEquals(expectedMappings, actualMappings);
        }
    }

    @Test
    public void testLoadTransformerWhenFileNotFound() throws IOException {
        String mappingFile = "testMappingFile";

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenThrow(new RuntimeException());

            assertThrows(RuntimeException.class, () -> RestAdapterInfo.loadTransformer(mappingFile));
        }
    }

// @Test
    // public void testTransform() {
    // String mappingFile = "mappingFile";
    // HashMap<String, String> ctx = new HashMap<>();
    // DocumentContext req = JsonPath.parse("{}");

    // HashMap<String, Object> mappings = new HashMap<>();
    // mappings.put("@BODYTML", "bodyTemplate");
    // ArrayList<String> lines = new ArrayList<>();
    // lines.add("line1");
    // lines.add("line2");
    // mappings.put("@TRANSFORM", lines);

    // DocumentContext dc = JsonPath.parse("{}");

    // try (MockedStatic<RestAdapterInfo> restAdapterInfoMock =
    // Mockito.mockStatic(RestAdapterInfo.class)) {
    // restAdapterInfoMock.when(() ->
    // RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
    // restAdapterInfoMock.when(() ->
    // RestAdapterInfo.getBodyTmpl("bodyTemplate")).thenReturn(dc);

    // BaseRequestProcessor rp = mock(BaseRequestProcessor.class);
    // when(rp.process(lines, ctx, dc, req, "-1")).thenReturn(dc);

    // String result = RestAdapterInfo.transform(mappingFile, ctx, req);

    // assertEquals(dc.jsonString(), result);
    // }
    // }

@Disabled("Automatically disabled by AI")
@Test
    public void testGetUri() {
        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "https://test.com");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("resource1");
        resourceList.add("$VAR.var1");
        mappings.put("@URIPATH", resourceList);

        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("var1", "resource2");

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer(anyString())).thenReturn(mappings);
            mocked.when(() -> LogManager.logInfo(anyString())).thenAnswer(invocation -> null);

            String result = RestAdapterInfo.getUri("mappingFile", "", ctx);
            assertEquals("https://test.com/resource1/resource2", result);
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testGetUriWithQueryString() {
        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "https://test.com");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("resource1");
        resourceList.add("$VAR.var1");
        mappings.put("@URIPATH", resourceList);

        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("var1", "resource2");

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer(anyString())).thenReturn(mappings);
            mocked.when(() -> LogManager.logInfo(anyString())).thenAnswer(invocation -> null);

            String result = RestAdapterInfo.getUri("mappingFile", "param=value", ctx);
            assertEquals("https://test.com/resource1/resource2?param=value", result);
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testParseQS() {
        HashMap<String, String> context = new HashMap<>();
        context.put("key1", "value1");
        context.put("key2", "value2");

        HashMap<String, String> qsMap = new HashMap<>();
        qsMap.put("key1", "$VAR.key1");
        qsMap.put("key2", "$VAR.key2");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@QSPARAM", qsMap);

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer(any(String.class))).thenReturn(mappings);
            mocked.when(() -> RestAdapterInfo.parseQS(any(String.class), any(HashMap.class))).thenCallRealMethod();

            String result = RestAdapterInfo.parseQS("mappingFile", context);

            assertEquals("key1=value1&key2=value2", result);
        }
    }

    @Test
    public void testParseQSWhenNoQsParam() {
        HashMap<String, String> context = new HashMap<>();
        context.put("key1", "value1");
        context.put("key2", "value2");

        HashMap<String, Object> mappings = new HashMap<>();

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer(any(String.class))).thenReturn(mappings);
            mocked.when(() -> RestAdapterInfo.parseQS(any(String.class), any(HashMap.class))).thenCallRealMethod();

            String result = RestAdapterInfo.parseQS("mappingFile", context);

            assertEquals("", result);
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testSendPOST() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext req = Mockito.mock(DocumentContext.class);
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.sendPOST(mappingFile, ctx, req)).thenCallRealMethod();
            mocked.when(() -> RestAdapterInfo.getUri(mappingFile, "", ctx)).thenReturn("http://test.com");
            mocked.when(() -> RestAdapterInfo.parseHeaders(mappingFile, ctx)).thenReturn(new ArrayList<BasicHeader>());
            mocked.when(() -> RestAdapterInfo.transform(mappingFile, ctx, req)).thenReturn("body");

            String result = RestAdapterInfo.sendPOST(mappingFile, ctx, req);

            assertEquals("response", result);
            mocked.verify(() -> RestAdapterInfo.getUri(mappingFile, "", ctx), times(1));
            mocked.verify(() -> RestAdapterInfo.parseHeaders(mappingFile, ctx), times(1));
            mocked.verify(() -> RestAdapterInfo.transform(mappingFile, ctx, req), times(1));
        }
    }

    @Test
    public void testSendPOSTWithException() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext req = Mockito.mock(DocumentContext.class);
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.sendPOST(mappingFile, ctx, req)).thenThrow(new RuntimeException("Test exception"));

            RuntimeException exception = assertThrows(RuntimeException.class, () -> RestAdapterInfo.sendPOST(mappingFile, ctx, req));
            assertEquals("Test exception", exception.getMessage());
            mocked.verify(() -> RestAdapterInfo.getUri(mappingFile, "", ctx), never());
            mocked.verify(() -> RestAdapterInfo.parseHeaders(mappingFile, ctx), never());
            mocked.verify(() -> RestAdapterInfo.transform(mappingFile, ctx, req), never());
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testSetUri() {
        HashMap<String, String> context = new HashMap<>();
        context.put("var1", "value1");

        HttpRequest.Builder builder = HttpRequest.newBuilder();

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@URIDOMAIN", "https://domain/");
            mappings.put("@URIPATH", new ArrayList<>(Arrays.asList("part1", "$VAR.var1", "part2")));

            mocked.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(mappings);

            HttpRequest.Builder resultBuilder = RestAdapterInfo.setUri("mappingFile", builder, "key=value", context);

            assertNotNull(resultBuilder, "Builder should not be null");
            assertEquals("https://domain/part1/value1/part2?key=value", resultBuilder.build().uri().toString());
        }
    }

    @Test
    public void testSetUri_URISyntaxException() {
        HashMap<String, String> context = new HashMap<>();
        context.put("var1", "value1");

        HttpRequest.Builder builder = HttpRequest.newBuilder();

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@URIDOMAIN", "https://domain/");
            mappings.put("@URIPATH", new ArrayList<>(Arrays.asList("part1", "$VAR.var1", "part2")));

            mocked.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(mappings);

            HttpRequest.Builder resultBuilder = RestAdapterInfo.setUri("mappingFile", builder, "invalidQueryString", context);

            assertNull(resultBuilder, "Builder should be null due to URISyntaxException");
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testParseHeaders() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("Content-Type", "application/json");
        ctx.put("authToken", "tokenforauthorizationinsamlformat");

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "$VAR.Content-Type");
        headerMap.put("authToken", "$VAR.authToken");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@HEADER", headerMap);

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(mappings);

            ArrayList<BasicHeader> result = RestAdapterInfo.parseHeaders("mappingFile", ctx);

            assertEquals(2, result.size());
            assertEquals("Content-Type", result.get(0).getName());
            assertEquals("application/json", result.get(0).getValue());
            assertEquals("authToken", result.get(1).getName());
            assertEquals("tokenforauthorizationinsamlformat", result.get(1).getValue());
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testParseHeadersWithNoVariable() {
        HashMap<String, String> ctx = new HashMap<>();

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("authToken", "tokenforauthorizationinsamlformat");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@HEADER", headerMap);

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(mappings);

            ArrayList<BasicHeader> result = RestAdapterInfo.parseHeaders("mappingFile", ctx);

            assertEquals(2, result.size());
            assertEquals("Content-Type", result.get(0).getName());
            assertEquals("application/json", result.get(0).getValue());
            assertEquals("authToken", result.get(1).getName());
            assertEquals("tokenforauthorizationinsamlformat", result.get(1).getValue());
        }
    }

}