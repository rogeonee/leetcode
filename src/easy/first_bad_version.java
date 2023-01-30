package easy;

public class first_bad_version {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while(low <= high) {
            int mid = (low + (high - low) / 2);
        
            if(isBadVersion(mid) == false) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

}
