package aop00;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private Internet internet;
    private static List<String> blackListedHost;

    //클래스가 로딩될때 생성되는 static block
    static {
        blackListedHost = new ArrayList<>();
        blackListedHost.add("www.hacker.com");
        blackListedHost.add("www.facebook.com");
        blackListedHost.add("www.instagram.com");
    }
    @Override
    public Status openConnection(String host) {
        if (blackListedHost.contains(host)) {
            return Status.BLACKLISTED;
        }
        if (internet == null) {
            this.internet = new MyInternet();
        }
        return internet.openConnection(host);
    }
}
