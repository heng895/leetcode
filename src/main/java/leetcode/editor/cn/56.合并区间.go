/*
 * @lc app=leetcode.cn id=56 lang=golang
 *
 * [56] 合并区间
 */

// @lc code=start
func merge(intervals [][]int) [][]int {
	if len(intervals) <= 1 {
		return intervals
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	pair := intervals[0]
	res := make([][]int, 0)
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] > pair[1] {
			res = append(res, pair)
			pair = intervals[i]
		} else {
			pair[1] = max(pair[1], intervals[i][1])
		}
	}
	res = append(res, pair)
	return res
}

// @lc code=end

