package com.loser.photograph.constants;

/**
 * @version V2.2.0
 * @Project: BCS-Android
 * @Filename: IBcmpApi.java
 * @Desciption: 请求地址管理
 * @Author: sunbo
 * @Date: 2016/12/29 9:37
 * @Copyright: 2016 AgileSC, Inc. China All rights reserved.
 * <p>
 * Modification History
 * Date				Author	Version 	Desciption
 */
public interface IUrl {
    //API版本
    String API_VERSION = "API-Version:2.4.0,APP-Version:";
    //演示
 /* String APPID_STRING="ud-app-test";// 演示升级appid
    String CHECKVESION_STRING = "http://www.appupdate.d2store.cn/";//正式和演示
    String BASE_URL="http://demo.interface.d2store.cn/";//演示*/

  /*  //测试
    String APPID_STRING = "ud-app"; //正式和测试升级appid
    String CHECKVESION_STRING = "http://192.168.3.220:6555/appupdate/";//测试升级
    String BASE_URL = "http://192.168.3.220:8457/ud/rest/";//测试    */

    // 测试
    String APPID_STRING = "ud-app"; //正式和测试升级appid
    String CHECKVESION_STRING = "http://192.168.3.220:6555/appupdate/";//测试升级
    String BASE_URL = "http://192.168.3.220:7775/";//测试

    //正式
  /*  String APPID_STRING = "ud-app"; //正式和测试升级appid
    String CHECKVESION_STRING = "http://www.appupdate.d2store.cn/";//正式和演示
    String BASE_URL = "http://interface.d2store.cn/";//正式*/

    //开发
/*    String APPID_STRING = "ud-app"; //正式和测试升级appid
//    String BASE_URL = "http://192.168.3.68:8080/ud/rest/";//继武
    String BASE_URL = "http://192.168.3.129:8000/ud/rest/";//开发
    String CHECKVESION_STRING = "http://192.168.3.220:6555/appupdate/";//测试升级*/
//    String CHECKVESION_STRING = "http://192.168.3.129:8000/appupdate/";//测试升级
    //个人服务器地址
//    String BASE_URL="http://192.168.3.24:8080/ud/rest/";//小虎
   /*String APPID_STRING = "ud-app"; //正式和测试升级appid
    String CHECKVESION_STRING = "http://192.168.3.129:8000/appupdate/";//开发升级appid
    String BASE_URL="http://121.43.230.44:7775/bcs-api/";//阿里云
    String BASE_URL="http://192.168.3.88:8081/bcs-api/";//小虎
    String BASE_URL = "http://192.168.3.68:8080/";//继武
    String BASE_URL = "http://192.168.3.52:8080/";//文灿
    String BASE_URL = "http://192.168.3.43:8080/";//李磊
    */
    //崩溃日志上传
    String UPLOAD_URL = BASE_URL + "log/upload/";
}
