package com.cnty.auto.net;


import com.cnty.auto.pojo.User;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: poker face
 * @date: 2017/11/27 0027 9:00
 * @since: JDK1.8.0_31
 * @version: X
 * Description:
 */
public class ServerThread implements Runnable {
    private Socket socket;
    private InputStream in = null;
    private InputStreamReader reader = null;

    private BufferedReader br = null;

    /**
     * 构造方法
     * @param socket
     */
    ServerThread(Socket socket) {
        this.socket = socket;
        try {
            in = this.socket.getInputStream();
            reader = new InputStreamReader(in);
            br = new BufferedReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String str;
        String result;
        OutputStream out;
        PrintWriter pw;
        try {
            out = socket.getOutputStream();
            pw = new PrintWriter(out, true);
            while ((str = br.readLine()) != null && !"".equals(str)) {
                String cmd = str;
                str = str.trim();
                String type;
                String no;
                if ("@".equals(str.substring(0, 1)) && str.contains(":") && str.contains(";") && str.contains(",")) {
                    // 机器类别
                    type = str.substring(1, str.indexOf(":")).replaceAll("[0-9]", "").trim();
                    // 机器编号
                    no = str.substring(type.length() + 1, str.indexOf(":"));
                    // 通讯命令
                    String action = str.substring(str.indexOf(":") + 1, str.indexOf(","));
                    str = str.substring(str.indexOf(",") + 1, str.indexOf(";"));
                    String[] datas = str.split(",");
                    result = "@" + type + no + ":R";

                    //用户
                    User user;

                    //用户id
                    int userId = 0;
                    //商品代码
                    String cmdW = null;
                    //垃圾类别
                    String cmdO = null;
                    //重量
                    double cmdT = 0;
                    //垃圾袋编号
                    String cmdL = null;
                    //本次积分
                    String cmdJ = null;
                    //总积分
                    double cmdZ = 0;
                    //状态码
                    String cmdS = null;
                    //操作是否成功
                    boolean isOk = true;
                    //判断机器是否存在
                    switch (action) {
                        case "A":
                            for (String data : datas) {
                                String key = data.substring(0, 1);
                                String value = data.substring(key.length());
                                switch (key) {
                                    case "A":
                                        // A号子桶称重
                                        break;
                                    case "B":
                                        // B号子桶称重
                                        break;
                                    case "C":
                                        // C号子桶称重
                                        break;
                                    case "D":
                                        // D号子桶称重
                                        break;
                                    case "E":
                                        // E号子桶称重
                                        break;
                                    case "F":
                                        // F号子桶称重
                                        break;
                                    case "G":
                                        // G号子桶称重
                                        break;
                                    case "H":
                                        // H号子桶称重
                                        break;
                                    case "cmdJ":
                                        // 本次产生的积分
                                        // 判断是否为兑换机
                                        if ("TYD".equals(type)) {
                                            cmdJ = value;
                                        }
                                        break;
                                    case "cmdL":
                                        cmdL = value;
                                        break;
                                    case "N":
                                        // 用户丢垃圾时可用垃圾袋二维码及刷卡的身份二维码扫描号(20位String)
                                        // 判断是否存在用户
                                        //if () {
                                        //存在
                                        //获取用户id
                                        //判断是否为发袋机
                                        //if (type.equals("TYF")) {
                                        //    result += ("," + key + value);
                                        //} else if (type.equals("TYD")) {
                                        //    result += ("," + key + value);
                                        //} else if (type.equals("TYZ")) {
                                        //    result += (",R0," + key + value);
                                        //}
                                        //获取用户当前积分
                                        //cmdZ=
                                        // 判断是否为垃圾袋编号
                                        //} else if () {
                                        //获取用户id
                                        //用户当前积分
                                        //cmdZ=
                                        //result += (",R0," + key + value);
                                        //用户不存在
                                        //} else {
                                        //result += (",R1");
                                        //isOk = false;
                                        //break;
                                        //}
                                        break;
                                    case "cmdO":
                                        // 智能桶开门号
                                        cmdO = value;
                                        break;
                                    case "cmdS":
                                        // 设备状态
                                        cmdS = value;
                                        break;
                                    case "cmdT":
                                        cmdT = Double.parseDouble(value);
                                        break;
                                    case "cmdW":
                                        // 商品代码
                                        cmdW = value;
                                        break;
                                    case "X":
                                        // 定位数据1(10位String)
                                        break;
                                    case "Y":
                                        // 定位数据2(10位String)
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;

                        default:
                            break;
                    }
                    //判断用户是否存在
                    if (userId != 0) {
                        if ("TYF".equals(type)) {
                            //if (cmdS != null) {
                                //更新智能设备状态
                            //}
                            if (userId != 0 && cmdL != null) {
                                //用户与垃圾袋二维码绑定
                                result += (",R0");
                            }
                            //if (userId != 0 && cmdL == null) {
                                //添加用户领取垃圾袋记录
                            //}
                        } else if ("TYD".equals(type)) {
                            //if (cmdS != null) {
                                //更新智能设备状态信息
                            //}
                            if (cmdJ == null) {
                                result += (",R0");
                            }
                            if (userId != 0 && cmdW != null && cmdJ != null) {
                                // 判断积分是否足够
                                //if () {
                                result += (",R0");
                                //计算总积分
                                cmdZ -= Double.parseDouble(cmdJ);
                                //更新总积分
                                // 订单编号 用户id 商品id 数量 总价 订单状态
                                // 根据时间生成 userId cmdW 1 cmdJ 8
                                // 将数据保存至订单表
                                //} else {
                                result += (",R1");
                                isOk = false;
                                //}
                                result += (",cmdJ" + cmdJ + ",cmdZ" + cmdZ);
                            } else if ("TYZ".equals(type)) {
                                //if (cmdS != null) {
                                    //更新智能设备状态
                                //}
                                if (userId != 0 && cmdO != null && cmdT != 0) {
                                    //计算本次产生积分

                                    result += (",cmdJ" + cmdJ);
                                    //计算总积分
                                    cmdZ += Double.parseDouble(cmdJ);
                                    //更新积分
                                    result += (",cmdZ" + cmdZ);
                                    // 机器id 用户id 回收物品id 重量 时间 所得积分
                                    // no     userId cmdO           cmdT 系统默认 cmdJ
                                    // 将数据保存至垃圾回收表
                                }
                            }
                            //if (isOk) {
                                //请求成功
                            //} else {
                                //请求失败
                            //}
                            //添加通讯日志
                        }
                        result += ";";
                    } else {
                        result = "@" + type + no + ":R,R1;";
                    }
                    pw.println(result + "\n");
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    System.out.println("请求：" + cmd);
                    System.out.println("响应：" + result);
                }
            }
            pw.flush();
            pw.close();
            out.close();
            br.close();
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
