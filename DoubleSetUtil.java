package com.aspiration.collection;

/**
 * Util class to perform addition and subtraction for DoubleSet class
 * @author siddharthyadav
 *
 */
public class DoubleSetUtil {
	
	/**
	 * Takes 2 argument and returns a new instance of DoubleSet which is addition of the 2 
	 * DoublseSets arguments passed.  
	 * @param doubleSet1
	 * @param doubleSet2
	 * @return DoubleSet
	 */
	public static DoubleSet addMembers(DoubleSet doubleSet1, DoubleSet doubleSet2) {

		DoubleSet sum = new DoubleSet();
		
		if(doubleSet1 == null || doubleSet2 == null) {
			return sum;
		}

		if (doubleSet1.getMembers().size() <= doubleSet2.getMembers().size()) {

			performAddition(doubleSet1, doubleSet2, sum);

		} else if (doubleSet1.getMembers().size() > doubleSet2.getMembers().size()) {

			performAddition(doubleSet2, doubleSet1, sum);
		}
		return sum;
	}

	private static void performAddition(DoubleSet doubleSet1, DoubleSet doubleSet2, DoubleSet sum) {
		for (int memberKey : doubleSet2.getMembers().keySet()) {
				
				if(doubleSet1.getMembers().containsKey(memberKey)) {
					sum.getMembers().put(memberKey, 2);
				}
				else {
					sum.getMembers().put(memberKey,doubleSet2.getMembers().get(memberKey));
				}
			}
	}

	/**
	 * Method to perform subtraction of doubleSet2 from doubleSet1 and returns a new instance 
	 * Double Set which is the result if the subtraction operation doubleSet1 - doubleSet2
	 * @param doubleSet1
	 * @param doubleSet2
	 * @return DoubleSet
	 */
	public static DoubleSet subtractMembers(DoubleSet doubleSet1, DoubleSet doubleSet2) {

		DoubleSet minus = new DoubleSet();
		
		if(doubleSet1 == null || doubleSet2 == null) {
			return minus;
		}
		
           for (int memberKey : doubleSet1.getMembers().keySet()) {
				
				if(doubleSet2.getMembers().containsKey(memberKey)) {
					
					int value = doubleSet1.getMembers().get(memberKey) 
							     - doubleSet2.getMembers().get(memberKey);
					
					if(value > 0) {
					  minus.getMembers().put(memberKey, value);
					}
				}
				else {
						minus.getMembers().put(memberKey, doubleSet1.getMembers().get(memberKey));
				}
			}
		return minus;
	}

}
