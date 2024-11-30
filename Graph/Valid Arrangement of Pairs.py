#Solution
class Solution:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        graph = defaultdict(list)
        inOutDeg = defaultdict(int)

        for start, end in pairs:
            graph[start].append(end)
            inOutDeg[start] += 1  # out-degree
            inOutDeg[end] -= 1    # in-degree

        startNode = pairs[0][0] 
        for node in inOutDeg:
            if inOutDeg[node] == 1:
                startNode = node
                break

        path = []
        def dfs(curr):
            while graph[curr]:
                nextNode = graph[curr].pop()
                dfs(nextNode)
                path.append((curr, nextNode))

        dfs(startNode)
        return path[::-1]

# Example 1:

# Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
# Output: [[11,9],[9,4],[4,5],[5,1]]
# Explanation:
# This is a valid arrangement since endi-1 always equals starti.
# end0 = 9 == 9 = start1 
# end1 = 4 == 4 = start2
# end2 = 5 == 5 = start3
# Example 2:

# Input: pairs = [[1,3],[3,2],[2,1]]
# Output: [[1,3],[3,2],[2,1]]
# Explanation:
# This is a valid arrangement since endi-1 always equals starti.
# end0 = 3 == 3 = start1
# end1 = 2 == 2 = start2
# The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
# Example 3:

# Input: pairs = [[1,2],[1,3],[2,1]]
# Output: [[1,2],[2,1],[1,3]]
# Explanation:
# This is a valid arrangement since endi-1 always equals starti.
# end0 = 2 == 2 = start1
# end1 = 1 == 1 = start2

