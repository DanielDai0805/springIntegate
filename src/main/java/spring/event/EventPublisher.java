package spring.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dc on 2015/7/1.
 */
public class EventPublisher {
    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();
        publisher.addMethodExecutionListener(new SimpleMethodExecutionEventListener());
        publisher.methodToMonitor();
    }
    private List<MethodExecutionEventListener> listeners = new ArrayList<MethodExecutionEventListener>();

    public void methodToMonitor(){
        MethodExecutionEvent event2Publish = new MethodExecutionEvent(this,"methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN,event2Publish);
        //执行逻辑
        publishEvent(MethodExecutionStatus.END,event2Publish);
    }

    public void addMethodExecutionListener(MethodExecutionEventListener listener){
        listeners.add(listener);
    }

    public void removeListener(MethodExecutionEventListener listener){
        listeners.remove(listener);
    }

    public void removeAll(){
        listeners.clear();
    }

    private void publishEvent(MethodExecutionStatus status, MethodExecutionEvent event) {
        List<MethodExecutionEventListener> copyListeners = new ArrayList<MethodExecutionEventListener>(listeners);
        for (MethodExecutionEventListener listener : copyListeners) {
            if(MethodExecutionStatus.BEGIN.equals(status)){
                listener.onMethodBegin(event);
            }else if(MethodExecutionStatus.END.equals(status)){
                listener.onMethodEnd(event);
            }
        }

    }
}
