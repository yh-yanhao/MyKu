package com.example.lenovo_pc.viewpagerfragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by fan on 2016/11/10.
 */

public class Tools {

    // 将Json数据解析成相应的映射对象
         public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
              Gson gson = new Gson();
            T result = gson.fromJson(jsonData,type);
               return result;
            }

               // 将Json数组解析成相应的映射对象列表
             public static <T> List<T> parseJsonArrayWithGson(String jsonData,Class<T> type) {
             Gson gson = new Gson();
              List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
                   }.getType());
             return result;
            }

}
