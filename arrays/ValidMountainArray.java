public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArraySolution sol = new ValidMountainArraySolution();
        int arr[] = {2,1,2,3,5,7,9,10,12,14,15,16,18,14,13};
        boolean result = sol.validMountainArray(arr);
        System.out.println("Result is");
        System.out.println(result);
    }
}

class ValidMountainArraySolution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        boolean startedWithGrowing = false;
        boolean passedExtremum = false;
        
        int previousValue = arr[0];
        for (int index = 1; index < arr.length; index++) {
            int currentValue = arr[index];
            if (passedExtremum && currentValue >= previousValue) {
                return false;
            } else {
                if (!startedWithGrowing && currentValue > previousValue) {
                    startedWithGrowing = true;
                } else if (!startedWithGrowing && currentValue <= previousValue) {
                    return false;
                } else if (startedWithGrowing && currentValue < previousValue) {
                    passedExtremum = true;
                } else  if (currentValue == previousValue) {
                    return false;
                }
            }
            previousValue = currentValue;
        }

        return startedWithGrowing && passedExtremum;
    }
}