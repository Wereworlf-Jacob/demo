package com.example.demo.design.pattern.A11proxy.virtual;

import javax.swing.*;

/**
 * @auth Jacob
 * @date 2023/2/28 14:32
 */
public class ImageProxyTestDrive {

    public static void main(String[] args) {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() {
        Icon icon = new ImageProxy();
    }
}
