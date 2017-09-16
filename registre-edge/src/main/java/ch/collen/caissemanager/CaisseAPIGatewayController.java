package ch.collen.caissemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by cyril on 14/09/17.
 */
@RestController
public class CaisseAPIGatewayController {

    //@Autowired
    //@LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping(path = "name")
    public Collection<String> getCaisseNames() {
        ParameterizedTypeReference<Resources<CaisseNameWithID>> ptr = new ParameterizedTypeReference<Resources<CaisseNameWithID>>() {};
        ResponseEntity<Resources<CaisseNameWithID>> responseEntity = restTemplate.exchange("http://registre-caisse/caisse", HttpMethod.GET, null, ptr);
        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(CaisseNameWithID::getName)
                .collect(Collectors.toList());
    }

    class CaisseNameWithID {
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
