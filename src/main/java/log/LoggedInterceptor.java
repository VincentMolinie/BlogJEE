package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by vince on 4/24/15.
 */
@Interceptor @Logged
public class LoggedInterceptor {
    private final Logger LOG = LogManager.getLogger(LoggedInterceptor.class);

    @AroundInvoke
    public Object invoke(InvocationContext context)
            throws Exception {
        LOG.info("Logged enter method access: {}",  context.getMethod().getName());
        final Object result = context.proceed();
        LOG.info("Logged exit method access: {}", context.getMethod().getName());
        return result;
    }
}
