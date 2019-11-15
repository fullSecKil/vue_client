package com.luxondata.transferscaffold.utils;

import java.io.IOException;

/**
 * ProcessUtils
 *
 * @author dusk
 * @since 06/11/2019
 */
public class ProcessUtils {

    public static void cmdStart(String path) {
        try {
            Process exec = Runtime.getRuntime().exec(path);
            exec.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
