package test;

import java.util.List;

import com.ctrip.platform.dal.dao.DalClient;
import com.ctrip.platform.dal.dao.DalClientFactory;
import com.ctrip.platform.dal.dao.DalHints;
import com.iteye.weimingtom.dal.GalleryGen;
import com.iteye.weimingtom.dal.GalleryGenDao;

public class Test {
	private static final String DATA_BASE = "apkver";

	private static DalClient client = null;
	private static GalleryGenDao dao = null;
	
	public static void main(String[] args) throws Exception {
		DalClientFactory.initClientFactory(); // load from class-path Dal.config
		DalClientFactory.warmUpConnections();
		client = DalClientFactory.getClient(DATA_BASE);
		dao = new GalleryGenDao();
		
		List<GalleryGen> list = dao.queryAll(new DalHints());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list:" + list.get(i).getTitle());
		}
	}

}
