package com.hmcc.contact.util;


/**
 * <p>
 * APP登录日志表 前端控制器
 * </p>
 *
 *
 * *----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━by:coder-chenhao
 *
 *
 * @author chenhao
 * @since 2017-10-24
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*代码统计工具
 *
 * 扫描下列所有文件夹
 *
 *  并统计代码行数
 */
public class TestIO {

    static BufferedReader BR = null;
    static long Count = 0;

    public static void main(String[] args) throws IOException {
        Trvs(new File("G:/ha.dev/ideaworkspace/HmccContact/contact/src"));
        System.out.print(Count);
    }

    static void Trvs(File f) throws IOException {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            if (childs[i].isFile()) {
                BR = new BufferedReader(new FileReader(childs[i]));
                while (BR.readLine() != null) Count += 1;
            }
            else Trvs(childs[i]);
        }
    }

}