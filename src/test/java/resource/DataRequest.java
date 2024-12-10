package resource;

import java.util.HashMap;
import java.util.Map;

// This file use for data request/payload
public class DataRequest {

    public Map<Integer, String> addItemCollection() {
        Map<Integer, String> dataCollection = new HashMap<>();

        dataCollection.put(1, "{\n" + //
                "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                "   \"data\": {\n" + //
                "      \"year\": 2019,\n" + //
                "      \"price\": 20000,\n" + //
                "      \"CPU model\": \"Intel Core i9\",\n" + //
                "      \"Hard disk size\": \"1 TB\"\n" + //
                "   }\n" + //
                "}");

        dataCollection.put(2, "{\n" + //
                "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                "   \"data\": {\n" + //
                "      \"year\": 2020,\n" + //
                "      \"price\": 30000,\n" + //
                "      \"CPU model\": \"Intel Core i7\",\n" + //
                "      \"Hard disk size\": \"5 TB\"\n" + //
                "   }\n" + //
                "}");

        return dataCollection;
    }

}
