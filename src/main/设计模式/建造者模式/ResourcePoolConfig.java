package 建造者模式;


import org.apache.commons.lang3.StringUtils;

/**
 * @author zedd
 * @date 2021/2/7
 **/
public class ResourcePoolConfig {

    /**
     * 如果存在下面情况中的任意一种，我们就要考虑使用建造者模式了
     */
    private String name; //必填
    private int maxTotal; //非必填 默认值8
    private int maxIdle;  //非必填 默认值8
    private int minIdle;  //非必填 默认值0

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

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

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {

            /*实际上，使用建造者模式创建对象，还能避免对象存在无效状态。我再举个例子解释一下。
            比如我们定义了一个长方形类，如果不使用建造者模式，采用先创建后 set 的方式，那就会
            导致在第一个 set 之后，对象处于无效状态。具体代码如下所示：*/
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
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

// 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(4)
                .build();

        System.out.println(config.maxIdle);
    }
}
