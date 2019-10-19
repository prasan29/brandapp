package com.brandapp.util;

import android.util.Log;

/**
 * Util class for Logging and debugging.
 */
public class LogUtils {
    /**
     * Private constructor for SingleTon LogUtils.
     */
    private LogUtils() {
    }

    /**
     * Method to log the error log.
     *
     * @param tag - String tag.
     * @param msg - String message.
     */
    public static void logError(String tag, String msg) {
        Log.e(tag, msg);
    }

    /**
     * Method to log the verbose log.
     *
     * @param tag - String tag.
     * @param msg - String message.
     */
    public static void logVerbose(String tag, String msg) {
        Log.v(tag, msg);
    }

    /**
     * Method to log the debug log.
     *
     * @param tag - String tag.
     * @param msg - String message.
     */
    public static void logDebug(String tag, String msg) {
        Log.d(tag, msg);
    }

    /**
     * Method to log the warning log.
     *
     * @param tag - String tag.
     * @param msg - String message.
     */
    public static void logWarning(String tag, String msg) {
        Log.w(tag, msg);
    }
}
