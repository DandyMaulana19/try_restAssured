package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

// Response Structure
// this class called POJO Class
public class ResponseItem {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("createdAt")
    public String createdAt;

    @JsonProperty("data")
    public Data data;

    public static class Data {
        @JsonProperty("year")
        public String year;

        @JsonProperty("price")
        public String price;

        @JsonProperty("CPU model")
        public String cpuModel;

        @JsonProperty("Hard disk size")
        public String hardDiskSize;

    }

}
