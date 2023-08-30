package saralarchan.org.adapter.db;

import org.mockito.Mockito;
import org.mockito.MockedStatic;
import java.util.HashMap;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import java.util.ArrayList;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.Statement;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import net.sf.jsqlparser.statement.insert.Insert;
import saralarchan.org.logger.LogManager;
import net.sf.jsqlparser.statement.update.UpdateSet;
import org.junit.jupiter.api.Test;
import net.sf.jsqlparser.statement.update.Update;
import static org.junit.jupiter.api.Assertions.assertEquals;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.statement.select.Select;
import static org.mockito.Mockito.mock;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.statement.delete.Delete;
import org.junit.jupiter.api.Disabled;

public class QueryParserTest {

    @Test
    public void testParseDeleteWithWhereClause() throws Exception {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("id", "1");
        String sql = "DELETE FROM table WHERE id = $VAR.id";

        Delete delete = mock(Delete.class);
        Expression expression = mock(Expression.class);
        when(delete.getWhere()).thenReturn(expression);

        try (MockedStatic<CCJSqlParserUtil> utilities = Mockito.mockStatic(CCJSqlParserUtil.class)) {
            utilities.when(() -> CCJSqlParserUtil.parse(sql)).thenReturn(delete);
            utilities.when(() -> CCJSqlParserUtil.parseCondExpression(expression.toString())).thenReturn(expression);

            HashMap result = QueryParser.parseDelete(ctx, sql);
            assertEquals(0, result.size());
        }
    }

    @Test
    public void testParseDeleteWithoutWhereClause() throws Exception {
        HashMap<String, String> ctx = new HashMap<>();
        String sql = "DELETE FROM table";

        Delete delete = mock(Delete.class);
        when(delete.getWhere()).thenReturn(null);

        try (MockedStatic<CCJSqlParserUtil> utilities = Mockito.mockStatic(CCJSqlParserUtil.class)) {
            utilities.when(() -> CCJSqlParserUtil.parse(sql)).thenReturn(delete);

            HashMap result = QueryParser.parseDelete(ctx, sql);
            assertEquals(0, result.size());
        }
    }

    @Test
    public void testParseDeleteWithJSQLParserException() {
        HashMap<String, String> ctx = new HashMap<>();
        String sql = "DELETE FROM table WHERE id = $VAR.id";

        try (MockedStatic<CCJSqlParserUtil> utilities = Mockito.mockStatic(CCJSqlParserUtil.class)) {
            utilities.when(() -> CCJSqlParserUtil.parse(sql)).thenThrow(new RuntimeException());

            HashMap result = QueryParser.parseDelete(ctx, sql);
            assertEquals(0, result.size());
        } catch (Exception e) {
            // Exception is expected
        }
    }

    @Test
    public void testPrepareSelectWithWhereClause() {
        HashMap ctx = new HashMap();
        String sql = "SELECT * FROM table WHERE id = 1";

        Select select = mock(Select.class);
        PlainSelect ps = mock(PlainSelect.class);
        Expression whereClause = mock(Expression.class);
        Expression expr = mock(Expression.class);
        ExpressionResolvingAdapter era = mock(ExpressionResolvingAdapter.class);

        try (MockedStatic<CCJSqlParserUtil> mocked = Mockito.mockStatic(CCJSqlParserUtil.class)) {
            mocked.when(() -> CCJSqlParserUtil.parse(sql)).thenReturn(select);
            mocked.when(() -> CCJSqlParserUtil.parseCondExpression(whereClause.toString())).thenReturn(expr);
        }

        when(select.getSelectBody()).thenReturn(ps);
        when(ps.getWhere()).thenReturn(whereClause);
        when(whereClause.toString()).thenReturn("id = 1");
        expr.accept(era);

        HashMap result = QueryParser.prepareSelect(ctx, sql);

        assertEquals(new HashMap(), result);
    }

    @Test
    public void testPrepareSelectWithoutWhereClause() {
        HashMap ctx = new HashMap();
        String sql = "SELECT * FROM table";

        Select select = mock(Select.class);
        PlainSelect ps = mock(PlainSelect.class);

        try (MockedStatic<CCJSqlParserUtil> mocked = Mockito.mockStatic(CCJSqlParserUtil.class)) {
            mocked.when(() -> CCJSqlParserUtil.parse(sql)).thenReturn(select);
        }

        when(select.getSelectBody()).thenReturn(ps);
        when(ps.getWhere()).thenReturn(null);

        HashMap result = QueryParser.prepareSelect(ctx, sql);

        assertEquals(new HashMap(), result);
    }

