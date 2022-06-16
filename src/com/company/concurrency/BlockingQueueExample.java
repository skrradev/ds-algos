package com.company.concurrency;

import com.company.leetcode.linkedlist.ThisExample;

public class BlockingQueueExample {

    private final ThisExample thread;

    public BlockingQueueExample(ThisExample thread) {
        this.thread = thread;
    }


    public static void main(String[] args) throws InterruptedException {

        ThisExample thisExample = new ThisExample() {{
            System.out.println(this.getClass());
        }};


        System.out.println(thisExample.getThis().getClass());

        var hello = new BlockingQueueExample(thisExample);

        System.out.println(hello.getClass());
        System.out.println(hello.thread.getThis().getClass());


    }
}
