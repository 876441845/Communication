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
     *
     * @param socket 连接进入的套接字
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
                    //各个子筒的称重
                    Double cmdA, cmdB, cmdC, cmdD, cmdE, cmdF, cmdG, cmdH;
                    //用户id
                    Integer userId = null;
                    //本次积分
                    Double cmdJ = null;
                    //垃圾袋种类
                    Integer cmdK = null;
                    //垃圾袋编号
                    String cmdL = null;
                    //兑换机货道
                    Integer cmdM;
                    //垃圾类别
                    Integer cmdO;
                    //密码
                    String cmdP = null;
                    //数量
                    Integer cmdQ = null;
                    //状态码
                    String cmdS = null;
                    //温度
                    Double cmdT = null;
                    //用户名
                    String cmdU = null;
                    //订单编号
                    String cmdV = null;
                    //单次记重
                    Double cmdW = null;
                    //GPS定位坐标
                    String cmdX;
                    //GPS定位坐标
                    String cmdY;
                    //总积分
                    Double cmdZ = null;
                    //操作是否成功
                    boolean isOk = true;
                    //判断机器是否存在
                    switch (action) {
                        case "A":
                            for (String data : datas) {
                                String key = data.substring(0, 1);
                                String value = data.substring(key.length());
                                switch (key) {
                                    case "J":
                                        cmdJ = Double.parseDouble(value);
                                        break;
                                    case "K":
                                        cmdK = Integer.parseInt(value);
                                        break;
                                    case "L":
                                        cmdL = value;
                                        break;
                                    case "M":
                                        cmdM = Integer.parseInt(value);
                                        break;
                                    case "N":
                                        //判断是否为用户卡号
                                        if ("00".equals(value.substring(0, 2))) {
                                            // 判断是否存在用户
                                            if ("00000000000000000001".equals(value)) {
                                                //存在
                                                //获取用户id
                                                userId = 1;
                                                //判断是否为发袋机
                                                if ("TYF".equals(type)) {
                                                    result += ("," + key + value);
                                                } else if ("TYD".equals(type)) {
                                                    result += ("," + key + value);
                                                } else if ("TYZ".equals(type)) {
                                                    cmdO = 0;
                                                    result += (",R0,O" + cmdO + ",I" + userId + "," + key + value);
                                                }
                                                //获取用户当前积分
                                                cmdZ = 1000.0;
                                                // 判断是否为垃圾袋编号
                                            } else {
                                                //用户不存在
                                                result += (",R1");
                                                isOk = false;
                                                break;
                                            }
                                        } else {
                                            if ("01000000000000000001".equals(value) && "TYZ".equals(type)) {
                                                //获取用户id
                                                userId = 1;
                                                //根据01类垃圾袋查找垃圾桶对应的开门号
                                                cmdO = 1;
                                                //用户当前积分
                                                cmdZ = 1000.0;
                                                result += (",R0,O" + cmdO + ",I" + userId + "," + key + value);
                                            } else {
                                                isOk = false;
                                                break;
                                            }
                                        }
                                        break;
                                    case "P":
                                        cmdP = value;
                                        break;
                                    case "Q":
                                        cmdQ = Integer.parseInt(value);
                                        break;
                                    case "S":
                                        // 设备状态
                                        cmdS = value;
                                        break;
                                    case "T":
                                        cmdT = Double.parseDouble(value);
                                        break;
                                    case "U":
                                        cmdU = value;
                                        break;
                                    case "V":
                                        cmdV = value;
                                        break;
                                    case "W":
                                        // 单次记重
                                        cmdW = Double.parseDouble(value);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        case "B":
                            for (String data : datas) {
                                String key = data.substring(0, 1);
                                String value = data.substring(key.length());
                                switch (key) {
                                    case "A":
                                        // A号子桶称重
                                        cmdA = Double.parseDouble(value);
                                        break;
                                    case "B":
                                        // B号子桶称重
                                        cmdB = Double.parseDouble(value);
                                        break;
                                    case "C":
                                        // C号子桶称重
                                        cmdC = Double.parseDouble(value);
                                        break;
                                    case "D":
                                        // D号子桶称重
                                        cmdD = Double.parseDouble(value);
                                        break;
                                    case "E":
                                        // E号子桶称重
                                        cmdE = Double.parseDouble(value);
                                        break;
                                    case "F":
                                        // F号子桶称重
                                        cmdF = Double.parseDouble(value);
                                        break;
                                    case "G":
                                        // G号子桶称重
                                        cmdG = Double.parseDouble(value);
                                        break;
                                    case "H":
                                        // H号子桶称重
                                        cmdH = Double.parseDouble(value);
                                        break;
                                    case "K":
                                        // 垃圾袋种类
                                        cmdK = Integer.parseInt(value);
                                        break;
                                    case "M":
                                        // 兑换机货道编号
                                        cmdM = Integer.parseInt(value);
                                        break;
                                    case "Q":
                                        //数量
                                        cmdQ = Integer.parseInt(value);
                                        break;
                                    case "S":
                                        // 设备状态
                                        cmdS = value;
                                        break;
                                    case "T":
                                        cmdT = Double.parseDouble(value) / 10;
                                        break;
                                    case "X":
                                        // 定位数据1(10位String)
                                        cmdX = value;
                                        break;
                                    case "Y":
                                        // 定位数据2(10位String)
                                        cmdY = value;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    if (isOk) {
                        if ("TYF".equals(type)) {
                            if ("A".equals(action)) {
                                if (userId != null && cmdL != null) {
                                    //用户与垃圾袋二维码绑定
                                    result += (",R0,L" + cmdL);
                                }
                                if (userId != null && cmdL == null && cmdK != null) {
                                    if (cmdV == null && cmdQ != null && cmdT != null) {
                                        //添加用户领取垃圾袋记录
                                        result += (",R0,K" + cmdK);
                                    } else if (cmdV != null) {
                                        if (!"TYF1000000120171129103021".equals(cmdV)) {
                                            //数据库垃圾袋数量进行修改
                                        }
                                        result += (",R0,V" + cmdV);
                                    } else if (cmdK != null) {
                                        result += (",R0,K" + cmdK);
                                    }
                                }
                                //补货员登录
                                if (cmdU != null && cmdP != null) {
                                    //判断账户密码是否正确
                                    if ("admin".equals(cmdU) && "123456".equals(cmdP)) {
                                        result += (",R0,U" + cmdU);
                                    } else {
                                        result += (",R1");
                                    }
                                }
                                //申请补货
                                if (cmdU != null && cmdK != null && cmdQ != null) {
                                    //修改发袋机对应种类垃圾袋库存

                                    result += (",R0");
                                }
                            } else if ("B".equals(action)) {
                                if (cmdK != null && cmdQ != null) {
                                    //核对发袋机与服务器的数据
                                }
                            }
                        } else if ("TYD".equals(type)) {
                            if (cmdS != null) {
                                //更新智能设备状态信息
                            }
                            if (cmdJ == null) {
                                result += (",R0");
                            }
                            if (userId != null && cmdW != null && cmdJ != null) {
                                // 根据兑换机改货道商品所需商品积分是否足够
                                //if () {
                                result += (",R0");
                                //计算总积分
                                cmdZ -= cmdJ;
                                //更新总积分
                                // 订单编号 用户id 商品id 数量 总价 订单状态
                                // 根据时间生成 userId cmdW 1 cmdJ 8
                                // 将数据保存至订单表
                                //} else {
                                result += (",R1");
                                isOk = false;
                                //}
                                result += (",cmdJ" + cmdJ + ",cmdZ" + cmdZ);
                            }
                        } else if ("TYZ".equals(type)) {
                            if (cmdS != null) {
                                //更新智能设备状态
                            }
                            if (userId != null && cmdT != null) {
                                //计算本次产生积分
                                result += (",cmdJ" + cmdJ);
                                //计算总积分
                                cmdZ += cmdJ;
                                //更新积分
                                result += (",cmdZ" + cmdZ);
                                // 机器id 用户id 回收物品id 重量 时间 所得积分
                                // no     userId cmdO           cmdT 系统默认 cmdJ
                                // 将数据保存至垃圾回收表
                            }
                        }
                    }
                    result += ";";
                    if (isOk) {
                        //请求成功
                    } else {
                        //请求失败
                    }
                    //添加通讯日志
                    if ("A".equals(action)) {
                        pw.println(result + "\n");
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        System.out.println("请求：" + cmd);
                        System.out.println("响应：" + result);
                    } else if ("B".equals(action)) {
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        System.out.println("汇报：" + cmd);
                    }
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
