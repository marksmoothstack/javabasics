package com.ss.jb.five;

import java.util.ArrayList;
import java.util.Collections;

public class PartFive {

	// take in start, array of integers, and target number
	public static boolean groupSumClump(Integer start, ArrayList<Integer> nums, Integer target) {

		// call helper method
		helperGroupSumClump(nums);
		
		// check if start is beyond or equal to list size
		if (start >= nums.size())
			return target == 0;

		// recursively move start forward and adjust target
		if (groupSumClump(start + 1, nums, target - nums.get(start)))
			return true;

		// recursively move start forward
		if (groupSumClump(start + 1, nums, target))
			return true;

		else
			return false;

	}

	private static void helperGroupSumClump(ArrayList<Integer> nums) {

		// iterate through array list
		for (int i = 0; i < nums.size() - 1; i++) {

			// check if index is more than 0 and if current integer and next integer are identical
			if (i > 0 && nums.get(i) == nums.get(i + 1)) {

				// set next integer to the sum of the current and the next
				nums.set(i + 1, nums.get(i + 1) + nums.get(i));

				// check if the next index is out of bounds and if current and next integers are identical
				if (i + 1 < nums.size() && nums.get(i) != nums.get(i + 1))
					
					// set current integer to 0
					nums.set(i, 0);
				
				// check if current location is the final index
				else if (i == nums.size() - 1)
					// set current index to 0
					nums.set(i, 0);

			}

		}

	}

	public static void main(String[] args) {

		// Generate array list and fill with integers
		ArrayList<Integer> i = new ArrayList<Integer>();
		Collections.addAll(i, 2, 4, 8);

		// Display result of groupSumClump method
		System.out.println(groupSumClump(0, i, 10));
	}

}
