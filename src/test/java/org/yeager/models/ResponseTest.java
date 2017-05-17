package org.yeager.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {

    private  Response response;

    @Before
    public void setup() {
        response = new Response("");
    }

    @Test
    public void testResponseConstructor() {
        String expected = "Blah";
        response = new Response(expected);
        assertEquals(expected, response.getString());
    }

    @Test
    public void testGetSetString() {
        String expected = "Blah";
        response.setString(expected);
        assertEquals(expected, response.getString());
    }
}