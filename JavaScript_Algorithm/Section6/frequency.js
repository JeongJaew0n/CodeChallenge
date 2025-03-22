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