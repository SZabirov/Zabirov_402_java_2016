package ru.itis.inform;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
    private String s;

    private String who;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Hello(String str) {
        s = str;
    }

    public void sayHi() {
        System.out.println(s);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        Hello h = (Hello) ac.getBean("hello");
        System.out.println(h.getWho() + ":");
        h.sayHi();
    }
}
