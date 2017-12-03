package zhangshengqin.bwie.com.zhouyi.utils;

/**
 * Created by 额头发 on 2017/12/3.
 */

public class Utilss {
    private static volatile Utilss instence;

    private Utilss() {

    }

    public static Utilss getInstence() {
        if (null == instence) {
            synchronized (Utilss.class) {
                if (instence == null) {
                    instence = new Utilss();
                }
            }

        }
        return instence;

    }
}
