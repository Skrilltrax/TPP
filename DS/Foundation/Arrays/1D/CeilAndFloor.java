public class CeilAndFloor {

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
        ceilFloor(arr, 7);
    }
    
    public static void ceilFloor(int[] arr, int k) {
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
    
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > k && arr[i] < ceil) {
                ceil = arr[i];
            }

            if (arr[i] < k && arr[i] > floor) {
                floor = arr[i];
            }
        }

        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}