package com.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws Exception {
        TankFrame tf = new TankFrame();

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
