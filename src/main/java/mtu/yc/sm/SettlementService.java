package mtu.yc.sm;

import com.nexacro17.xapi.data.PlatformData;

public interface SettlementService {
	public PlatformData selectSettlementData();
	public PlatformData settlement(int year, int month);
	public PlatformData cancelSettlement(int year, int month);
}
