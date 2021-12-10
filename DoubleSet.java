package com.aspiration.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * A DoubleSet is a collection whose members are integers, and who can have one or two of each member. 
 * We express them below in
 * maplike notation, ie the DoubleSet that has two 1s, one -3, and one 0 is represented as

{{1: 2}, {-3: 1}, {0: 1}}

If a DoubleSet has two of member 1, we may not add a third. If a
DoubleSet has zero of member 3, we may not take any away, because there is nothing to take away from.

We add two DoubleSets by adding each of their members, each of whose count can be no greater than two:

doubleSetOne has members

{{1: 2}, {2: 1}}

and doubleSetTwo has members

{{1: 1}, {2: 1}, {-3: 1}}

their sum is

{{1: 2}, {2: 2}, {-3: 1}}

We subtract two DoubleSets by subtracting each of their counts, where elements whose counts fall below one are removed
from the DoubleSet entirely:

doubleSetOne has members

 {{1: 2}, {2: 1}, {4: 1}}

and doubleSetTwo has members

{{1: 1}, {2: 2}, {-3: 1}}

their difference is

{{1: 1}, {4: 1}}

*/
public class DoubleSet {

private Map<Integer,Integer> members = new HashMap<Integer, Integer>();

private final static int MAX_NUMBER_COUNT_PERMITTED = 2;
	
	public void addMember(int key) {
		if (members.containsKey(key)) {
			members.put(key, Math.min(MAX_NUMBER_COUNT_PERMITTED, members.get(key) + 1));
		} else {
			members.put(key, 1);
		}
	}
	
	public Map<Integer,Integer> getMembers() {
		return this.members;
	}

}
