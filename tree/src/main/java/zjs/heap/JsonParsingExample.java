package zjs.heap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParsingExample {
    public static void main(String[] args) {
        String json1 = "{\"service_catalog\": {\"name_path\": \"互联网端口开放申请\",\"id\": \"2adaf6cd-f265-4db5-a656-76a02b4f3e1d\",\"type\": \"b7d419b7-a043-4a27-add4-f3fd4e413306\",\"display_name\": \"互联网端口开放申请\"}}";
        String json2 = "{\"service_catalog\": \"2adaf6cd-f265-4db5-a656-76a02b4f3e1d\"}";
        JSONObject object = JSON.parseObject(json2);
        String serviceCatalog = object.getString("service_catalog");
        if (isJSONValid(serviceCatalog)) {
              System.out.println(object.getJSONObject("service_catalog").getString("display_name"));
        } else {
              System.out.println(serviceCatalog);
        }
    }

    public static boolean isJSONValid(String jsonString) {
        final String JSON_PATTERN = "^(?:\\{|\\[).*?(?:\\}|\\])$";
        Pattern pattern = Pattern.compile(JSON_PATTERN);
        Matcher matcher = pattern.matcher(jsonString);
        return matcher.matches();
    }
}