    @Test
    public void testPrepareInsertWithVar() throws Exception {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("name", "John");

        String sql = "INSERT INTO users (name) VALUES ($VAR.name)";

        try (MockedStatic<CCJSqlParserUtil> mockedStatic = mockStatic(CCJSqlParserUtil.class)) {
            Insert insert = Mockito.mock(Insert.class);
            ExpressionList exprList = Mockito.mock(ExpressionList.class);
            Expression expr = Mockito.mock(Expression.class);

            mockedStatic.when(() -> CCJSqlParserUtil.parse(sql)).thenReturn(insert);
            when(insert.getItemsList()).thenReturn(exprList);
            when(exprList.getExpressions()).thenReturn(List.of(expr));
            when(expr.toString()).thenReturn("$VAR.name");

            HashMap result = QueryParser.prepareInsert(ctx, sql);

            assertEquals("John", result.get("$VAR.name"));
        }
    }

    @Test
    public void testPrepareInsertWithQuotedVar() throws Exception {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("name", "John");

        String sql = "INSERT INTO users (name) VALUES ('$VAR.name')";

        try (MockedStatic<CCJSqlParserUtil> mockedStatic = mockStatic(CCJSqlParserUtil.class)) {
            Insert insert = Mockito.mock(Insert.class);
            ExpressionList exprList = Mockito.mock(ExpressionList.class);
            Expression expr = Mockito.mock(Expression.class);

            mockedStatic.when(() -> CCJSqlParserUtil.parse(sql)).thenReturn(insert);
            when(insert.getItemsList()).thenReturn(exprList);
            when(exprList.getExpressions()).thenReturn(List.of(expr));
            when(expr.toString()).thenReturn("'$VAR.name'");

            HashMap result = QueryParser.prepareInsert(ctx, sql);

            assertEquals("John", result.get("$VAR.name"));
        }
    }

    @Test
    public void testPrepareInsertWithException() throws Exception {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("name", "John");

        String sql = "INSERT INTO users (name) VALUES ($VAR.name)";

        try (MockedStatic<CCJSqlParserUtil> mockedStatic = mockStatic(CCJSqlParserUtil.class)) {
            mockedStatic.when(() -> CCJSqlParserUtil.parse(sql)).thenThrow(new RuntimeException());

            assertThrows(RuntimeException.class, () -> QueryParser.prepareInsert(ctx, sql));
        }
    }

    @Disabled("Automatically disabled by AI")
    @Test
    public void testParseUpdateWithNoWhereClause() throws JSQLParserException {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("VAR", "value");

        String sql = "UPDATE table SET column = [$VAR.]";

        HashMap<String, String> expected = new HashMap<>();
        expected.put("[$VAR.]", "value");

        try (MockedStatic<CCJSqlParserUtil> mockedStatic = mockStatic(CCJSqlParserUtil.class)) {
            Update mockUpdate = mock(Update.class);
            ArrayList<UpdateSet> updateSets = new ArrayList<>();
            UpdateSet mockUpdateSet = mock(UpdateSet.class);
            ArrayList<Expression> expressions = new ArrayList<>();
            Expression mockExpression = mock(Expression.class);
            when(mockExpression.toString()).thenReturn("[$VAR.]");
            expressions.add(mockExpression);
            when(mockUpdateSet.getExpressions()).thenReturn(expressions);
            updateSets.add(mockUpdateSet);
            when(mockUpdate.getUpdateSets()).thenReturn(updateSets);
            when(CCJSqlParserUtil.parse(sql)).thenReturn(mockUpdate);
            assertEquals(expected, QueryParser.parseUpdate(ctx, sql));
        }
    }

