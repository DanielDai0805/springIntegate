package spring.event;

import java.util.EventListener;
import java.util.EventObject;

/**
 * Created by dc on 2015/7/1.
 */
public class MethodExecutionEvent extends EventObject  {

    private static final long serialVersionUID = -71960369269303337L;
    private String methodName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
