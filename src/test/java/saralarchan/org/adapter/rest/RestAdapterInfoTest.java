package saralarchan.org.adapter.rest;

import java.io.FileReader;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import com.jayway.jsonpath.DocumentContext;
import saralarchan.org.logger.LogManager;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.BufferedReader;
import saralarchan.org.core.BaseRequestProcessor;
import static org.mockito.Mockito.when;
import java.net.URI;
import org.mockito.MockedStatic;
import java.io.FileNotFoundException;
import static org.mockito.Mockito.*;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.http.message.BasicHeader;
import java.net.http.HttpRequest;
import static org.mockito.Mockito.mockStatic;
import org.mockito.Mockito;
import org.junit.jupiter.api.Disabled;

public class RestAdapterInfoTest {

@Disabled("Automatically disabled by AI")
@Test
    public void test_sendPOST_with_invalid_mappingFile() {
        String mappingFile = "invalid_mapping_file";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.getUri(anyString(), anyString(), any(HashMap.class))).thenReturn("http://invalid.url");
            ArrayList<BasicHeader> headers = new ArrayList<>();
            headers.add(new BasicHeader("Content-Type", "application/json"));
            mockedStatic.when(() -> RestAdapterInfo.parseHeaders(anyString(), any(HashMap.class))).thenReturn(headers);
            mockedStatic.when(() -> RestAdapterInfo.transform(anyString(), any(HashMap.class), any())).thenReturn(null);

            BasicHeader[] headersArray = new BasicHeader[headers.size()];
            headers.toArray(headersArray);

            String result = RestAdapterInfo.sendPOST(mappingFile, ctx, null);

            assertEquals("", result, "The result should be an empty string as the mapping file is invalid.");
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void test_getUri_with_valid_mappingFile_and_invalid_queryString_and_valid_context() {
        String mappingFile = "validMappingFile";
        String queryString = "";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "https://domain/");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("$VAR.key1");
        resourceList.add("part2");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

            String expectedUri = "https://domain/value1/part2";
            String actualUri = RestAdapterInfo.getUri(mappingFile, queryString, ctx);

            assertEquals(expectedUri, actualUri, "The actual URI does not match the expected URI");
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void test_getUri_with_valid_mappingFile_and_invalid_queryString_and_valid_context_with_no_variable_in_path() {
        String mappingFile = "validMappingFile";
        String queryString = "";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "https://domain/");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("part1");
        resourceList.add("part2");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

            String expectedUri = "https://domain/part1/part2";
            String actualUri = RestAdapterInfo.getUri(mappingFile, queryString, ctx);

            assertEquals(expectedUri, actualUri, "The actual URI does not match the expected URI");
        }
    }

