package me.codeboy.android.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import me.codeboy.common.base.io.util.CBFileUtil;

/**
 * root命令
 *
 * @author yuedong.lyd
 */
public class CBRoot {

    private Process process;

    /**
     * 初始化进程
     */
    public CBRoot() {
        if (process == null) try {
            process = Runtime.getRuntime().exec("su");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取系统文件内容
     */
    public String catSystemFile(String filePath) {
        OutputStream out = process.getOutputStream();
        String cmd = "cat " + filePath + "\n";
        try {
            out.write(cmd.getBytes());
            out.flush();
            InputStream in = process.getInputStream();
            String res = CBFileUtil.getFileContent(in);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭输出流
     */
    public void close() {
        if (process != null) try {
            process.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}