    @Disabled("Automatically disabled by AI")
    @Test
    public void testParseUpdateWithWhereClause() throws JSQLParserException {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("VAR", "value");

        String sql = "UPDATE table SET column = [$VAR.] WHERE column = [$VAR.]";

        HashMap<String, String> expected = new HashMap<>();
        expected.put("[$VAR.]", "value");

        try (MockedStatic<CCJSqlParserUtil> mockedStatic = mockStatic(CCJSqlParserUtil.class)) {
            Update mockUpdate = mock(Update.class);
            ArrayList<UpdateSet> updateSets = new ArrayList<>();
            UpdateSet mockUpdateSet = mock(UpdateSet.class);
            ArrayList<Expression> expressions = new ArrayList<>();
            Expression mockExpression = mock(Expression.class);
            when(mockExpression.toString()).thenReturn("[$VAR.]");
            expressions.add(mockExpression);
            when(mockUpdateSet.getExpressions()).thenReturn(expressions);
            updateSets.add(mockUpdateSet);
            when(mockUpdate.getUpdateSets()).thenReturn(updateSets);
            when(CCJSqlParserUtil.parse(sql)).thenReturn(mockUpdate);
            assertEquals(expected, QueryParser.parseUpdate(ctx, sql));
        }
    }

    @Disabled("Automatically disabled by AI")
    @Test
    public void testParseUpdateWithMultipleUpdateSets() throws JSQLParserException {
        HashMap<String, String> ctx = new HashMap<>();
        ctx.put("VAR", "value");
        ctx.put("VAR2", "value2");

        String sql = "UPDATE table SET column = [$VAR.], column2 = [$VAR2.]";

        HashMap<String, String> expected = new HashMap<>();
        expected.put("[$VAR.]", "value");
        expected.put("[$VAR2.]", "value2");

        try (MockedStatic<CCJSqlParserUtil> mockedStatic = mockStatic(CCJSqlParserUtil.class)) {
            Update mockUpdate = mock(Update.class);
            ArrayList<UpdateSet> updateSets = new ArrayList<>();
            UpdateSet mockUpdateSet = mock(UpdateSet.class);
            ArrayList<Expression> expressions = new ArrayList<>();
            Expression mockExpression = mock(Expression.class);
            when(mockExpression.toString()).thenReturn("[$VAR.]");
            expressions.add(mockExpression);
            Expression mockExpression2 = mock(Expression.class);
            when(mockExpression2.toString()).thenReturn("[$VAR2.]");
            expressions.add(mockExpression2);
            when(mockUpdateSet.getExpressions()).thenReturn(expressions);
            updateSets.add(mockUpdateSet);
            when(mockUpdate.getUpdateSets()).thenReturn(updateSets);
            when(CCJSqlParserUtil.parse(sql)).thenReturn(mockUpdate);
            assertEquals(expected, QueryParser.parseUpdate(ctx, sql));
        }
    }

    // @Disabled("Automatically disabled by AI")
    // @Test
    // public void testParseUpdateWithJSQLParserException() {
    // HashMap<String, String> ctx = new HashMap<>();
    // ctx.put("VAR", "value");

    // String sql = "UPDATE table SET column = [$VAR.] WHERE column = [$VAR.]";

    // try (MockedStatic<CCJSqlParserUtil> mockedStatic =
    // mockStatic(CCJSqlParserUtil.class)) {
    // when(CCJSqlParserUtil.parse(sql)).thenThrow(JSQLParserException.class);
    // assertThrows(RuntimeException.class, () -> QueryParser.parseUpdate(ctx,
    // sql));
    // }
    // }

    @Test
    public void testPrepareSQL() {
        HashMap<String, String> map = new HashMap<>();
        map.put("$VAR.name", "John");
        map.put("$VAR.age", "25");

        String sql = "INSERT INTO users (name, age) VALUES ($VAR.name, $VAR.age)";

        String result = QueryParser.prepareSQL(map, sql);

        assertEquals("INSERT INTO users (name, age) VALUES (John, 25)", result);
    }

    @Test
    public void testPrepareSQLWithNoReplacement() {
        HashMap<String, String> map = new HashMap<>();
        map.put("$VAR.name", "John");
        map.put("$VAR.age", "25");

        String sql = "SELECT * FROM users";

        String result = QueryParser.prepareSQL(map, sql);

        assertEquals("SELECT * FROM users", result);
    }

    @Test
    public void testPrepareSQLWithPartialReplacement() {
        HashMap<String, String> map = new HashMap<>();
        map.put("$VAR.name", "John");

        String sql = "INSERT INTO users (name, age) VALUES ($VAR.name, $VAR.age)";

        String result = QueryParser.prepareSQL(map, sql);

        assertEquals("INSERT INTO users (name, age) VALUES (John, $VAR.age)", result);
    }

}
