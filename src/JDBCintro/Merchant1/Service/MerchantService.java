package JDBCintro.Merchant1.Service;

import JDBCintro.Merchant1.Entities.Merchant;
import JDBCintro.Merchant1.Entities.Payment;
import JDBCintro.Merchant1.Repository.MerchantRepository;

import java.util.List;

public class MerchantService {
    MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public void showAll() {
        for (Merchant i : this.getAll ( )) {
            System.out.println (i);
        }
    }
    public List<Merchant> getAll() {
        return merchantRepository.getAll ( );
    }

    public Merchant getById(int id) {
        Merchant merchant1 = merchantRepository.getById (id);
        return merchant1;
    }

//    public double totalSumPaidByMerchantId2(int id){
//        double sum1=merchantRepository.getTotalSumPaidByMerchantId2 (id);
//    return sum1;
//    }


}
