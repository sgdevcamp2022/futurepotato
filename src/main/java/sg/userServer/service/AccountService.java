package sg.userServer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import sg.userServer.domain.Account;

import sg.userServer.repository.AccountRepository;

@Service
@Slf4j
public class AccountService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    AccountRepository accountRepository;
    public void saveAccount(Account account){
        accountRepository.save(account);
    }

//    public List getServices(){
//        List<String> services = new ArrayList<String>();
//
//        List<String> serviceNames = discoveryClient.getServices();
//        for(String serviceName : serviceNames) {
//            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
//            for(ServiceInstance instance : serviceInstances) {
//                services.add(String.format("%s:%s", serviceName, instance.getUri()));
//            }
//        }
//
//        return services;
//    }

}
