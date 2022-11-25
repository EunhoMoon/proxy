package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {
    /**
     * proxy는 실제 객체와 그 모양이 같아야 하기 때문에 Subject 인터페이스를 구현해야 한다.
     * client가 proxy를 호출하면 proxy가 실제 객체를 호출해야 하기 때문에 proxy 내부에 실제 객체의 참조를 가지고 있어야 한다.
     */

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String opration() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.opration();
        }
        return cacheValue;
    }
}
