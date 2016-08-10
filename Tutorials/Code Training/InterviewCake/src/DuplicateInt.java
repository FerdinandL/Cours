
public class DuplicateInt {

	// XOR successively all the integers ==> O(n) time and O(1) space
	public int findUniqueDeliveryId(int[] deliveryIds) {

		int uniqueDeliveryId = 0;

		for (int i = 0; i < deliveryIds.length; i++) {
			uniqueDeliveryId ^= deliveryIds[i];
		}

		return uniqueDeliveryId;
	}
}
