package hello.proxy.config.v1_proxy.concreteproxy;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;


    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null); // 부모의 생성자를 호출해야하는데 지금은 안쓸거기 때문에 null을 입력해줬다고 한다..!
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");

            // target 호출
            target.orderItem(itemId);

            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