@Test
    public void testParseHeaders_withContextHavingVariableHeaders() {
        HashMap<String, String> context = new HashMap<>();
        context.put("Content-Type", "application/json");
        context.put("authToken", "tokenforauthorizationinsamlformat");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(new HashMap() {{
                put("@HEADER", context);
            }});

            ArrayList<BasicHeader> headers = RestAdapterInfo.parseHeaders("mappingFile", context);

            assertEquals(2, headers.size());
            // As HashMap does not guarantee order, we need to check for both headers without assuming their order
            if ("Content-Type".equals(headers.get(0).getName())) {
                assertEquals("Content-Type", headers.get(0).getName());
                assertEquals("application/json", headers.get(0).getValue());
                assertEquals("authToken", headers.get(1).getName());
                assertEquals("tokenforauthorizationinsamlformat", headers.get(1).getValue());
            } else {
                assertEquals("authToken", headers.get(0).getName());
                assertEquals("tokenforauthorizationinsamlformat", headers.get(0).getValue());
                assertEquals("Content-Type", headers.get(1).getName());
                assertEquals("application/json", headers.get(1).getValue());
            }
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void test_loadTransformer_with_mappingfile_having_invalid_format() {
        String mappingFile = "invalid_format.txt";

        try (MockedStatic<LogManager> mockedLogManager = mockStatic(LogManager.class)) {
            mockedLogManager.when(() -> LogManager.logInfo(anyString())).thenAnswer(i -> null);
            mockedLogManager.when(() -> LogManager.logError(anyString(), any(Exception.class))).thenAnswer(i -> null);

            try (MockedStatic<FileReader> mockedFileReader = mockStatic(FileReader.class, Mockito.CALLS_REAL_METHODS)) {
                FileReader fileReader = mock(FileReader.class);
                BufferedReader bufferedReader = mock(BufferedReader.class);
                when(bufferedReader.readLine()).thenReturn("@INVALID=FORMAT", null);
                when(fileReader.read(any(char[].class), anyInt(), anyInt())).thenThrow(new IOException());
                mockedFileReader.when(() -> new FileReader(any(File.class))).thenReturn(fileReader);

                HashMap result = RestAdapterInfo.loadTransformer(mappingFile);
                assertEquals(0, result.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

@Test
    public void test_getBodyTmpl_with_bodyTemplate_already_in_cache() {
        String bodyTemplate = "testBodyTemplate";
        DocumentContext mockDocumentContext = mock(DocumentContext.class);

        // Mocking the static method and the HashMap
        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            RestAdapterInfo.bodyTmplCache.put(bodyTemplate, mockDocumentContext);

            DocumentContext result = RestAdapterInfo.getBodyTmpl(bodyTemplate);

            assertEquals(mockDocumentContext, result, "The method should return the cached DocumentContext object");
            verifyNoInteractions(mockDocumentContext); // No interactions with the DocumentContext object as it was already in cache
        }

        // Clearing the HashMap after the test
        RestAdapterInfo.bodyTmplCache.clear();
    }

@Test
    public void testParseHeaders_withEmptyContext() {
        HashMap<String, String> context = new HashMap<>();

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            HashMap<String, Object> mockTransformer = new HashMap<>();
            mockTransformer.put("@HEADER", new HashMap<>());
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(mockTransformer);

            ArrayList<BasicHeader> result = RestAdapterInfo.parseHeaders("mappingFile", context);

            assertEquals(new ArrayList<>(), result, "The returned list of headers should be empty as the context is empty");
        }
    }

@Test
    public void test_loadTransformer_with_valid_mappingfile() {
        String mappingFile = "validMappingFile";

        try (MockedStatic<LogManager> mockedStatic = mockStatic(LogManager.class)) {
            mockedStatic.when(() -> LogManager.logInfo(Mockito.anyString())).thenAnswer(invocation -> {
                System.out.println(invocation.getArgument(0).toString());
                return null;
            });

            HashMap result = RestAdapterInfo.loadTransformer(mappingFile);

            assertNotNull(result, "The result should not be null");
            assertTrue(result instanceof HashMap, "The result should be an instance of HashMap");
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testTransformWithInvalidMappingFile() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");

        String mappingFile = "invalidMappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@BODYTML", "template");
            mappings.put("@TRANSFORM", new ArrayList<>());

            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getBodyTmpl("template")).thenReturn(null);

            String result = RestAdapterInfo.transform(mappingFile, ctx, null);

            assertEquals(null, result, "The transform method did not return the expected result");
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testTransformWithValidMappingFile() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");

        String mappingFile = "validMappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@BODYTML", "template");
            mappings.put("@TRANSFORM", new ArrayList<>());

            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getBodyTmpl("template")).thenReturn(null);

            String result = RestAdapterInfo.transform(mappingFile, ctx, null);

            assertEquals(null, result, "The transform method did not return the expected result");
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testSetUri_withValidMappingFileAndNullBuilderAndQueryStringAndContext() {
        String mappingFile = "validMappingFile";
        String queryString = "queryString";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key", "value");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "http://test.com");
        ArrayList<String> uriPath = new ArrayList<>();
        uriPath.add("path");
        mappings.put("@URIPATH", uriPath);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getUri(mappingFile, queryString, ctx)).thenReturn("http://test.com/path");

            HttpRequest.Builder builder = HttpRequest.newBuilder();
            HttpRequest.Builder resultBuilder = RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);

            assertEquals("http://test.com/path", resultBuilder.build().uri().toString());
        }
    }

