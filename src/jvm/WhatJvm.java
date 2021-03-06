package jvm;

/**
 *  jvm虚拟机在运行java程序的时候，会将内存划分成【5】块区域，线程间隔离，线程共享
 *
 *  线程隔离数据区：
 *  1. 程序计数器：当前线程所执行字节码的行号指示器。
 *
 *  2. java虚拟机栈，每个方法被调用的同时创建一个栈帧。调用时入栈，方法执行结束出栈。
 *
 *
 *  3. 本地方法栈： 调用native本地方法时使用。
 *
 *  线程共享数据区：
 *
 *  1. 堆： 存放对象实例：
 *
 *      划分： 新生代，老年代。
 *
 *      eden, from survivor, to survivor
 *
 *    规范规定：物理上可以是不连续的，但是逻辑上是连续的。
 *
 *  2. 方法区：它用来存储已经被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码
 *
 *
 *
 *
 */

public class WhatJvm {
}
