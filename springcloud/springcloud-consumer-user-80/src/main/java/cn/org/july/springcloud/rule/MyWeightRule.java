package cn.org.july.springcloud.rule;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 服务提供者 按照 2：3：5的权重实现负载均衡策略
 *
 * @author goodboy
 * @date 20181231
 */
public class MyWeightRule implements IRule {

    private ILoadBalancer balancer = new BaseLoadBalancer();
    private static int number = 0;

    @Override
    public Server choose(Object o) {
        List<Server> allServers = balancer.getAllServers();
        number++;
        if (number <= 2) { //当 number=1,2时访问8001服务
            return findServer(allServers, 8001);
        } else if (number <= 5) { //当 number= 3,4,5时访问 8002服务
            return findServer(allServers, 8002);
        }
        if (number == 10) { //当 number = 10 时重置为 0 开始另一轮的轮询
            number = 0;
        }
        return findServer(allServers, 8003); //当number > 5 时访问8003服务
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.balancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.balancer;
    }

    private Server findServer(List<Server> allServers, int port) {
        for (Server server : allServers) {
            if (server.getPort() == port) {
                return server;
            }
        }
        return null;
    }

}