@Test
    public void test_getUri_with_valid_mappingFile_and_queryString_and_context() {
        String mappingFile = "mappingFile";
        String queryString = "queryString";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("var1", "value1");
        ctx.put("var2", "value2");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "https://domain");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("$VAR.var1");
        resourceList.add("part2");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getUri(mappingFile, queryString, ctx)).thenCallRealMethod();

            String actualUri = RestAdapterInfo.getUri(mappingFile, queryString, ctx);
            String expectedUri = "https://domain/value1/part2?queryString";

            assertEquals(expectedUri, actualUri, "The actual URI does not match the expected URI");
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testTransformWithEmptyContext() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext req = null;
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@BODYTML", "");
            mappings.put("@TRANSFORM", new ArrayList<>());
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getBodyTmpl("")).thenReturn(null);
            mockedStatic.when(() -> RestAdapterInfo.transform(mappingFile, ctx, req)).thenCallRealMethod();

            String result = RestAdapterInfo.transform(mappingFile, ctx, req);
            assertEquals(null, result);
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testTransformWithNonNullContext() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key", "value");
        DocumentContext req = null;
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@BODYTML", "");
            mappings.put("@TRANSFORM", new ArrayList<>());
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getBodyTmpl("")).thenReturn(null);
            mockedStatic.when(() -> RestAdapterInfo.transform(mappingFile, ctx, req)).thenCallRealMethod();

            String result = RestAdapterInfo.transform(mappingFile, ctx, req);
            assertEquals(null, result);
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testTransformWithNonNullContextAndNonNullReq() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key", "value");
        DocumentContext req = Mockito.mock(DocumentContext.class);
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            HashMap<String, Object> mappings = new HashMap<>();
            mappings.put("@BODYTML", "");
            mappings.put("@TRANSFORM", new ArrayList<>());
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            mockedStatic.when(() -> RestAdapterInfo.getBodyTmpl("")).thenReturn(req);
            mockedStatic.when(() -> RestAdapterInfo.transform(mappingFile, ctx, req)).thenCallRealMethod();

            String result = RestAdapterInfo.transform(mappingFile, ctx, req);
            assertEquals(req.jsonString(), result);
        }
    }

@Test
    public void testParseHeaders_withInvalidMappingFile() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("Content-Type", "application/json");
        ctx.put("authToken", "tokenforauthorizationinsamlformat");

        HashMap<String, HashMap<String, String>> mappings = new HashMap<>();
        mappings.put("@HEADER", new HashMap<>());

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("invalidMappingFile")).thenReturn(mappings);

            ArrayList<BasicHeader> headers = RestAdapterInfo.parseHeaders("invalidMappingFile", ctx);

            assertEquals(0, headers.size(), "Headers size should be 0 for invalid mapping file");
        }
    }

    @Disabled("Automatically disabled by AI")
@Test
    public void testParseHeaders_withValidMappingFile() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("Content-Type", "application/json");
        ctx.put("authToken", "tokenforauthorizationinsamlformat");

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "$VAR.Content-Type");
        headerMap.put("authToken", "$VAR.authToken");

        HashMap<String, HashMap<String, String>> mappings = new HashMap<>();
        mappings.put("@HEADER", headerMap);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("validMappingFile")).thenReturn(mappings);

            ArrayList<BasicHeader> headers = RestAdapterInfo.parseHeaders("validMappingFile", ctx);

            assertEquals(2, headers.size(), "Headers size should be 2 for valid mapping file");
            assertEquals("Content-Type", headers.get(0).getName());
            assertEquals("application/json", headers.get(0).getValue());
            assertEquals("authToken", headers.get(1).getName());
            assertEquals("tokenforauthorizationinsamlformat", headers.get(1).getValue());
        }
    }

@Test
    public void testGetMethod_withMappingFileHavingNoMethod() {
        String mappingFile = "mappingFile";
        HashMap<String, String> mappings = new HashMap<>();
        mappings.put("@METHOD", null);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

            String result = RestAdapterInfo.getMethod(mappingFile);

            assertEquals(null, result);
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void test_sendPOST_with_null_context() {
        HashMap<String, String> ctx = null;
        DocumentContext req = mock(DocumentContext.class);
        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = Mockito.mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.getUri(mappingFile, "", ctx)).thenReturn("http://test.com");
            ArrayList<BasicHeader> headers = new ArrayList<>();
            headers.add(new BasicHeader("header1", "value1"));
            mockedStatic.when(() -> RestAdapterInfo.parseHeaders(mappingFile, ctx)).thenReturn(headers);
            mockedStatic.when(() -> RestAdapterInfo.transform(mappingFile, ctx, req)).thenReturn("body");

            String result = RestAdapterInfo.sendPOST(mappingFile, ctx, req);

            assertEquals("", result);
        }
    }

