package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.CheckSettleVO;
import vo.ExtractSettleVO;
import vo.InsertSettleVO;
import vo.Settle_collectVO;
import vo.Settle_paymentVO;
import vo.Settle_productVO;

@Component
public class SettleDAOImpl implements SettleDAO {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";

	@Override
	public int checkSettle(CheckSettleVO check) {
		return session.selectOne(namespace + ".checkSettle", check);
	}

	@Override
	public List<Settle_productVO> selectNonSettleProduct() {
		return session.selectList(namespace + ".selectNonSettleProduct"); 
	}

	@Override
	public List<Settle_paymentVO> selectNonSettlePayment() {
		return session.selectList(namespace + ".selectNonSettlePayment");
	}

	@Override
	public List<Settle_collectVO> selectNonSettleCollect() {
		return session.selectList(namespace + ".selectNonSettleCollect");
	}

	@Override
	public int insertSettleProduct(Settle_productVO spData) {
		return session.insert(namespace + ".insertSettleProudct", spData);
	}

	@Override
	public int insertSettlePayment(Settle_paymentVO spayData) {
		return session.insert(namespace + ".insertSettlePayment", spayData);
	}

	@Override
	public int insertSettleCollect(Settle_collectVO scolData) {
		return session.insert(namespace + ".insertSettleCollect", scolData);
	}
	
	@Override
	public int updateSettleProduct(Settle_productVO spData) {
		return session.update(namespace + ".updateSettleProduct", spData);
	}

	@Override
	public int updateSettlePayment(Settle_paymentVO spayData) {
		return session.update(namespace + ".updateSettlePayment", spayData);
	}

	@Override
	public int updateSettleCollect(Settle_collectVO scolData) {
		return session.update(namespace + ".updateSettleCollect", scolData);
	}

	@Override
	public List<Settle_productVO> selectAllSettleProduct() {
		return session.selectList(namespace + ".selectAllSettleProduct");
	}

	@Override
	public List<Settle_paymentVO> selectAllSettlePayment() {
		return session.selectList(namespace + ".selectAllSettlePayment");
	}

	@Override
	public List<Settle_collectVO> selectAllSettleCollect() {
		return session.selectList(namespace + ".selectAllSettleCollect");
	}

	@Override
	public int selectTotalPay(ExtractSettleVO exData) {
		if (session.selectOne(namespace + ".selectSettlePay", exData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettlePay", exData);
	}

	@Override
	public int selectTotalNonPay(ExtractSettleVO exData) {
		if (session.selectOne(namespace + ".selectSettleNonPay", exData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleNonPay", exData);
	}

	@Override
	public int selectTotalCollect(ExtractSettleVO exData) {
		if (session.selectOne(namespace + ".selectSettleCollect", exData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleCollect", exData);
	}

	@Override
	public int selectTotalNonCollect(ExtractSettleVO exData) {
		if (session.selectOne(namespace + ".selectSettleNonCollect", exData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleNonCollect", exData);
	}

	@Override
	public int selectTotalImport(ExtractSettleVO exData) {
		if (session.selectOne(namespace + ".selectSettleImport", exData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleImport", exData);
	}

	@Override
	public int selectTotalExport(ExtractSettleVO exData) {
		if (session.selectOne(namespace + ".selectSettleExport", exData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleExport", exData);
	}

	@Override
	public int checkSettleCancel(CheckSettleVO check) {
		return session.selectOne(namespace + ".checkSettleCancel", check);
	}

	@Override
	public List<Settle_productVO> selectCancelSettleProduct(CheckSettleVO check) {
		return session.selectList(namespace + ".selectCancelSettleProduct", check);
	}

	@Override
	public List<Settle_paymentVO> selectCancelSettlePayment(CheckSettleVO check) {
		return session.selectList(namespace + ".selectCancelSettlePayment", check);
	}

	@Override
	public List<Settle_collectVO> selectCancelSettleCollect(CheckSettleVO check) {
		return session.selectList(namespace + ".selectCancelSettleCollect", check);
	}

	@Override
	public int deleteSettleProduct(Settle_productVO spData) {
		return session.delete(namespace + ".deleteSettleProduct", spData);
	}

	@Override
	public int deleteSettlePayment(Settle_paymentVO spayData) {
		return session.delete(namespace + ".deleteSettlePayment", spayData);
	}

	@Override
	public int deleteSettleCollect(Settle_collectVO scolData) {
		return session.delete(namespace + ".deleteSettleCollect", scolData);
	}

	@Override
	public InsertSettleVO lastSettleDay() {
		return session.selectOne(namespace + ".selectLastSettleYearMonth");
	}

	@Override
	public int selectSettleTotalAmount(InsertSettleVO isData) {
		if (session.selectOne(namespace + ".selectSettleTotalAmount", isData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleTotalAmount", isData);
	}

	@Override
	public int selectSettleTotalPayMoney(InsertSettleVO isData) {
		if (session.selectOne(namespace + ".selectSettleTotalPayMoney", isData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleTotalPayMoney", isData);
	}

	@Override
	public int selectSettleTotalCollectMoney(InsertSettleVO isData) {
		if (session.selectOne(namespace + ".selectSettleTotalCollectMoney", isData) == null) return 0;
		else return session.selectOne(namespace + ".selectSettleTotalCollectMoney", isData);
	}
}