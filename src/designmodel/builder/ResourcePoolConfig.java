package designmodel.builder;


/**
 *  构造者模式。
 *
 *  适合创建的类，构造器参数过多，有些字段是必要的，有些事非必要的。它们之间还存在依赖关系，大小比较等。
 *
 *  1）如果直接new 对象，构造参数太多，字段有关系，不能保证每个参数都正确setter进去。
 *
 *
 *  如何实践构造者模式呢？
 *
 *  1， 创建要被构建的类，添加属性定义， 创建getter, 不要定义setter。
 *  2， 创建构建者Builder 类， 是静态内部类。 public static class。字段和外部类差不多。
 *  3, Builder 类 setter， 参数校验。
 *  4， builder 方法。 验证各个参数之间的关系，放回被构建的类对象  new ResourcePool(this)
 *
 */

public class ResourcePoolConfig {

    private String name;       // 名字
    private int maxTotal;      // 最大总数
    private int maxIdle;       // 最大数量
    private int minIdle;       // 最小数量

    /**
     * 私有化构造器，为了不让外界直接通过 new 的方式生成对象。
     *
     * 传递一个构建者对象进去，设置当前类的属性
     * @param builder
     */
    private ResourcePoolConfig(Builder builder){
        // 外部类可以通过一个内部类实例，可以访问内部类的属性。
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    // getter 对外暴露属性， 同时隐含setter 接口。

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    /**
     *  静态内部类。Builder 类。
     */
    public static class Builder{

        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;


        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        /**
         *  内部类的普通方法。 主要工作是 逻辑校验。 包括【必填校验，依赖关系校验，约束条件校验等】
         *
         *  最后放回被创建者的对象。 调用外部类的  new ResourcePoolConfig(this)。
         * @return
         */

        // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
        public ResourcePoolConfig build() {

            if ( name == null || name.length() == 0 ) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);  // 【静态内部类可以调用】
        }


        /**
         *  构建者类里边的 setter 最要做 单字段的属性校验。 + setter 原来功能。
         */


        public Builder setName(String name) {
            if (name == null || name.length() == 0 ) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }


        public Builder setMaxIdle(int maxIdle){
            if ( maxIdle < 0 ){
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }

    }


    public static void main(String[] args) {


        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("resourcePoolConfig")
                .setMinIdle(2)
                .setMaxIdle(4)
                .build();

    }

}
