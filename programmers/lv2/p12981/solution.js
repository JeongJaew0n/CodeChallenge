function solution(n, words) {

    let preWord = words[0];
    let talkedWord = [preWord];
    for(let i = 1; i<words.length; i++) {
        const word = words[i];

        let failFlag = word.length <= 1 || preWord[preWord.length-1] !== word[0] || talkedWord.includes(word)

        if(failFlag) {
            return [i%n+1, parseInt(i/n+1)];
        }

        talkedWord.push(word);
        preWord = word;
    }

    return [0,0];
}