package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

// 인터페이스 없이 구체클래스만 만든 경우
@Slf4j
public class ConcreteService {

    public void call() {
        log.info("ConcreteService 호출");
    }

}