@Test
    public void testParseQS_withInvalidMappingFile() {
        HashMap<String, String> context = new HashMap<>();
        context.put("key1", "value1");
        context.put("key2", "value2");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("invalidMappingFile")).thenReturn(new HashMap<>());

            String result = RestAdapterInfo.parseQS("invalidMappingFile", context);

            assertEquals("", result, "Expected an empty string as the result because the mapping file is invalid");
        }
    }

@Test
    public void test_getUri_with_invalid_mappingFile_and_valid_queryString_and_context() {
        String mappingFile = "invalidMappingFile";
        String queryString = "validQueryString";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "http://localhost");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("resource1");
        resourceList.add("resource2");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            String result = RestAdapterInfo.getUri(mappingFile, queryString, ctx);
            assertEquals("http://localhost/resource1/resource2?validQueryString", result);
        }
    }

@Test
    public void testGetMethod_withMappingFileHavingEmptyMethod() {
        String mappingFile = "mappingFile";
        HashMap<String, String> mappings = new HashMap<>();
        mappings.put("@METHOD", "");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

            String result = RestAdapterInfo.getMethod(mappingFile);

            assertEquals("", result);
        }
    }

@Test
    public void test_getUri_with_valid_mappingFile_and_queryString_and_invalid_context() {
        String mappingFile = "validMappingFile";
        String queryString = "validQueryString";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("invalidKey", "invalidValue");

        HashMap<String, Object> mockMappings = new HashMap<>();
        mockMappings.put("@URIDOMAIN", "http://localhost");
        ArrayList<String> mockResourceList = new ArrayList<>();
        mockResourceList.add("resource1");
        mockMappings.put("@URIPATH", mockResourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mockMappings);
            String actualUri = RestAdapterInfo.getUri(mappingFile, queryString, ctx);
            String expectedUri = "http://localhost/resource1?validQueryString";
            assertEquals(expectedUri, actualUri, "The actual URI does not match the expected URI");
        }
    }

    @Test
    public void test_getUri_with_valid_mappingFile_and_queryString_and_valid_context() {
        String mappingFile = "validMappingFile";
        String queryString = "validQueryString";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("resource1", "resourceValue");

        HashMap<String, Object> mockMappings = new HashMap<>();
        mockMappings.put("@URIDOMAIN", "http://localhost");
        ArrayList<String> mockResourceList = new ArrayList<>();
        mockResourceList.add("$VAR.resource1");
        mockMappings.put("@URIPATH", mockResourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mockMappings);
            String actualUri = RestAdapterInfo.getUri(mappingFile, queryString, ctx);
            String expectedUri = "http://localhost/resourceValue?validQueryString";
            assertEquals(expectedUri, actualUri, "The actual URI does not match the expected URI");
        }
    }

@Test
    public void testDoGet_withValidMappingFileAndContext() {
        String mappingFile = "validMappingFile";
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext reqDc = mock(DocumentContext.class);

        try (MockedStatic<RestAdapterInfo> mockedStatic = Mockito.mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.parseQS(mappingFile, ctx)).thenReturn("parsedQS");
            mockedStatic.when(() -> RestAdapterInfo.getUri(mappingFile, "parsedQS", ctx)).thenReturn("fullUri");
            mockedStatic.when(() -> RestAdapterInfo.parseHeaders(mappingFile, ctx)).thenReturn(new ArrayList<BasicHeader>());
            mockedStatic.when(() -> RestAdapterInfo.doGet(mappingFile, ctx, reqDc)).thenReturn("expectedResult");

            String result = RestAdapterInfo.doGet(mappingFile, ctx, reqDc);

            assertEquals("expectedResult", result);
        }
    }

@Test
    public void testDoGet_withInvalidHeadersInContext() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("invalidHeader", "invalidValue");

        DocumentContext reqDc = mock(DocumentContext.class);

        try (MockedStatic<RestAdapterInfo> mockedStatic = Mockito.mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.parseQS("mappingFile", ctx)).thenReturn("");
            mockedStatic.when(() -> RestAdapterInfo.getUri("mappingFile", "", ctx)).thenReturn("http://test.com");
            mockedStatic.when(() -> RestAdapterInfo.parseHeaders("mappingFile", ctx)).thenReturn(new ArrayList<BasicHeader>());

            String result = RestAdapterInfo.doGet("mappingFile", ctx, reqDc);

            assertEquals(null, result, "Expected null result due to invalid headers in context");
        }
    }

