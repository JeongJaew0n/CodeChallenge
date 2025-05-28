// 빈도수 세기
function sameFrequency(a, b) {
    if (a.length !== b.length) {
        return false
    }

    a = a + ""
    b = b + ""

    obj = {}
    for (let i=0; i<a.length; i++) {
        const c = a.charAt(i);
        obj[c] = obj[c] + 1 || 1
    }

    for (let i=0; i<b.length; i++) {
        const c = b.charAt(i);
        obj[c] = obj[c] - 1 ?? -1
        if (!(obj[c] >= 0)) {
            return false
        }
    }
    return true
}

// 빈도수 세기 / 다중 포인터
// 1. 빈도수
function areThereDuplicates(...args) {
    let obj = {}
    for (let arg of args) {
        console.log('arg:', arg)
        if (obj[arg]) {
            return true
        } else {
            obj[arg] = 1
        }
    }
    return false;
}
// 2. 다중 포인터
// 정렬 이후 2개 포인터 쓰면됨.
// 3. one line
// Set 쓰면됨.
function areThereDuplicates(...args) {

}


// 다중 포인터 - averagePair
function averagePair(arr, average){
    if (arr.length <= 1){
        return false;
    }
    
    let left = 0;
    let right = arr.length;
    const goal = average * 2;
    while (left !== right) {
        const sum = arr[left] + arr[right];
        if (sum === goal) {
            return true
        }
        sum < goal ? left++ : right--;
    }

    return false;
}


// 다중 포인터 - isSubsequence
function isSubsequence(str1, str2) {
}

// Sliding Window - maxSubarraySum
function maxSubarraySum(arr, n){
    if (arr.length < n) {
        return null;
    }

    let max = 0;
    for (let i=0; i<n; i++) {
        max += arr[i]
    }
    let temp = max;
    for (let i=n; i<arr.length; i++) {
        temp -= arr[i-n];
        temp += arr[i];
        if (temp > max) {
            max = temp;
        }
    }
    return max;
}

// Sliding Window - minSubArrayLen
function minSubArrayLen(arr, n) {
    if (arr.length < 1) {
        return 0
    }
    let len = arr.length;
    let minIndex = 0;
    let minCount = len+1;
    let sum = 0;
    for(let i=0; i<len; i++) {
        if (arr[i] >= n) {
            return 1;
        }
        sum += arr[i]
        if (sum >= n) {
            let temp = sum;
            while (temp >= n) {
                temp -= arr[minIndex];
                if (temp >= n) {
                    sum -= arr[minIndex++];
                }
            }

            let count = (i - minIndex) + 1;
            if (count < minCount) {
                minCount = count;
            }
        }
    }

    return minCount > len ? 0 : minCount;
}

// Sliding Window - findLongestSubstring
function findLongestSubstring(str){
    obj = {};
    for (let i=0; i<str.length; i++) {
        c = str.charAt(i);
        
        obj[c] = i;
    }
}