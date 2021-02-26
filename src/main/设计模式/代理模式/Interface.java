package 代理模式;

/**
 * @author zedd
 * @date 2021/2/25
 **/
public interface Interface {

    /**
     * 当你希望将额外的操作与“真实对象”做分离时
     * 代理可能会有所帮助，尤其是当你想要轻松地启用额外的操作时，反之亦然
     * （设计模式就是封装变更---所以你必须改变一些东西以证明模式的合理性）
     */

    void insertUser();

    void getUser(String id);
}
