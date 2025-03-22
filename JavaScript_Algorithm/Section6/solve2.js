function solve(array) {
    let left = 0;
    let right = 1;
    let count = 1;

    const len = array.length
    if (len <= 1) {
        return len;
    }

    while (right < len) {
        if (array[left] == array[right]) {
            right++;
        } else {
            left = right++;
            count++;
        }
    }
    
    return count;
}

function sovleGood(array) {
    let i = 0;
    for (j=1; j<array.length; j++) {
        if (array[i] !== array[j]) {
            i++;
            arrary[i] = arrary[j]
        }
    }

    return i+1;
}