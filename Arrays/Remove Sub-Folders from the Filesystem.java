//Solution

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        
  
        for (int i = 1; i < folder.length; i++) {
            
            String lastFolder = ans.get(ans.size() - 1) + "/";
            
         
            if (!folder[i].startsWith(lastFolder)) {
                ans.add(folder[i]);
            }
        }
        
        return ans;
    }
}

/*

Example 1:
Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.

Example 2:
Input: folder = ["/a","/a/b/c","/a/b/d"]
Output: ["/a"]
Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".

Example 3:
Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
Output: ["/a/b/c","/a/b/ca","/a/b/d"]

*/
