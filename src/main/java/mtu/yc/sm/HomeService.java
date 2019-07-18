package mtu.yc.sm;

import com.nexacro17.xapi.data.PlatformData;

public interface HomeService {
	public PlatformData selectAllWarehouse();
	public PlatformData selectImportHistory();
	public PlatformData selectExportHistory();
	public PlatformData selectPaymentHistory();
	public PlatformData selectCollectHistory();
}
