package ru.fccland.complaints.card.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 12.11.12
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
/**
 * Extends {@link CustomizableTraceInterceptor} to provide custom logging levels
 */
public class TraceInterceptor extends CustomizableTraceInterceptor {

    private static final long serialVersionUID = 287162721460370957L;

    protected static Logger log = Logger.getLogger("aop");

    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        if (ex != null) {
            log.debug(message, ex);
        } else {
            log.debug(message);
        }
    }

    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return true;
    }
}