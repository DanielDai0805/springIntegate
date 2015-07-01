package spring.event;

import java.util.EventListener;

/**
 * 自定义事件监听器
 * Created by dc on 2015/7/1.
 */
public interface MethodExecutionEventListener extends EventListener {

    /**
     * 处理方法开始执行的时候发布的MethodExecutionEvent事件
     * @param event
     */
    void onMethodBegin(MethodExecutionEvent event);

    /**
     * 处理方法执行将结束时候发布的MethodExecutionEvent事件
     * @param event
     */
    void onMethodEnd(MethodExecutionEvent event);
}
