// 40kg 이상 240이하.
function solution(people, limit) {
    let count = 0;

    let filteredArr = [];

    filteredArr = people.sort((a,b) => b-a);

    let j = filteredArr.length-1;
    for(let i = 0; i<=j; i++) {
        let sumOfWeight = filteredArr[i];
        if(sumOfWeight + filteredArr[j] <= limit) {
            sumOfWeight += filteredArr[j];
            j--;
        }
        count++;
    }

    return count;
}