const solve = (arr1, arr2) => {
    if (arr1.length !== arr2.length) {
        return false;
    }
    obj = {};
    for(c in arr1) {
        // 만약 obj가 c를 가지고 있다면
        // obj[c]++
        // 안가지고 잇으면
        // obj[c]--
    }

    // arr2 요소를 for문 돌면서 obj[c2]--.
    // 만약 obj[c2]-- 했는데 결과 값이 undefined 혹은 음수다. 이러면 종료.
    // 무사히 다 돌면 true
}