package 建造者模式;

/**
 * @author zedd
 * @date 2021/2/7
 * 当 isRef 为 true 的时候，arg 表示 String 类型的
 * refBeanId，type 不需要设置；当 isRef 为 false 的时候，arg、type 都需要设置。
 **/
public class ConstructorArg {


    private boolean isRef;
    private Class type;
    private Object arg;
    // TODO: 待完善...

    ConstructorArg(Builder builder){

        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public boolean isRef() {
        return isRef;
    }

    public Class getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }

    public static class Builder{
        private static final String DEFAULT_SET_ARG = "refBeanId";
        private static final Class DEFAULT_SET_CLASS = Builder.class;
        private boolean isRef;
        private Class type;
        private Object arg;

        private String beanId = DEFAULT_SET_ARG;
        private Class defaultClazz = DEFAULT_SET_CLASS;

        public ConstructorArg build(){
            // isRef 为 true 的时候，arg 表示 String类型的 refBeanId，type 不需要设置
            if (isRef == true ){
                this.arg = beanId;
                this.type = defaultClazz;
            }
            //当 isRef 为 false 的时候，arg、type 都需要设置。
            if (isRef == false){
                if (arg == null || type == null){
                    throw new IllegalArgumentException("请设置arg和type的参数");
                }
            }
            /**
             * 1.this 关键字只用在一些必须显式使用当前对象引用的特殊场合
             * 例如，用在 return 语句中返回对当前对象的引用。
             * 2.通常当你说 this，意味着"这个对象"或"当前对象"，它本身生成对当前对象的引用。
             * 在一个构造器中，当你给 this 一个参数列表时，它是另一层意思。
             * 它通过最直接的方式显式地调用匹配参数列表的构造器
             * */
            return new ConstructorArg(this);
        }

        public Builder setRef(Boolean ref){
            if (ref == null){
                throw new IllegalArgumentException("ref不能为空....");
            }
            this.isRef = ref;
            return this;
        }

        public Builder setClazz(Class clazz){
            this.type = clazz;
            return this;
        }
        public Builder setArgzz(Object arg){
            this.arg = arg;
            return this;
        }
    }

    public static void main(String[] args) {
        ConstructorArg constructorArg = new ConstructorArg.Builder()
                .setRef(true)
                .build();

        System.out.println(constructorArg.type);
    }
}
