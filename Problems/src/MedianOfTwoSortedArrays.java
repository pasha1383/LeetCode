import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2 .length;
        int[] arr = new int[len];
        int sum = 0;
        int fp= 0;
        int sp= 0;
        int ap =0;
        while (fp < nums1.length && sp < nums2.length) {
            if(nums1[fp] > nums2[sp]) {
                sum += nums2[sp];
                arr[ap] = nums2[sp];
                sp++;
            }else {
                sum += nums1[fp];
                arr[ap] = nums1[fp];
                fp++;
            }
            ap++;
        }

        while(fp < nums1.length) {
            sum += nums1[fp];
            fp++;
        }

        while(sp < nums2.length) {
            sum += nums2[sp];
            sp++;
        }

        return len % 2 != 0 ? arr[len/2] : (double) sum /len;
    }
}
