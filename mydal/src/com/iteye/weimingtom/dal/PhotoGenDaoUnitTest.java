package com.iteye.weimingtom.dal;

import java.util.List;
import java.sql.SQLException;

import org.junit.*;
import static org.junit.Assert.*;
import com.ctrip.platform.dal.dao.*;

/**
 * JUnit test of PhotoGenDao class.
 * Before run the unit test, you should initiate the test data and change all the asserts correspond to you case.
**/
public class PhotoGenDaoUnitTest {

	private static final String DATA_BASE = "apkver";

	private static DalClient client = null;
	private static PhotoGenDao dao = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/**
		* Initialize DalClientFactory.
		* The Dal.config can be specified from class-path or local file path.
		* One of follow three need to be enabled.
		**/
		DalClientFactory.initClientFactory(); // load from class-path Dal.config
		DalClientFactory.warmUpConnections();
		client = DalClientFactory.getClient(DATA_BASE);
		dao = new PhotoGenDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
//		To prepare test data, you can simply uncomment the following.
//		In case of DB and table shard, please revise the code to reflect shard
//		for(int i = 0; i < 10; i++) {
//			PhotoGen daoPojo = createPojo(i);
//
//			try {
//				dao.insert(new DalHints().enableIdentityInsert(), daoPojo);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	private PhotoGen createPojo(int index) {
		PhotoGen daoPojo = new PhotoGen();

		//daoPojo.setId(index);
		//daoPojo set not null field
		
		return daoPojo;
	}

	private void changePojo(PhotoGen daoPojo) {
		// Change a field to make pojo different with original one
	}
	
	private void changePojos(List<PhotoGen> daoPojos) {
		for(PhotoGen daoPojo: daoPojos)
			changePojo(daoPojo);
	}
	
	private void verifyPojo(PhotoGen daoPojo) {
		//assert changed value
	}
	
	private void verifyPojos(List<PhotoGen> daoPojos) {
		for(PhotoGen daoPojo: daoPojos)
			verifyPojo(daoPojo);
	}
	
	@After
	public void tearDown() throws Exception {
//		To clean up all test data
//		dao.delete(null, dao.queryAll(null));
	} 
	
	
	@Test
	public void testCount() throws Exception {
		int affected = dao.count(new DalHints());
		assertEquals(10, affected);
	}
	
	@Test
	public void testDelete1() throws Exception {
	    DalHints hints = new DalHints();
		PhotoGen daoPojo = createPojo(1);
		int affected = dao.delete(hints, daoPojo); 
		assertEquals(1, affected);
	}
	
	@Test
	public void testDelete2() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(null);
		int[] affected = dao.delete(hints, daoPojos);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1},  affected);
	}
	
	@Test
	public void testBatchDelete() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(null);
		int[] affected = dao.batchDelete(hints, daoPojos);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1},  affected);
	}
	
	@Test
	public void testQueryAll() throws Exception {
		List<PhotoGen> list = dao.queryAll(new DalHints());
		assertEquals(10, list.size());
	}
	
	@Test
	public void testInsert1() throws Exception {
		DalHints hints = new DalHints();
		PhotoGen daoPojo = createPojo(1);
		int affected = dao.insert(hints, daoPojo);
		assertEquals(1, affected);
	}
	
	@Test
	public void testInsert2() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		int[] affected = dao.insert(hints, daoPojos);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1},  affected);
	}
	
	@Test
	public void testInsert3() throws Exception {
		DalHints hints = new DalHints();
		KeyHolder keyHolder = new KeyHolder();
		PhotoGen daoPojo = createPojo(1);
		int affected = dao.insert(hints, keyHolder, daoPojo);
		assertEquals(1, affected);
		assertEquals(1, keyHolder.size());
	}
	
	@Test
	public void testInsert4() throws Exception {
		DalHints hints = new DalHints();
		KeyHolder keyHolder = new KeyHolder();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		int[] affected = dao.insert(hints, keyHolder, daoPojos);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1},  affected);
		assertEquals(10, keyHolder.size());
	}
	
	@Test
	public void testInsert5() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		int[] affected = dao.batchInsert(hints, daoPojos);
	}
	
	@Test
	public void testCombinedInsert1() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		int affected = dao.combinedInsert(hints, daoPojos);
		assertEquals(10, affected);
	}
	
	@Test
	public void testCombinedInsert2() throws Exception {
		DalHints hints = new DalHints();
		KeyHolder keyHolder = new KeyHolder();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		int affected = dao.combinedInsert(hints, keyHolder, daoPojos);
		assertEquals(10, keyHolder.size());
	}
	
	@Test
	public void testQueryAllByPage() throws Exception {
		DalHints hints = new DalHints();
		int pageSize = 100;
		int pageNo = 1;
		List<PhotoGen> list = dao.queryAllByPage(pageNo, pageSize, hints);
		assertEquals(10, list.size());
	}
	
	@Test
	public void testQueryByPk1() throws Exception {
		Number id = 1;
		DalHints hints = new DalHints();
		PhotoGen affected = dao.queryByPk(id, hints);
		assertNotNull(affected);
	}
	
	@Test
	public void testQueryByPk2() throws Exception {
		PhotoGen pk = createPojo(1);
		DalHints hints = new DalHints();
		PhotoGen affected = dao.queryByPk(pk, hints);
		assertNotNull(affected);
	}
	
	@Test
	public void testUpdate1() throws Exception {
		DalHints hints = new DalHints();
		PhotoGen daoPojo = dao.queryByPk(createPojo(1), hints);
		changePojo(daoPojo);
		int affected = dao.update(hints, daoPojo);
		assertEquals(1, affected);
		daoPojo = dao.queryByPk(createPojo(1), null);
		verifyPojo(daoPojo);
	}
	
	@Test
	public void testUpdate2() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		changePojos(daoPojos);
		int[] affected = dao.update(hints, daoPojos);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1},  affected);
		verifyPojos(dao.queryAll(new DalHints()));
	}
	
	@Test
	public void testBatchUpdate() throws Exception {
		DalHints hints = new DalHints();
		List<PhotoGen> daoPojos = dao.queryAll(new DalHints());
		changePojos(daoPojos);
		int[] affected = dao.batchUpdate(hints, daoPojos);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1},  affected);
		verifyPojos(dao.queryAll(new DalHints()));
	}

}
