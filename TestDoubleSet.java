package com.aspiration.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestDoubleSet {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddingMember() {
		
		DoubleSet doubleSet = new DoubleSet();
		
		doubleSet.addMember(1);
		doubleSet.addMember(1);
		doubleSet.addMember(1);
		doubleSet.addMember(2);
		doubleSet.addMember(-3);
		
		Assert.assertEquals(doubleSet.getMembers().size() ,3);
		Assert.assertTrue(doubleSet.getMembers().get(1) == 2);
		
	}
	@Test
	public void testAddingNullMember() {
		
		DoubleSet doubleSet1 = null;
		DoubleSet doubleSet2 = null;
		
		DoubleSet sum = DoubleSetUtil.addMembers(doubleSet1, doubleSet2);
		
		Assert.assertEquals(sum.getMembers().size() ,0);
		
		doubleSet1 = new DoubleSet();
		doubleSet2 = new DoubleSet();
		
		sum = DoubleSetUtil.addMembers(doubleSet1, doubleSet2);
		Assert.assertEquals(sum.getMembers().size() ,0);
	}

	@Test
	public void testSubtractingNullMembers() {
		
		DoubleSet doubleSet1 = null;
		DoubleSet doubleSet2 = null;
		
		DoubleSet minus = DoubleSetUtil.subtractMembers(doubleSet1, doubleSet2);
		
		Assert.assertEquals(minus.getMembers().size() ,0);
		
		doubleSet1 = new DoubleSet();
		doubleSet2 = new DoubleSet();
		
		minus = DoubleSetUtil.subtractMembers(doubleSet1, doubleSet2);
		Assert.assertEquals(minus.getMembers().size() ,0);
	}
	
	@Test
	public void testAddingTwoMembersWithSameSize() {
		
		// same size , same keys 
		DoubleSet doubleSet1 = new DoubleSet();
		
		//{ {1:2} , {2:1} , {-3,1} } 
		doubleSet1.addMember(1);
		doubleSet1.addMember(1);
		doubleSet1.addMember(2);
		doubleSet1.addMember(-3);

		//{ {1:2} , {2:1} , {-3,1} } 
		DoubleSet doubleSet2 = new DoubleSet();
		
		doubleSet2.addMember(1);
		doubleSet2.addMember(1);
		doubleSet2.addMember(2);
		doubleSet2.addMember(-3);
		
		//{ {1:2} , {2:2} , {-3,2} }
		DoubleSet sum = DoubleSetUtil.addMembers(doubleSet1, doubleSet2);
		
		Assert.assertEquals(sum.getMembers().size() ,3);
		Assert.assertTrue(sum.getMembers().get(1) == 2);
		Assert.assertTrue(sum.getMembers().get(2) == 2);
		Assert.assertTrue(sum.getMembers().get(-3) == 2);
		
	}

	@Test
	public void testAddingTwoMembersWithUnEqualSizes() {
		
		DoubleSet doubleSet1 = new DoubleSet();
		//{ {1:1} , {2:1} } 
		doubleSet1.addMember(1);
		doubleSet1.addMember(2);
		//{ {1:1} , {2:1} , {-3,1} } 
		DoubleSet doubleSet2 = new DoubleSet();
		doubleSet2.addMember(1);
		doubleSet2.addMember(2);
		doubleSet2.addMember(-3);
		//{ {1:2} , {2:2} , {-3,1} }
		DoubleSet sum = DoubleSetUtil.addMembers(doubleSet1, doubleSet2);
		Assert.assertEquals(sum.getMembers().size() ,3);
		Assert.assertTrue(sum.getMembers().get(1) == 2);
		Assert.assertTrue(sum.getMembers().get(2) == 2);
		Assert.assertTrue(sum.getMembers().get(-3) == 1);
		
	}

	@Test
	public void testAddingTwoMembersWithUnEqualSizesSequenceReversed() {
		
		DoubleSet doubleSet2 = new DoubleSet();
		//{ {1:1} , {2:1} } 
		doubleSet2.addMember(1);
		doubleSet2.addMember(2);
		//{ {1:1} , {2:1} , {-3,1} } 
		DoubleSet doubleSet1 = new DoubleSet();
		doubleSet1.addMember(1);
		doubleSet1.addMember(2);
		doubleSet1.addMember(-3);
		//{ {1:2} , {2:2} , {-3,1} }
		DoubleSet sum = DoubleSetUtil.addMembers(doubleSet1, doubleSet2);
		Assert.assertEquals(sum.getMembers().size() ,3);
		Assert.assertTrue(sum.getMembers().get(1) == 2);
		Assert.assertTrue(sum.getMembers().get(2) == 2);
		Assert.assertTrue(sum.getMembers().get(-3) == 1);
		
	}

	@Test
	public void testSubtractingTwoMembersWithEqualSizes() {
		
		DoubleSet doubleSet1 = new DoubleSet();
		// {{1: 2}, {2: 1}, {4: 1}}
		doubleSet1.addMember(1);
		doubleSet1.addMember(1);
		doubleSet1.addMember(2);
		doubleSet1.addMember(4);
		
		//{{1: 1}, {2: 2}, {-3: 1}}
		DoubleSet doubleSet2 = new DoubleSet();
		doubleSet2.addMember(1);
		doubleSet2.addMember(2);
		doubleSet2.addMember(2);
		doubleSet2.addMember(-3);
		
		//{ {1:1} , {4,1} }
		DoubleSet minus = DoubleSetUtil.subtractMembers(doubleSet1, doubleSet2);
		Assert.assertEquals(minus.getMembers().size() ,2);
		Assert.assertTrue(minus.getMembers().get(1) == 1);
		Assert.assertTrue(minus.getMembers().get(4) == 1);
		
	}

	@Test
	public void testSubtractingTwoMembersWithUnEqualSizes() {
		
		DoubleSet doubleSet1 = new DoubleSet();
		// {{1: 2}, {2: 1}, {4: 1}, {7:1}}
		doubleSet1.addMember(1);
		doubleSet1.addMember(1);
		doubleSet1.addMember(2);
		doubleSet1.addMember(4);
		doubleSet1.addMember(7);
		
		//{{1: 1}, {2: 2}, {-3: 1}}
		DoubleSet doubleSet2 = new DoubleSet();
		doubleSet2.addMember(1);
		doubleSet2.addMember(2);
		doubleSet2.addMember(2);
		doubleSet2.addMember(-3);
		
		//{ {1:1} , {4,1} ,{7:1}}
		DoubleSet minus = DoubleSetUtil.subtractMembers(doubleSet1, doubleSet2);
		Assert.assertEquals(minus.getMembers().size() ,3);
		Assert.assertTrue(minus.getMembers().get(1) == 1);
		Assert.assertTrue(minus.getMembers().get(4) == 1);
		Assert.assertTrue(minus.getMembers().get(7) == 1);
		
	}

}
