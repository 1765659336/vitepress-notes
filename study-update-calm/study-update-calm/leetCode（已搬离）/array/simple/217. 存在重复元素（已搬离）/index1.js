const nums = [1, 2, 3, 1];
const nums2 = [1, 2, 3];
/* // 依然还是握手题
    var containsDuplicate = function(nums) {
        for (let i = 0; i < nums.length; i++) {
            for (let j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true
                }
            }
        }
        return false
    }; */

/* var containsDuplicate = function(nums) {
    // jsSet有去重效果
    return new Set(nums).size == nums.length;
}; */

/* var containsDuplicate = function(nums) {
    // js对象属性具有唯一性
    let obj = {};
    for (const iterator of nums) {
        obj[iterator] = iterator;
    }
    return Object.keys(obj).length == nums.length;
}; */

/* var containsDuplicate = function(nums) {
    // 遍历判断新数组中是否有值,不重复添加值，最后判断新数组和数组长度是否相等
    let arr = [];
    nums.forEach(function(item) {
        if (arr.indexOf(item) == -1) {
            arr.push(item);
        }
    })
    return arr.length == nums.length;
} */

var containsDuplicate = function(nums) {
    // 先排序，再判断相邻项是否相等
    nums.sort();
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] == nums[i + 1]) {
            return true;
        }
    }
    return false;
};

console.log(containsDuplicate(nums));
console.log(containsDuplicate(nums2));