@Test
    public void testDoGet_withInvalidMappingFile() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext reqDc = mock(DocumentContext.class);

        try (MockedStatic<RestAdapterInfo> mockedStatic = Mockito.mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.parseQS("invalidMappingFile", ctx)).thenReturn("");
            mockedStatic.when(() -> RestAdapterInfo.getUri("invalidMappingFile", "", ctx)).thenReturn("invalidUri");
            mockedStatic.when(() -> RestAdapterInfo.parseHeaders("invalidMappingFile", ctx)).thenReturn(new ArrayList<>());

            String result = RestAdapterInfo.doGet("invalidMappingFile", ctx, reqDc);

            assertEquals(null, result);
        }
    }

@Test
    public void testSetUri_withInvalidMappingFileAndValidBuilderAndQueryStringAndContext() {
        String mappingFile = "invalidMappingFile";
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        String queryString = "query";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key", "value");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(new HashMap<>());
            mockedStatic.when(() -> RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx)).thenCallRealMethod();

            HttpRequest.Builder resultBuilder = RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);

            assertEquals(builder, resultBuilder);
            mockedStatic.verify(() -> RestAdapterInfo.loadTransformer(mappingFile), times(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testTransformWithValidMappingFileAndContext() {
        String mappingFile = "mappingFile";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key1", "value1");
        ctx.put("key2", "value2");
        DocumentContext req = JsonPath.parse("{}");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(new HashMap<>());
            mockedStatic.when(() -> RestAdapterInfo.getBodyTmpl("template")).thenReturn(JsonPath.parse("{}"));

            BaseRequestProcessor rp = mock(BaseRequestProcessor.class);
            when(rp.process(new ArrayList<>(), ctx, JsonPath.parse("{}"), req, "-1")).thenReturn(null);

            String result = RestAdapterInfo.transform(mappingFile, ctx, req);

            assertEquals("{}", result);
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void testSetUri_withValidMappingFileAndBuilderAndEmptyQueryStringAndContext() {
        String mappingFile = "mappingFile";
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        String queryString = "";
        HashMap<String, String> ctx = new HashMap<>();

        HashMap<String, Object> transformerMap = new HashMap<>();
        transformerMap.put("@URIPATH", new ArrayList<>());

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(transformerMap);
            mockedStatic.when(() -> RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx)).thenCallRealMethod();

            HttpRequest.Builder resultBuilder = RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);

            mockedStatic.verify(() -> RestAdapterInfo.loadTransformer(mappingFile), times(1));
            assertEquals(builder, resultBuilder);
        }
    }

@Test
    public void testParseQS_withValidMappingFileAndContext() {
        HashMap<String, String> context = new HashMap<>();
        context.put("value1", "value1");
        context.put("value2", "value2");

        HashMap<String, HashMap<String, String>> mappings = new HashMap<>();
        HashMap<String, String> qsMap = new HashMap<>();
        qsMap.put("key1", "value1");
        qsMap.put("key2", "value2");
        mappings.put("@QSPARAM", qsMap);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("validMappingFile")).thenReturn(mappings);

            String result = RestAdapterInfo.parseQS("validMappingFile", context);

            assertEquals("key1=value1&key2=value2", result);
        }
    }

@Test
    public void testParseHeaders_withValidMappingFileAndContext() {
        HashMap<String, String> context = new HashMap<>();
        context.put("Content-Type", "application/json");
        context.put("authToken", "tokenforauthorizationinsamlformat");

        HashMap<String, HashMap<String, String>> mappings = new HashMap<>();
        mappings.put("@HEADER", context);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(mappings);

            ArrayList<BasicHeader> result = RestAdapterInfo.parseHeaders("mappingFile", context);

            assertTrue(result.stream().anyMatch(header -> header.getName().equals("Content-Type") && header.getValue().equals("application/json")));
            assertTrue(result.stream().anyMatch(header -> header.getName().equals("authToken") && header.getValue().equals("tokenforauthorizationinsamlformat")));
        }
    }

