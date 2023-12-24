function solution(n)
{
    return  n.toString(2).match(/1/g).filter(one => one).length;
}