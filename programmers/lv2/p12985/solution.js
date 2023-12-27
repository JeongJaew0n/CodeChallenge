function solution(n,a,b)
{
    let nextA = a, nextB = b, round = 0;
    do {
         nextA = Math.ceil(nextA / 2);
         nextB = Math.ceil(nextB / 2);
        round++;
    } while(nextA!==nextB);

    return round;
}

function solution2(n,a,b) {
    let mid = n/2 + 0.5;

    if((a < mid && b > mid) || (a > mid && b < mid)) {
        return Math.log2(n);
    } else {
        if(a > mid) {
            solution2((n + mid + 0.5)/2)
        }
    }
}