package JDBCintro.Merchant1.Service;

import JDBCintro.Merchant1.Entities.Merchant;
import JDBCintro.Merchant1.Repository.MerchantRepository;

public class MerchantService {
    MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }
    public void showAll(){
        merchantRepository.getAll ();
        for (Merchant i:merchantRepository.getAll ()){
            System.out.println (i );
        }

    }


}
