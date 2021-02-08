package 枚举类;

/**
 * @author zedd
 * @date 2021
 * 枚举的最佳应用：Switch
 **/
public class Demo {

    NameEnum nameEnum;

    public Demo(NameEnum nameEnum){
        this.nameEnum = nameEnum;
    }

    public void judgeTheCriminal(){
        switch (nameEnum){ //switch与enum的组合
            case NAME:
                System.out.println("this people's name is:"+nameEnum);
                break;
            case AGE:
                System.out.println("this man's age:"+nameEnum);
                break;
            case SEX:
                System.out.println("this is :"+nameEnum);
        }
    }

    public static void main(String[] args) {
        Demo demo=new Demo(NameEnum.NAME);
//        demo::judgeTheCriminal;
        Demo demo1 = new Demo(NameEnum.AGE);
        Demo demo2 = new Demo(NameEnum.SEX);
        demo.judgeTheCriminal();
        demo1.judgeTheCriminal();
        demo2.judgeTheCriminal();
    }
}
