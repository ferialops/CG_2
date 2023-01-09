package com.example.demo;

import javafx.scene.canvas.GraphicsContext;

public class MyEllipse {

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

        private int x;
        private int y;
        private int width;
        private int height;

    public MyEllipse(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public void draw(GraphicsContext gc) {
            int x0 = x + width / 2;
            int y0 = y + height / 2;
            int a = width / 2;
            int b = height / 2;

            int x = 0;
            int y = b;
            int a2 = a * a;
            int b2 = b * b;
            int err = b2 - a2 * b + a2 / 4;

            while (y >= 0) {
                drawPixel(gc, x0 + x, y0 + y);
                drawPixel(gc, x0 - x, y0 + y);
                drawPixel(gc, x0 + x, y0 - y);
                drawPixel(gc, x0 - x, y0 - y);
                int e2 = 2 * err;
                if (e2 < a2) {
                    x++;
                    err += a2 * (2 * x + 1);
                }
                if (e2 > b2) {
                    y--;
                    err -= b2 * (2 * y - 1);
                }
            }

            while (x <= a) {
                drawPixel(gc, x0 + x, y0 + y);
                drawPixel(gc, x0 - x, y0 + y);
                drawPixel(gc, x0 + x, y0 - y);
                drawPixel(gc, x0 - x, y0 - y);
                x++;
                err += b2 * (2 * x + 1);
            }
        }

        private void drawPixel(GraphicsContext gc, int x, int y) {
            gc.fillOval(x, y, 1, 1);
        }
}
