package proxy.fastjson;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Start {

    public static void main(String[] args) {
        Map<String,Object> data = new HashMap<>();
        data.put("data",1);
        System.out.println(JSONObject.toJSONString(data));
    }
}
