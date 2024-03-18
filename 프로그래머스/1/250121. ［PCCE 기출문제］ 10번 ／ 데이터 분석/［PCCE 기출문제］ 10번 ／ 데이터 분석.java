import java.util.*;
class Solution {
    int sort_by_Num = 0; // sortBy 인덱스 
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        String[] dataArr = {"code","date","maximum","remain"};
        int extNum = 0; // ext의 인덱스 
        
        for(int i =0; i<dataArr.length; i++) {
            if(dataArr[i].equals(ext)) {
                extNum = i;
            }
            if(dataArr[i].equals(sort_by)) {
                sort_by_Num = i;
            }
        }
        
        List<Integer[]> dataList = new ArrayList<>();
        for(int i =0; i<data.length; i++) {
            if(data[i][extNum] < val_ext) {
                dataList.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
            }
        }
        
        Collections.sort(dataList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] arr1, Integer[] arr2) {
                // 특정 인덱스의 값으로 비교하여 정렬
                return Integer.compare(arr1[sort_by_Num], arr2[sort_by_Num]);
            }
        });

        int[][] answer = new int[dataList.size()][dataList.get(0).length];
        for (int i = 0; i < dataList.size(); i++) {
            answer[i] = Arrays.stream(dataList.get(i))
                               .mapToInt(Integer::intValue)
                               .toArray();
        }
        
        return answer;
    }
    

}