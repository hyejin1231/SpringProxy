package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{
    
    @Override
    public String operation() {
        log.info("실제 객체 호출");
        // 데이터 조회 시뮬레이션할 때 데이터 조회가 1초 걸린다고 생각하면 된다.
        sleep(1000);
        return "data";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
