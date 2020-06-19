package com.ipokusaev.fxpro;

/**
 * The main idea:
 *
 * We can say that the `i` value is a pit only if it's limited on both sides (left and right).
 * This value is limited on the left side if max left height less than the current. And the same for the right side.
 *
 * Water level under the left pointer is limited by the left max height.
 * If the max left height is less than the max right height, then this is the actual water level in the current cell.
 * If the max left height is more than the max right height, it means that the max possible water level in the cell is this max left height.
 * But we don't know the exact right limit.
 * Therefore, we need to find out this right limit.
 * For this, we will move the right pointer to the right until we reach a value greater than the max left height (the new max right height).
 * The same for the right pointer.
 */
public class Solution {

    /**
     * Max available landscape width.
     */
    public static final long MAX_WIDTH = 32000;

    /**
     * Max available landscape height.
     */
    public static final long MAX_HEIGHT = 32000;

    /**
     * Calculates the water amount on the landscape after the rain.
     *
     * @param   landscape   an array representing landscape (array of heights).
     * @return  water amount on the landscape after the rain.
     */
    public long calculateWaterAmount(int[] landscape) {
        validateLandscape(landscape);

        long amount = 0;

        int left = 0;
        int right = landscape.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, landscape[left]);
            rightMax = Math.max(rightMax, landscape[right]);

            if (leftMax < rightMax) {
                amount += leftMax - landscape[left];
                left++;
            } else {
                amount += rightMax - landscape[right];
                right--;
            }
        }

        return amount;
    }

    /**
     * Validates given landscape.
     *
     * @param landscape given landscape.
     */
    private void validateLandscape(int[] landscape) {
        assert landscape.length <= MAX_WIDTH
                : String.format("Landscape should not be wider than %d. %d given.", MAX_WIDTH, landscape.length);

        for (int height : landscape) {
            assert height >= 0 && height <= MAX_HEIGHT
                    : String.format("Landscape high should be in range [0, %d]. %d given.", MAX_HEIGHT, height);
        }
    }
}
