package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // 여기에서 알아서 타겟을 찾아 다음 실제를 호출해주고 뭐 그런다고 함!
        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("TimeProxy 종료 resultTime={}", resultTime);
        return result;
    }
}
