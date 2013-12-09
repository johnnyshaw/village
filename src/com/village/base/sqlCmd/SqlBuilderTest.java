package com.village.base.sqlCmd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
 
 
public class SqlBuilderTest {
 
    @Before
    public void setUp() throws Exception {}
 
    @Test
    public void test() {
        //Fluent Style
        String sql = new SqlBuilder()
            .SELECT("id, name").FROM("PERSON A")
            .WHERE("name like ?")
            .WHERE("id = ?").toString();
    
        assertEquals("" +
                "SELECT id, name\n" + 
                "FROM PERSON A\n" + 
                "WHERE (name like ? AND id = ?)", sql);
    
        //Mixed
        sql = new SqlBuilder() {{
            SELECT("id, name");
            FROM("PERSON A");
            WHERE("name like ?").WHERE("id = ?");
        }}.toString();
        
        assertEquals("" +
                "SELECT id, name\n" + 
                "FROM PERSON A\n" + 
                "WHERE (name like ? AND id = ?)", sql);
        
        //You can pass in your own StringBuilder
        StringBuilder sb = new StringBuilder();
        //From the tutorial
        sql = new SqlBuilder() {{
              SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
              SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
              FROM("PERSON P");
              FROM("ACCOUNT A");
              INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
              INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
              WHERE("P.ID = A.ID");
              WHERE("P.FIRST_NAME like ?");
              OR();
              WHERE("P.LAST_NAME like ?");
              GROUP_BY("P.ID");
              HAVING("P.LAST_NAME like ?");
              OR();
              HAVING("P.FIRST_NAME like ?");
              ORDER_BY("P.ID");
              ORDER_BY("P.FULL_NAME");
        }}.SQL(sb).toString();
        
        assertEquals("SELECT P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME, P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON\n" + 
                "FROM PERSON P, ACCOUNT A\n" + 
                "INNER JOIN DEPARTMENT D on D.ID = P.DEPARTMENT_ID\n" + 
                "INNER JOIN COMPANY C on D.COMPANY_ID = C.ID\n" + 
                "WHERE (P.ID = A.ID AND P.FIRST_NAME like ?) \n" + 
                "OR (P.LAST_NAME like ?)\n" + 
                "GROUP BY P.ID\n" + 
                "HAVING (P.LAST_NAME like ?) \n" + 
                "OR (P.FIRST_NAME like ?)\n" + 
                "ORDER BY P.ID, P.FULL_NAME", sql);
 
    }
 
}