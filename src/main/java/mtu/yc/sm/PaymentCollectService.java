package mtu.yc.sm;

import com.nexacro17.xapi.data.PlatformData;

import vo.Collect_historyVO;
import vo.Payment_historyVO;

public interface PaymentCollectService {
	public PlatformData selectPaymentCustomer();
	public PlatformData payment(Payment_historyVO paymentData);
	public PlatformData selectCollectCustomer();
	public PlatformData collect(Collect_historyVO collectData);
	public PlatformData updatePaymentHistory(Payment_historyVO paymentData, int diff);
	public PlatformData deletePaymentHistory(Payment_historyVO paymentData);
	public PlatformData updateCollectHistory(Collect_historyVO collectData, int diff);
	public PlatformData deleteCollectHistory(Collect_historyVO collectData);
}
