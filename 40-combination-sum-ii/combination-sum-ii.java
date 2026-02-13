class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void solve(int[] a, int target, int index,
                      List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < a.length; i++) {
            if (i > index && a[i] == a[i - 1]) continue;
            if (a[i] > target) break;

            tempList.add(a[i]);
            solve(a, target - a[i], i + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}