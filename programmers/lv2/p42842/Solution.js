function solution(brown, yellow) {
    var answer = [];

    // 문제 있는 로직.
    // if(yellow % 2 === 1) {
    //     answer.push(yellow+2);
    //     answer.push(3);
    //     return answer;
    // }

    let row = yellow, col = 1;
    while(true) {
        if(brown === (row+2) * 2 + col * 2)  {
            answer.push(row+2);
            answer.push(col+2);
            return answer;
        }
        do{
            col++;
            row = yellow/col;
        }while(yellow%col !== 0)

        if(col > row) {
            break;
        }
    }
}

console.log(solution(24, 24));