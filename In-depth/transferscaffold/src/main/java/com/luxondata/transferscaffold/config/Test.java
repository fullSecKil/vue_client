package com.luxondata.transferscaffold.config;

import java.io.IOException;

/**
 * Test
 *
 * @author dusk
 * @since 05/11/2019
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
//        Process child = Runtime.getRuntime().exec("cmd /c start D:\\demo.bat");
        Process child = Runtime.getRuntime().exec("D:\\webservicefiles\\yzjgkgz8\\start.bat");
        child.waitFor();
        int i = child.exitValue();
        if (i == 0) {
            System.out.println("执行完成.");
        } else {
            System.out.println("执行失败.");
        }
        child.destroy();
    }
}
