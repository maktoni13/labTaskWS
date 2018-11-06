package lab.soap.ws;

import lab.soap.repository.MobileRepository;
import lab.soap.server.GetMobileTariffRequest;
import lab.soap.server.GetMobileTariffResponse;
import lab.soap.server.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class MobileEndpoint {
    private static final String NAMESPACE_URI = "http://tutorialspoint/schemas";
    private MobileRepository mobileRepository;

    @Autowired
    public MobileEndpoint(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMobileTariffRequest")
    @ResponsePayload
    public GetMobileTariffResponse getMobile(@RequestPayload GetMobileTariffRequest request){
        List<Mobile> mobileList = mobileRepository.findMobileTariffs(request.getName());
        GetMobileTariffResponse response = new GetMobileTariffResponse();
        List<Mobile> resultMobileList = response.getMobile();
        resultMobileList.addAll(mobileList);
        return response;
    }
}
