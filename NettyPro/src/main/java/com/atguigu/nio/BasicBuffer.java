package com.atguigu.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {
        //举例说明buffer 的作用
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for(int i = 0; i < intBuffer.capacity(); i++) {
                intBuffer.put(i * 2);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

    }
}
