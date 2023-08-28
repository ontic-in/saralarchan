package saralarchan.org.adapter.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.net.http.HttpRequest.Builder;
import saralarchan.org.logger.LogManager;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

public class RestAdapterInfoTest {

    @Test
    void testGetMethod() {
        HashMap<String, String> map = new HashMap<>();
        map.put("@METHOD", "GET");

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class,
                Mockito.CALLS_REAL_METHODS)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer("mappingFile.txt")).thenReturn(map);

            String result = RestAdapterInfo.getMethod("mappingFile.txt");

            assertEquals("GET", result);
        }
    }

    @Test
    void testGetMethodNoMethod() {
        HashMap<String, String> map = new HashMap<>();

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class,
                Mockito.CALLS_REAL_METHODS)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer("mappingFile.txt")).thenReturn(map);

            String result = RestAdapterInfo.getMethod("mappingFile.txt");

            assertNull(result);
        }
    }

    @Test
    void testGetMethodEmptyFile() {
        HashMap<String, String> map = new HashMap<>();

        try (MockedStatic<RestAdapterInfo> mocked = Mockito.mockStatic(RestAdapterInfo.class,
                Mockito.CALLS_REAL_METHODS)) {
            mocked.when(() -> RestAdapterInfo.loadTransformer("emptyFile.txt")).thenReturn(map);

            String result = RestAdapterInfo.getMethod("emptyFile.txt");

            assertNull(result);
        }
    }

    @Test
    void setUriValidTest() throws URISyntaxException {
        String mappingFile = "mappingFile";
        Builder builder = mock(Builder.class);
        String queryString = "query";
        HashMap ctx = new HashMap<>();

        HashMap mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "test.com/");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("resource");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> rm = Mockito.mockStatic(RestAdapterInfo.class)) {
            rm.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);
            verify(builder, times(1)).uri(new URI("test.com/resource?query"));
        }
    }

    @Test
    void setUriInvalidURITest() throws URISyntaxException {
        String mappingFile = "mappingFile";
        Builder builder = mock(Builder.class);
        String queryString = "query";
        HashMap ctx = new HashMap<>();

        HashMap mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "|");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("resource");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> rm = Mockito.mockStatic(RestAdapterInfo.class);
                MockedStatic<LogManager> lm = Mockito.mockStatic(LogManager.class)) {
            rm.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);
            lm.verify(() -> LogManager.logError(anyString(), any(URISyntaxException.class)), times(1));
            verify(builder, times(0)).uri(any(URI.class));
        }
    }

    @Test
    void setUriWithVariableReplacementTest() throws URISyntaxException {
        String mappingFile = "mappingFile";
        Builder builder = mock(Builder.class);
        String queryString = "?query=1";
        HashMap ctx = new HashMap<>();
        ctx.put("var1", "resource1");

        HashMap mappings = new HashMap<>();
        mappings.put("@URIDOMAIN", "test.com/");
        ArrayList<String> resourceList = new ArrayList<>();
        resourceList.add("$VAR.var1");
        mappings.put("@URIPATH", resourceList);

        try (MockedStatic<RestAdapterInfo> rm = Mockito.mockStatic(RestAdapterInfo.class)) {
            rm.when(() -> RestAdapterInfo.loadTransformer(mappingFile)).thenReturn(mappings);
            RestAdapterInfo.setUri(mappingFile, builder, queryString, ctx);
            verify(builder, times(1)).uri(new URI("test.com/resource1?query=1"));
        }
    }
}
