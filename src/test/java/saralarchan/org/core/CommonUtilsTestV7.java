package saralarchan.org.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import saralarchan.org.core.CommonUtils;

public class CommonUtilsTestV7 {

    @Test
    public void testResolvespecifierWithContext() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key", "value");
        DocumentContext respCtx = JsonPath.parse("{}");
        String result = CommonUtils.resolvespecifier("CONTEXT", ctx, respCtx, new Object());
        assertEquals("{key=value}", result);
    }

    @Test
    public void testResolvespecifierWithDC() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext respCtx = JsonPath.parse("{\"key\":\"value\"}");
        String result = CommonUtils.resolvespecifier("DC", ctx, respCtx, new Object());
        assertEquals("{\"key\":\"value\"}", result);
    }

    @Test
    public void testResolvespecifierWithRequest() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext respCtx = JsonPath.parse("{}");
        String result = CommonUtils.resolvespecifier("REQUEST", ctx, respCtx, "{\"key\":\"value\"}");
        assertEquals("{\"key\":\"value\"}", result);
    }

    @Test
    public void testResolvespecifierWithVar() {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("key", "value");
        DocumentContext respCtx = JsonPath.parse("{}");
        String result = CommonUtils.resolvespecifier("$VAR.key", ctx, respCtx, new Object());
        assertEquals("value", result);
    }

    @Test
    public void testResolvespecifierWithRequestJsonPath() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext respCtx = JsonPath.parse("{}");
        String result = CommonUtils.resolvespecifier("$.key", ctx, respCtx, "{\"key\":\"value\"}");
        assertEquals("value", result);
    }

    @Test
    public void testResolvespecifierWithSystem() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext respCtx = JsonPath.parse("{}");
        System.setProperty("key", "value");
        String result = CommonUtils.resolvespecifier("$SYSTEM.key", ctx, respCtx, new Object());
        assertEquals("value", result);
    }

    @Test
    public void testResolvespecifierWithInvalidToken() {
        HashMap<String, String> ctx = new HashMap<>();
        DocumentContext respCtx = JsonPath.parse("{}");
        String result = CommonUtils.resolvespecifier("INVALID", ctx, respCtx, new Object());
        assertNull(result);
    }
}
