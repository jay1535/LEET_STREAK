class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int s1 = firstList[i][0];
            int s2 = secondList[j][0];
            int e1 = firstList[i][1];
            int e2 = secondList[j][1];

//                  intersection condition 
            if (e1 >= s2 && e2 >= s1) {
                list.add(new int[] {
                        Math.max(s1, s2),
                        Math.min(e1, e2)
                });
            }
                 // for not intersection condtion               
            if (e2 > e1) {
                i++;
            } else {
                j++;
            }

        }

        int[][] res = new int[list.size()][2];

        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }

        return res;
    }

}