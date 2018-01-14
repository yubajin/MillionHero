package ocr.impl;

import com.baidu.aip.ocr.AipOcr;
import ocr.OCR;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * 返回图片上识别的问题和选项
 * Created by 618 on 2018/1/12.
 * @author lingfengsan
 */
public class BaiDuOCR implements OCR{
    //设置APPID/AK/SK
    private static final String APP_ID = "10686957";
    private static final String API_KEY = "lbysq1pHG7tHNXsGbzBl6XVU";
    private static final String SECRET_KEY = "YgfVD1mikkYoGn9MaPz9KjvV6ppLQcFA";
    private static final AipOcr CLIENT=new AipOcr(APP_ID, API_KEY, SECRET_KEY);
    BaiDuOCR(){
        // 可选：设置网络连接参数
        CLIENT.setConnectionTimeoutInMillis(2000);
        CLIENT.setSocketTimeoutInMillis(60000);
        System.out.println("欢迎您使用百度OCR进行文字识别");
    }
    @Override
    public String getOCR(File file) {
        Long start=System.currentTimeMillis();
        String path=file.getAbsolutePath();
        // 调用接口
        JSONObject res = CLIENT.basicGeneral(path, new HashMap<String, String>());
        String result=res.toString(2);
        System.out.println("百度文字识别耗时:" + ((System.currentTimeMillis())-start) + "ms");
        return result;
    }

//    public static void main(String[] args) {
//        OCR ocr=new BaiDuOCR();
//        String path = "Photo\\test2.png";
//        String result=ocr.getOCR(new File(path));
//        System.out.println("图片识别结果:\n" + result);
//    }
}
