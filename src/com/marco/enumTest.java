package com.marco;
import java.lang.Enum;

enum signal{
    GREEN, RED, YELLOW
}
public class enumTest {
    signal color = signal.GREEN;

    public void test() {
        switch (color) {
            case GREEN:
                System.out.println(color.getClass());
        }
    }

}
