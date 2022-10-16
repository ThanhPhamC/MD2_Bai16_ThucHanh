package bai2;

import java.util.List;

public class FindMaxValue {
        public static int finmax(List<Integer> numbers){
            int max=numbers.get(0);
            for (int i = 0; i < numbers.size(); i++) {
                if (max<numbers.get(i)){
                    max=numbers.get(i);
                }
            }
            return max;
        }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile=new ReadAndWriteFile();
        String intputString="/Users/phamthanh/Desktop/JaVa/Bai16/ThucHanh/test.txt";
        String outputString="/Users/phamthanh/Desktop/JaVa/Bai16/ThucHanh/testbai2";
        List<Integer> numbers=readAndWriteFile.readFileText(intputString);
        int max= finmax(numbers);
        readAndWriteFile.writeFile(outputString, max);
    }
}
