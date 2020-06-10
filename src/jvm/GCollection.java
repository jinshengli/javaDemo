package jvm;


/**
 *
 * 分代垃圾收集算法
 *
 * 1. 标记清除
 * 2. 标记-整理
 *
 * 3. 复制算法
 *
 *
 * 新生代收集器：
 *
 * 1. Serial 收集器
 *    单线程进行垃圾收集，stop the world. 对于client模式下的虚拟机是不错的选择。
 *
 * 2. ParNew 收集器
 *    其实是多线程版本的Serial收集器。
 *
 *     可以可CMS配合使用，是service 下的首选。
 *
 * 3 Parallel Scavenge 收集器
 *    和其他收集器关注点不同，它的目标是到达一个可控制的吞吐量。
 *
 * 老年代收集器：
 *
 * 1. Serial Old 收集器
 *
 * 2. Parallel Old
 *
 * 3. cms
 *
 * 4. g1
 *
 *
 *
 *
 */

public class GCollection {
}
