package com.gazoul.unittesting.mockitoJunit.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":50}";


    @Test
    public void jsonAssert_strictTrue() throws JSONException {

        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":50}";
        JSONAssert.assertEquals(expectedResponse , actualResponse, true); //you can have spaces but exact structures should match.
    }

    @Test
    public void jsonAssert_strictFalse() throws JSONException {

        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10";
        JSONAssert.assertEquals(expectedResponse , actualResponse, false); //you can have spaces but exact structures should match.
    }
}
