import com.bootcampmck.model.Addresses;
import com.bootcampmck.service.ViaCepService;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {

        ViaCepService viaCepService = new ViaCepService();

        try {

            Addresses addresses = viaCepService.getAddresses("03170050");
            System.out.println(addresses.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
