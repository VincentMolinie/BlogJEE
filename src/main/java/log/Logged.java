package log;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Created by vince on 4/25/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE, ElementType.METHOD })
@InterceptorBinding
@Inherited
public @interface Logged {
}
