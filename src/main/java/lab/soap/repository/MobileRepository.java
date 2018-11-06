package lab.soap.repository;

import lab.soap.server.Mobile;
import lab.soap.server.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository class Component
 */
@Component
public class MobileRepository {
    private static final List<Mobile> mobiles = new ArrayList<>();

    public MobileRepository() {
        dataInitialisation();
    }

    private void dataInitialisation(){

        Mobile mobileContractRedS = new Mobile();
        mobileContractRedS.setName("Red S");
        mobileContractRedS.setInternet(2);
        mobileContractRedS.setMinutes(160);
        mobileContractRedS.setPrice(120);
        mobileContractRedS.setType(Type.CONTRACT);
        mobiles.add(mobileContractRedS);

        Mobile mobileContractRedM = new Mobile();
        mobileContractRedM.setName("Red M");
        mobileContractRedM.setInternet(4);
        mobileContractRedM.setMinutes(300);
        mobileContractRedM.setPrice(160);
        mobileContractRedM.setType(Type.CONTRACT);
        mobiles.add(mobileContractRedM);

        Mobile mobileContractRedL = new Mobile();
        mobileContractRedL.setName("Red L");
        mobileContractRedL.setInternet(100);
        mobileContractRedL.setMinutes(4000);
        mobileContractRedL.setPrice(260);
        mobileContractRedL.setType(Type.CONTRACT);
        mobiles.add(mobileContractRedL);

        Mobile mobilePrePaidNetStart = new Mobile();
        mobilePrePaidNetStart.setName("Net Start");
        mobilePrePaidNetStart.setInternet(2);
        mobilePrePaidNetStart.setMinutes(160);
        mobilePrePaidNetStart.setPrice(120);
        mobilePrePaidNetStart.setType(Type.PRE_PAID);
        mobiles.add(mobilePrePaidNetStart);

        Mobile mobilePrePaidNetPro = new Mobile();
        mobilePrePaidNetPro.setName("Net Pro");
        mobilePrePaidNetPro.setInternet(4);
        mobilePrePaidNetPro.setMinutes(300);
        mobilePrePaidNetPro.setPrice(160);
        mobilePrePaidNetPro.setType(Type.PRE_PAID);
        mobiles.add(mobilePrePaidNetPro);

        Mobile mobilePrePaidNetUnLim = new Mobile();
        mobilePrePaidNetUnLim.setName("Net UnLim");
        mobilePrePaidNetUnLim.setInternet(100);
        mobilePrePaidNetUnLim.setMinutes(4000);
        mobilePrePaidNetUnLim.setPrice(260);
        mobilePrePaidNetUnLim.setType(Type.PRE_PAID);
        mobiles.add(mobilePrePaidNetUnLim);

    }

    public List<Mobile> findMobileTariffs(String name){
        if (name == null){
            return new ArrayList<>();
        }
        return mobiles.stream()
                .filter(tariff -> tariff.getName().toLowerCase().contains(name.trim().toLowerCase()))
                .collect(Collectors.toList());
    }

}
