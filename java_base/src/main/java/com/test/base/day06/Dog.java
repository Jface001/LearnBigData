package com.test.base.day06;

/**
 * @Author: Jface
 * @Date: 2021/5/8 21:47
 * @Desc: 3. 已知猫和狗都有姓名和年龄, 且都有吃饭的方法, 不同的吃: 猫吃鱼, 狗吃肉. 它们都有跑步的方法, 而且仅仅是跑步.
 * 猫独有自己的抓老鼠(catchMouse)的功能, 狗独有自己的看门(lookHome)的功能. 请用所学, 模拟该知识.
 * 分析
 * 1.需要构建3个类,父类为Animal, 2个子类 Cat和Dog
 * 2.父类共同的成员
 * 属性: name  age
 * 行为: eat run
 * 3.独有的方法
 * Cat: eat(吃鱼)  catchMouse
 * Dog: eat(吃肉) lookHome
 */
// 1.继承Animal父类
public class Dog extends Animal {
    // 2.构造方法,空参和全参 alt +insert
// 空参
    public Dog() {
    }

    // 全参
    public Dog(String name, int age) {
        super(name, age);
    }


// 3.方法重载

    @Override
    public void eat() {
        System.out.println("吃肉");
    }

    // 4.独有成员方法设置
    public void lookHome() {
        System.out.println("看门");
    }
}
