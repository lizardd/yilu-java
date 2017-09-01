package me.main;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by lmk39 on 2017/5/26.
 */
public class Main {
    //设置APPID/AK/SK
    public static final String APP_ID = "9696048";
    public static final String API_KEY = "qUlKKkWEkFg9i4cdEdW7ykIA";
    public static final String SECRET_KEY = "s0wUm2Xbj7ugtQd2lvTQzkGOY4EvkpZl";

    public static void main(String[] args) {

        // 初始化一个FaceClient
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 自定义参数定义
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "age,beauty,expression");

        // 调用API
        String image = "img/dyb.jpg";
        JSONObject res = client.detect(getRootPath()+image, options);
        System.out.println(res.toString(2));
    }

    public static String getRootPath(){
        //取得根目录路径
        String rootPath=Main.class.getResource("/").getFile().toString();
        //当前目录路径
//        String currentPath1=getClass().getResource(".").getFile().toString();
//        String currentPath2=getClass().getResource("").getFile().toString();
        //当前目录的上级目录路径
//        String parentPath=getClass().getResource("../").getFile().toString();
        return rootPath;
    }

}