@Disabled("Automatically disabled by AI")
@Test
    public void test_loadTransformer_with_non_existent_mappingfile() {
        String mappingFile = "non_existent_mappingfile";

        try (MockedStatic<LogManager> mockedLogManager = mockStatic(LogManager.class)) {
            mockedLogManager.when(() -> LogManager.logInfo(anyString())).thenCallRealMethod();
            mockedLogManager.when(() -> LogManager.logError(anyString(), any(Throwable.class))).thenCallRealMethod();

            try (MockedStatic<FileReader> mockedFileReader = mockStatic(FileReader.class)) {
                mockedFileReader.when(() -> new FileReader(any(File.class))).thenThrow(new FileNotFoundException());

                HashMap result = RestAdapterInfo.loadTransformer(mappingFile);

                assertNull(result, "The result should be null as the mapping file does not exist");
                mockedLogManager.verify(() -> LogManager.logError(anyString(), any(FileNotFoundException.class)), times(1));
            }
        }
    }

@Test
    public void testGetMethod_withValidMappingFile() {
        String mappingFile = "validMappingFile";
        HashMap<String, String> mockMappings = new HashMap<>();
        mockMappings.put("@METHOD", "GET");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mockMappings);

            String method = RestAdapterInfo.getMethod(mappingFile);

            assertEquals("GET", method);
        }
    }

@Test
    public void test_sendPOST_with_valid_mappingFile_and_context() {
        HashMap<String, String> context = new HashMap<>();
        context.put("key1", "value1");
        context.put("key2", "value2");

        DocumentContext documentContext = mock(DocumentContext.class);

        String expectedResponse = "Expected Response";

        try (MockedStatic<RestAdapterInfo> mockedStatic = Mockito.mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.sendPOST("validMappingFile", context, documentContext)).thenReturn(expectedResponse);

            String actualResponse = RestAdapterInfo.sendPOST("validMappingFile", context, documentContext);

            assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
        }
    }

@Test
    public void testParseQS_withEmptyContext() {
        HashMap<String, String> context = new HashMap<>();

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer("mappingFile")).thenReturn(new HashMap<>());

            String result = RestAdapterInfo.parseQS("mappingFile", context);

            assertEquals("", result);
        }
    }

@Test
    public void testDoGet_withEmptyContext() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext reqDc = JsonPath.parse("{}");

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.parseQS("mappingFile", ctx)).thenReturn("");
            mockedStatic.when(() -> RestAdapterInfo.getUri("mappingFile", "", ctx)).thenReturn("http://test.com");
            mockedStatic.when(() -> RestAdapterInfo.parseHeaders("mappingFile", ctx)).thenReturn(new ArrayList<BasicHeader>());

            String result = RestAdapterInfo.doGet("mappingFile", ctx, reqDc);

            assertEquals(null, result);
        }
    }

@Test
    public void testSetUri_withValidMappingFileAndBuilderAndQueryStringAndContext() throws URISyntaxException {
        String mappingFile = "mappingFile";
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        String queryString = "queryString";
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("var1", "value1");

        HashMap<String, Object> mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "https://domain/");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("$VAR.var1");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);

            HttpRequest.Builder resultBuilder = RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);

            assertEquals(new URI("https://domain/value1?queryString"), resultBuilder.build().uri());
        }
    }

@Test
    public void testGetMethod_withNonExistentMappingFile() {
        String mappingFile = "non_existent_mapping_file";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(new HashMap<>());

            String result = RestAdapterInfo.getMethod(mappingFile);

            assertEquals(null, result, "getMethod should return null for non-existent mapping file");
        }
    }

@Test
    public void testParseQS_withContextHavingNoMatchingKeys() {
        HashMap<String, String> context = new HashMap<>();
        context.put("nonMatchingKey1", "value1");
        context.put("nonMatchingKey2", "value2");

        String mappingFile = "mappingFile";

        try (MockedStatic<RestAdapterInfo> mockedStatic = mockStatic(RestAdapterInfo.class, Mockito.CALLS_REAL_METHODS)) {
            mockedStatic.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(new HashMap<>());

            String result = RestAdapterInfo.parseQS(mappingFile, context);

            assertEquals("", result, "The result should be an empty string as there are no matching keys in the context.");
        }
    }

}