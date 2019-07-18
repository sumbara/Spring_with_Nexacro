package dao;

import java.util.List;

import vo.CheckSettleVO;
import vo.ExtractSettleVO;
import vo.InsertSettleVO;
import vo.Settle_collectVO;
import vo.Settle_paymentVO;
import vo.Settle_productVO;

public interface SettleDAO {
	public int checkSettle(CheckSettleVO check);
	public List<Settle_productVO> selectNonSettleProduct();
	public List<Settle_paymentVO> selectNonSettlePayment();
	public List<Settle_collectVO> selectNonSettleCollect();
	public int insertSettleProduct(Settle_productVO spData);
	public int insertSettlePayment(Settle_paymentVO spayData);
	public int insertSettleCollect(Settle_collectVO scolData);
	public int updateSettleProduct(Settle_productVO spData);
	public int updateSettlePayment(Settle_paymentVO spayData);
	public int updateSettleCollect(Settle_collectVO scolData);
	public List<Settle_productVO> selectAllSettleProduct();
	public List<Settle_paymentVO> selectAllSettlePayment();
	public List<Settle_collectVO> selectAllSettleCollect();
	public int selectTotalPay(ExtractSettleVO exData);
	public int selectTotalNonPay(ExtractSettleVO exData);
	public int selectTotalCollect(ExtractSettleVO exData);
	public int selectTotalNonCollect(ExtractSettleVO exData);
	public int selectTotalImport(ExtractSettleVO exData);
	public int selectTotalExport(ExtractSettleVO exData);
	public int checkSettleCancel(CheckSettleVO check);
	public List<Settle_productVO> selectCancelSettleProduct(CheckSettleVO check);
	public List<Settle_paymentVO> selectCancelSettlePayment(CheckSettleVO check);
	public List<Settle_collectVO> selectCancelSettleCollect(CheckSettleVO check);
	public int deleteSettleProduct(Settle_productVO spData);
	public int deleteSettlePayment(Settle_paymentVO spayData);
	public int deleteSettleCollect(Settle_collectVO scolData);
	public InsertSettleVO lastSettleDay();
	public int selectSettleTotalAmount(InsertSettleVO isData);
	public int selectSettleTotalPayMoney(InsertSettleVO isData);
	public int selectSettleTotalCollectMoney(InsertSettleVO isData);
}
